package customer.supu.common.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class CacheUtils
{
   /* *//**
     * 单例实例
     *//*
    private static final CacheUtils instance = new CacheUtils();

    *//**
     * 缓存对象实例
     *//*
    private SentinelShardedJedis jedis = new SentinelShardedJedis(MessageContext.getBean(JedisFactory.class));

    *//**
     * 获取缓存工具类实例
     *
     * @author 赵卉华
     * @return 缓存工具类实例
     *//*
    public static CacheUtils getInstance()
    {
        return instance;
    }

    *//**
     * 保存字符串
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @param value
     * @throws Exception
     *//*
    public void set(String key, String field, String value) throws Exception
    {
        if (StringUtils.isEmpty(key))
        {
            throw new Exception(HRResultCode.REDIS_KEY_NOT_NULL_ERROR.getDesc());
        }
        if (StringUtils.isEmpty(field))
        {
            field = CacheKeys.ALL;
        }
        jedis.hset(key, field, value);

    }

    *//**
     * 取出字符串
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @return
     * @throws Exception
     *//*
    public String get(String key, String field) throws Exception
    {
        if (StringUtils.isEmpty(key))
        {
            throw new Exception(HRResultCode.REDIS_KEY_NOT_NULL_ERROR.getDesc());
        }
        if (StringUtils.isEmpty(field))
        {
            field = CacheKeys.ALL;
        }
        return jedis.hget(key, field);
    }

    *//**
     * 添加对象到缓存中
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @param value
     * @throws Exception
     *//*
    public void set(String key, String field, Object value) throws Exception
    {
        set(key, field, JSON.toJSONString(value));
    }

    *//**
     * 从缓存中取出对象
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @param c
     * @return
     * @throws Exception
     *//*
    public <T> T get(String key, String field, Class<T> c) throws Exception
    {
        String text = get(key, field);
        if (!StringUtils.isEmpty(text))
        {
            T value = JSONObject.parseObject(text, c);
            return value;
        }

        return null;
    }

    *//**
     * 添加list到缓存中
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @param value
     * @throws Exception
     *//*
    public void setList(String key, String field, List<?> value) throws Exception
    {
        set(key, field, JSONArray.toJSONString(value));
    }

    *//**
     * 从缓存中取出list
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @param c
     * @return
     * @throws Exception
     *//*
    public <T> List<T> getList(String key, String field, Class<T> c) throws Exception
    {
        String text = get(key, field);
        if (!StringUtils.isEmpty(text))
        {
            List<T> list = JSON.parseArray(text, c);
            return list;
        }

        return new ArrayList<T>();
    }

    *//**
     * 将map对象放入缓存
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @param value
     * @return
     * @throws Exception
     *//*
    public void setMap(String key, String field, Map<String, ?> value) throws Exception
    {
        set(key, field, JSON.toJSONString(value));
    }

    *//**
     * 从缓存中获取map对象
     *
     * @author 史怀周
     * @param key
     *            缓存类型，对应CacheKeys
     * @param field
     *            如果没有可为空
     * @param c
     * @return
     * @throws Exception
     *//*
    @SuppressWarnings("unchecked")
    public <T> Map<String, T> getMap(String key, String field, Class<T> c) throws Exception
    {
        String text = get(key, field);
        if (!StringUtils.isEmpty(text))
        {
            Map<String, T> map = (Map<String, T>) JSON.parse(text);
            Map<String, T> result = new HashMap<String, T>();
            for (String tmp : map.keySet())
            {
                result.put(tmp, JSON.parseObject(map.get(tmp).toString(), c));
            }

            return result;
        }

        return null;
    }

    *//**
     * 判断缓存是否存在key
     *
     * @author luyujian
     * @param key
     *            缓存key
     * @param field
     * @return
     * @throws Exception
     *//*
    public Boolean exist(String key, String field) throws Exception
    {
        if (StringUtils.isEmpty(key))
        {
            throw new Exception(HRResultCode.REDIS_KEY_NOT_NULL_ERROR.getDesc());
        }

        if (StringUtils.isEmpty(field))
        {
            field = CacheKeys.ALL;
        }

        return jedis.hexists(key, field);
    }

    *//**
     * 删除缓存中的指定key的值
     *
     * @author luyujian
     * @param key
     *            缓存key
     * @param field
     * @throws Exception
     *//*
    public void del(String key, String field) throws Exception
    {
        if (StringUtils.isEmpty(key))
        {
            throw new Exception(HRResultCode.REDIS_KEY_NOT_NULL_ERROR.getDesc());
        }

        if (StringUtils.isEmpty(field))
        {
            field = CacheKeys.ALL;
        }

        // 删除
        jedis.hdel(key, field);
    }*/

}
