package customer.supu.service;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> {

    int add(T t);

    int edit(T t);

    List<T> queryPage(T t);

    Object queryById(String id);

    List<T> queryAll(T t);

}