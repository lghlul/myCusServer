package customer.supu.mapper;

import customer.supu.po.CourseStores;
import customer.supu.po.CourseStoresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseStoresMapper {
    int countByExample(CourseStoresExample example);

    int deleteByExample(CourseStoresExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseStores record);

    int insertSelective(CourseStores record);

    List<CourseStores> selectByExample(CourseStoresExample example);

    CourseStores selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseStores record, @Param("example") CourseStoresExample example);

    int updateByExample(@Param("record") CourseStores record, @Param("example") CourseStoresExample example);

    int updateByPrimaryKeySelective(CourseStores record);

    int updateByPrimaryKey(CourseStores record);
}