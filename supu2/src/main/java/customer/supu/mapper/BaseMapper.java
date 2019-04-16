package customer.supu.mapper;

import java.util.List;

public interface BaseMapper<T> {

    int insert(T t);

    int update(T t);

    List<T> selectPage(T T);

    int selectPageCount(T t);

    T selectById(String id);


    List<T> selectAll(T t);

}