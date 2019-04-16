package customer.supu.service.impl;

import java.util.List;
import java.util.Map;
import customer.supu.mapper.BaseMapper;
import customer.supu.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<T> implements IBaseService<T>{

    @Autowired
    private BaseMapper<T> baseMapper;

    public int add(T t){
        return baseMapper.insert(t);
    }

    public int edit(T t){
        return baseMapper.update(t);
    }

    public List<T> queryPage(T t){
        return baseMapper.selectPage(t);
    }

    public Object queryById(String id){
        return baseMapper.selectById(id);
    }

    @Override
    public List<T> queryAll(T t) {
        return baseMapper.selectAll(t);
    }
}