package customer.supu.common.utils;

public interface CacheKeys
{
    /**
     * 缓存全部信息的FIELD
     */
    String ALL = "ALL";

    /**
     * 缓存存放
     */
    String BASIC_DATA = "BASIC_DATA";

    /**
     * 权限菜单
     */
    String PERMISSION = "permission";

    /**
     * 员工关联信息key
     */
    String EMPLOYEE_RELATION_MAP = "employee_relation_map";

    /**
     * 角色下的权限code列表
     */
    String ROLE_PERMISSIONS_LIST = "role_permissions_list";

    /**
     * 角色组下的角色no列表
     */
    String ROLEGROUP_ROLES_LIST = "rolegroup_roles_list";

    /**
     * 角色列表
     */
    String ROLE_LIST = "role_list";

    /**
     * 角色下的机构code列表
     */
    String ROLE_OGANIZE_LIST = "role_oganize_list";
    /**
     * 员工下的机构code
     */
    String EMPLOYEE_OGANIZE_LIST="employee_oganize_list";

    /**
     * 测试缓存读取日志
     */
    String DEMO_LOGS="logs_demo_list";

}
