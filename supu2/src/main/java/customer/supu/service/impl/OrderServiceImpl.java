package customer.supu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.CourseCoachDao;
import customer.supu.dao.OrderDao;
import customer.supu.dto.OrderDto;
import customer.supu.po.CourseCoach;
import customer.supu.po.CourseCoachExample;
import customer.supu.service.F_AboutClassService;
import customer.supu.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private CourseCoachDao courseCoachDao;

	@Autowired
	private F_AboutClassService f_AboutClassService;

	/**
	 * 根据条件查询所有订单
	 * @param page  分页参数
	 * @param orderDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageResponse selectAllByList(Page page, OrderDto orderDto) throws Exception {
		PageResponse pageResponse=new PageResponse();
		//查询调件
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", Integer.parseInt(page.getOffset()));
		map.put("end", Integer.parseInt(page.getLimit()));
		//判断用户名是否为空
		if (StringUtils.hasText(orderDto.getEcode())) {
			map.put("ecode", "%"+orderDto.getEcode()+"%");
		}
		//判断是否支付是否为空
		if (orderDto.getIssuccess()!=null) {
			map.put("issuccess", orderDto.getIssuccess());
		}
		//判断开始时间是否为空
		if (StringUtils.hasText(orderDto.getStarttime())) {
			map.put("starttime", orderDto.getStarttime());
		}
		//判断结束时间是否为空
		if (StringUtils.hasText(orderDto.getEndtime())) {
			map.put("endtime", orderDto.getEndtime());
		}
		//判断类型是否为空
		if (orderDto.getType()!=null) {
			map.put("type", orderDto.getType());
		}
		//查询
		List<OrderDto> list=orderDao.selectOrderByList(map);
		//循环list
		for (int i = 0; i < list.size(); i++) {
			OrderDto dto=list.get(i);
			//根据type,cid查询该课程下所有教练
			if (dto.getType()==1) {
				dto.setCoachnames(selectCourseCoachByCid(dto.getCid(),0));
			}else if(dto.getType()==2){
				dto.setCoachnames(selectCourseCoachByCid(dto.getCid(),1));
			}else if(dto.getType()==3){
				dto.setCoachnames(selectCourseCoachByCid(dto.getCid(),2));
			}
		}
		//查询总数
		Integer count=orderDao.countByList(map);
		pageResponse.setRecords(list);
		pageResponse.setTotal(count);
		return pageResponse;
	}


	/**
	 * 拼接教练名称
	 * @param courseId 课程id
	 * @param type 课程类型
	 * @return
	 * @throws Exception
	 */
	public String selectCourseCoachByCid(Integer courseId,Integer type)throws Exception {
		CourseCoachExample example=new CourseCoachExample();
		//给查询条件赋值
		example.createCriteria().andCourseidEqualTo(courseId).andTypeEqualTo(type);
		//查询
		List<CourseCoach> courseCoachs=courseCoachDao.selectByExample(example);
		StringBuffer buffer=new StringBuffer();
		//判断不为空
		if (CollectionUtils.isNotEmpty(courseCoachs)) {
			//循环获取教练名称
			for (int i = 0; i < courseCoachs.size(); i++) {
				CourseCoach courseCoach=courseCoachs.get(i);
				//查询教练名称
				String name=f_AboutClassService.getCoachnameById(courseCoach.getCoachid().toString());
				if(StringUtils.hasText(name)){
				//拼接coachname
					buffer.append(name+",");
				}
			}
		      if(StringUtils.hasText(buffer.toString())){
		    	  return  buffer.substring(0, buffer.length()-1);
		      }else{
		    	  return null;
		      }

		}
		return null;

	}


}
