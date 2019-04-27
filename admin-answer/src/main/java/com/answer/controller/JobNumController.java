package com.answer.controller;

import com.answer.common.CommonConstant;
import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TJobnum;
import com.answer.domain.query.JobNumQuery;
import com.answer.service.ITJobnumService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/27 19:53
 * @Modified By：
 */
@RestController
@RequestMapping("/jobNum")
public class JobNumController {

    @Autowired
    private ITJobnumService jobNumService;

    @GetMapping("list")
    public Object list(JobNumQuery jobNumQuery) {
        PageInfo<TJobnum> page = jobNumService.list(jobNumQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }

    @PostMapping("save")
    public Object list(TJobnum jobNum) {

        TJobnum tJobnum = jobNumService.selectByJobNum(jobNum.getJobNum());
        if(tJobnum != null){
            return ResultCodeEnum.JOBNUM_REPEAT.getResponse();
        }

        jobNum.setStatus(CommonConstant.Common.JOBNUM_UN_BIND);
        jobNumService.add(jobNum);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

    @PostMapping("update")
    public Object update(TJobnum jobNum) {
        jobNumService.edit(jobNum);
        return ResultCodeEnum.SUCCESS.getResponse();
    }
}
