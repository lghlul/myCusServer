package com.answer.service.impl;

import com.answer.CacheHelper;
import com.answer.common.CommonConstant;
import com.answer.domain.OrgReport;
import com.answer.domain.TJobnum;
import com.answer.domain.TOrganization;
import com.answer.domain.TUser;
import com.answer.domain.query.JobNumQuery;
import com.answer.domain.query.OrgReportQuery;
import com.answer.mapper.TJobnumMapper;
import com.answer.mapper.TUserAnswerMapper;
import com.answer.mapper.TUserMapper;
import com.answer.service.ITJobnumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class TJobnumServiceImpl extends BaseServiceImpl<TJobnum> implements ITJobnumService{

    @Autowired
    private TJobnumMapper jobnumMapper;
    @Autowired
    private CacheHelper cacheHelper;

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserAnswerMapper userAnswerMapper;

    @Override
    public PageInfo<TJobnum> list(JobNumQuery jobNumQuery) {
        PageHelper.startPage(jobNumQuery.getOffset(), jobNumQuery.getLimit());
        if (jobNumQuery.getSortField() != null) {
            PageHelper.orderBy(jobNumQuery.getSortField() + " " + jobNumQuery.getSortDir());
        }
        List<TJobnum> jobnums = this.jobnumMapper.list(jobNumQuery );
        PageInfo<TJobnum> pageInfo = new PageInfo<>(jobnums);
        if (pageInfo.getList() != null) {
            for(TJobnum tJobnum : pageInfo.getList()){
                TOrganization org = cacheHelper.getOrg(tJobnum.getOrgID());
                if(org != null){
                    tJobnum.setOrgName(org.getOrgName());
                }
            }
        }
        return pageInfo;
    }

    @Override
    public TJobnum selectByJobNum(String jobNum) {
        return jobnumMapper.selectByJobNum(jobNum);
    }


    @Override
    public int edit(TJobnum jobNum) {
        TJobnum tJobnum = jobnumMapper.selectByJobNum(jobNum.getJobNum());
        if(tJobnum.getStatus() == CommonConstant.Common.JOBNUM_BIND){
            //工号已经被绑定
            if(jobNum.getOrgID() != tJobnum.getOrgID()){
                //组织机构发生改变  修改已经答过题的组织机构 以便单位统计考核

                //获取绑定的用户信息
                TUser tUser = userMapper.readByJobNum(jobNum.getJobNum());
                Map<String , Object> map = new HashMap<>();
                map.put("openID" , tUser.getOpenID());
                map.put("orgID" , jobNum.getOrgID());
                userAnswerMapper.updateOrgID(map);
            }
        }
        return jobnumMapper.update(jobNum);
    }


    @Override
    public int deleteById(String id) {
        TJobnum tJobnum = jobnumMapper.selectById(id);
        //查询用户
        TUser tUser = userMapper.readByJobNum(tJobnum.getJobNum());
        if(tUser != null){
            //删除答题
            Map<String , Object> map = new HashMap<>();
            map.put("openID" , tUser.getOpenID());
            userAnswerMapper.deleteByMap(map);

            //用户工号解绑  已经积分清空
            userMapper.updateJobNum(tUser.getOpenID());
        }
        jobnumMapper.deleteById(id);

        return super.deleteById(id);
    }
}
