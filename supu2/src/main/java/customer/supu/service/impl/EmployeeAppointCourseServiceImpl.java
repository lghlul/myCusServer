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
import customer.supu.dao.EmployeeAppointCourseDao;
import customer.supu.dto.EmployeeAppointCourseDto;
import customer.supu.po.CourseCoach;
import customer.supu.po.CourseCoachExample;
import customer.supu.service.EmployeeAppointCourseService;
import customer.supu.service.F_AboutClassService;

@Service
public class EmployeeAppointCourseServiceImpl implements EmployeeAppointCourseService{

	@Autowired
	private CourseCoachDao courseCoachDao;

	@Autowired
	private F_AboutClassService f_AboutClassService;

	@Autowired
	private EmployeeAppointCourseDao employeeAppointCourseDao;

	/**
	 * 根据条件查询所有订单
	 * @param page  分页参数
	 * @param orderDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageResponse selectAllByList(Page page, EmployeeAppointCourseDto employeeAppointCourseDto ) throws Exception {
		PageResponse pageResponse=new PageResponse();
		//查询调件
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", Integer.parseInt(page.getOffset()));
		map.put("end", Integer.parseInt(page.getLimit()));
		//判断用户名是否为空
		if (StringUtils.hasText(employeeAppointCourseDto.getUsername())) {
			map.put("username", "%"+employeeAppointCourseDto.getUsername()+"%");
		}
		if (StringUtils.hasText(employeeAppointCourseDto.getCoursename())) {
			map.put("coursename", "%"+employeeAppointCourseDto.getCoursename()+"%");
		}
		//判断教练是否为空
		if (employeeAppointCourseDto.getCoachname()!=null) {
			map.put("coachId", employeeAppointCourseDto.getCoachname());
		}
		//判断类型是否为空
		if (employeeAppointCourseDto.getType()!=null) {
			map.put("type", employeeAppointCourseDto.getType());
		}
		if (employeeAppointCourseDto.getStatus()!=null) {
			map.put("status", employeeAppointCourseDto.getStatus());
		}
		//查询
		List<EmployeeAppointCourseDto> list=employeeAppointCourseDao.selectEmpAppCourseByList(map);
		//循环list
		for (int i = 0; i < list.size(); i++) {
			EmployeeAppointCourseDto appointCourseDto=list.get(i);
			appointCourseDto.setCoachnames(selectCourseCoachByCid(appointCourseDto.getCourseid(),appointCourseDto.getType()));
		}
		//查询总数
		Integer count=employeeAppointCourseDao.countByList(map);
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
