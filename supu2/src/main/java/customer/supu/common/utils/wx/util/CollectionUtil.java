package customer.supu.common.utils.wx.util;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {
	
	/**
	 * 判断Map是否为空
	 * @param map
	 * @return 为空返回true，不为空返回false
	 */
	public static boolean isEmptyMap(Map<?, ?> map){
		if (map == null || map.size() == 0) {
            return true;
        }
        return false;
	}
	
	/**
     * 判断Map是否为空
     * 
     * @param map 数组
     * @return 为空返回true，不为空返回false
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmptyMap(map);
    }
    
    /**
     * 获取map长度
     * 
     * @param list
     * @return 为null时，返回0
     */
    public final static int getSize(Map<?, ?> map) {
        if (isEmptyMap(map)) {
            return 0;
        }
        return map.size();
    }
    
    /**
     * 判断集合是否为空
     * 
     * @param collection 数组
     * @return 为空返回true，不为空返回false
     */
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }


}
