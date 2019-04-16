package customer.supu.mapper;

import customer.supu.domain.CoachBean;
import customer.supu.po.CourseCoach;
import customer.supu.po.CourseCoachExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourseCoachMapper {
    int countByExample(CourseCoachExample example);

    int deleteByExample(CourseCoachExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseCoach record);

    int insertSelective(CourseCoach record);

    List<CourseCoach> selectByExample(CourseCoachExample example);

    CourseCoach selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseCoach record, @Param("example") CourseCoachExample example);

    int updateByExample(@Param("record") CourseCoach record, @Param("example") CourseCoachExample example);

    int updateByPrimaryKeySelective(CourseCoach record);

    int updateByPrimaryKey(CourseCoach record);

    /*
     * @author ll
     * @Description 根据课程查询私教
     * @date 2018/8/28 15:10
     * @param [map]
     * @return java.util.List<customer.supu.domain.CoachBean>
     */
    List<CoachBean> queryCourseCoachByPri(Map<String , Object> map);
}