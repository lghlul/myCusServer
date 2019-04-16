package customer.supu.exception;

/**
 * 异常返回码枚举类
 *
 * @author luyujian
 * @version C01 2015-2-9
 * @since JESHING
 */
public enum HRResultCode {

    /**
     * 操作成功
     */
    SUCCESS("操作成功"),

    /**
     * redis缓存key不能为空
     */
    REDIS_KEY_NOT_NULL_ERROR("redis缓存key不能为空"),

    /**
     * 服务器内部错误
     */
    SERVER_INNER_ERROR("服务器内部错误"),

    /**
     * 必填参数不能为空
     */
    PARAMTER_NOT_NULL("必填参数不能为空"),
    /**
     * 根据条件查询异常
     */
    FIND_BY_CONDITION_ERROR("根据条件查询异常"),

    /**
     * 用户未登录
     */
    USER_NOT_LOGIN("用户未登录"),

    /**
     * 新增基础数据异常
     */
    BASICDATA_ADD_ERROR("新增基础数据异常"),

    /**
     * 更新基础数据异常
     */
    BASICDATA_UPDATE_ERROR("更新基础数据异常"),

    /**
     * 更新基础数据异常
     */
    SUBJECT_UPDATE_ERROR("更新科目数据异常"),

    /**
     * 根据id查询基础数据异常
     */
    BASICDATA_FIND_BY_ID_ERROR("根据id查询基础数据异常"),

    /**
     * 分页查询基础数据异常
     */
    BASICDATA_FIND_BY_PAGE_ERROR("分页查询基础数据异常"),

    /**
     * 根据类型查询基础数据记录异常
     */
    BASICDATA_SELECT_BY_TYPE_ERROR("根据类型查询基础数据记录异常"),

    /**
     * 根据值查询基础数据异常
     */
    BASICDATA_SELECT_BY_VALUE_ERROR("根据值查询基础数据异常"),

    /**
     * 父节点不存在
     */
    PERMISSION_PARENT_NOT_EXIST_ERROR("父节点不存在"),

    /**
     * 用户组不存在或无效
     */
    PERMISSION_EMPLOYEE_GROUP_NOT_EXIST("用户组不存在或无效"),

    /**
     * 职级不存在
     */
    ACCOUTRULE_NOT_EXIST_ERROR("账套信息不存在,请添加账套！"),

    /**
     * 角色组不存在或无效
     */
    PERMISSION_ROLE_GROUP_NOT_EXIST("角色组不存在或无效"),

    /**
     * 角色不存在或无效
     */
    PERMISSION_ROLE_NOT_EXIST("角色不存在或无效"),

    /**
     * 按钮下不能添加子权限
     */
    PERMISSION_OPERATION_CAN_NOT_HAVE_CHILD("按钮下不能添加子权限"),

    /**
     * 拥有菜单型子权限，不能直接删除
     */
    PERMISSION_HAS_CHILD_MENU_CANNOT_DELETE("请先删除下级菜单型权限"),

    /**
     * 拥有子权限，不能修改为按钮型权限
     */
    PERMISSION_HAS_CHILD_CANNOT_CHANGE_TO_OPER("拥有子权限，不能修改为按钮型权限"),

    /**
     * 新增岗位异常
     */
    JOB_ADD_ERROR("新增岗位异常"),

    /**
     * 更新岗位异常
     */
    JOB_UPDATE_ERROR("更新岗位异常"),
    /**
     * 删除岗位异常
     */
    JOB_DELETE_ERROR("删除岗位异常"),

    /**
     * 根据id查询岗位异常
     */
    JOB_FIND_BY_ID_ERROR("根据id查询岗位异常"),

    /**
     * 分页查询基础数据异常
     */
    JOB_FIND_BY_PAGE_ERROR("分页查询岗位异常"),

    /**
     * 不能添加岗位类型到岗位下
     */
    JOB_CANNOT_ADD_TYPE_TO_JOB("不能添加岗位类型到岗位下"),

    /**
     * 职级不存在
     */
    RANK_NOT_EXIST_ERROR("职级不存在"),
    /**
     * 新增职务异常
     */
    POST_ADD_ERROR("新增职务异常"),
    /**
     * 更新职务异常
     */
    POST_UPDATE_ERROR("更新职务异常"),
    /**
     * 删除职务异常
     */
    POST_DELETE_ERROR("删除职务异常"),

    /**
     * 根据id查询职务异常
     */
    POST_FIND_BY_ID_ERROR("根据id查询职务异常"),
    /**
     * 分页查询职务异常
     */
    POST_FIND_BY_PAGE_ERROR("分页查询职务异常"),

    /**
     * 根据职级查询级别异常
     */
    Level_FIND_BY_RANK_ERROR("根据职级查询级别异常"),
    /**
     * 新增职级异常
     */
    RANK_ADD_ERROR("新增职级异常"),

    /**
     * 更新职级异常
     */
    RANK_UPDATE_ERROR("更新职级异常"),
    /**
     * 删除职级异常
     */
    RANK_DELETE_ERROR("删除职级异常"),

    /**
     * 根据id查询职级异常
     */
    RANK_FIND_BY_ID_ERROR("根据id查询职级异常"),

    /**
     * 分页查询基础数据异常
     */
    RANK_FIND_BY_PAGE_ERROR("分页查询职级异常"),
    /**
     * 新增级别异常
     */
    LEVEL_ADD_ERROR("新增级别异常"),

    /**
     * 更新级别异常
     */
    LEVEL_UPDATE_ERROR("更新级别异常"),
    /**
     * 删除级别异常
     */
    LEVEL_DELETE_ERROR("删除级别异常"),

    /**
     * 根据id查询级别异常
     */
    LEVEL_FIND_BY_ID_ERROR("根据id查询级别异常"),

    /**
     * 分页查询基础数据异常
     */
    LEVEL_FIND_BY_PAGE_ERROR("分页查询级别异常"),
    /**
     * 新增组织结构异常
     */
    ORGANIZATION_ADD_ERROR("新增组织结构异常"),
    /**
     * 删除组织结构异常
     */
    ORGANIZATION_DELETE_ERROR("删除组织结构异常"),
    /**
     * 更新组织结构异常
     */
    ORGANIZATION_UPDATE_ERROR("更新组织结构异常"),
    /**
     * 根据id查询组织结构异常
     */
    ORGANIZATION_FIND_BY_ID_ERROR("根据id查询组织结构异常"),
    /**
     * 分页查询组织结构异常
     */
    ORGANIZATION_FIND_BY_PAGE_ERROR("分页查询组织结构异常"),
    /**
     * 新增部门异常
     */
    ORGCOMPANY_ADD_ERROR("新增部门异常"),
    /**
     * 删除部门异常
     */
    ORGCOMPANY_DELETE_ERROR("删除部门异常"),
    /**
     * 更新部门异常
     */
    ORGCOMPANY_UPDATE_ERROR("更新部门异常"),
    /**
     * 根据id查询部门异常
     */
    ORGCOMPANY_FIND_BY_ID_ERROR("根据id查询部门异常"),
    /**
     * 分页查询部门异常
     */
    ORGCOMPANY_FIND_BY_PAGE_ERROR("分页查询部门异常"),
    /**
     * 新增部门异常
     */
    ORGDEPARTMENT_ADD_ERROR("新增部门异常"),
    /**
     * 删除部门异常
     */
    ORGDEPARTMENT_DELETE_ERROR("删除部门异常"),
    /**
     * 更新部门异常
     */
    ORGDEPARTMENT_UPDATE_ERROR("更新部门异常"),
    /**
     * 根据id查询部门异常
     */
    ORGDEPARTMENT_FIND_BY_ID_ERROR("根据id查询部门异常"),
    /**
     * 分页查询部门异常
     */
    ORGDEPARTMENT_FIND_BY_PAGE_ERROR("分页查询部门异常"),
    /**
     * 新增人员、部门、岗位关系异常
     */
    USERORGJOB_ADD_ERROR("新增人员、部门、岗位关系异常"),

    /**
     * 删除人员、部门、岗位关系异常
     */
    USERORGJOB_DELETE_ERROR("删除人员、部门、岗位关系异常"),
    /**
     * 更新人员、部门、岗位关系异常
     */
    USERORGJOB_UPDATE_ERROR("更新人员、部门、岗位关系异常"),
    /**
     * 根据id查询人员、部门、岗位关系异常
     */
    USERORGJOB_FIND_BY_ID_ERROR("根据id查询人员、部门、岗位关系异常"),
    /**
     * 分页查询人员、部门、岗位关系异常
     */
    USERORGJOB_FIND_BY_PAGE_ERROR("分页查询人员、部门、岗位关系异常"),

    /**
     * 通过组织与岗位查询人员列表异常
     */
    USERORGJOB_LIST_EMPLOYEE_ERROR("通过组织与岗位查询人员列表异常"),

    /**
     * 部门下不能添加公司
     */
    ORGANIZATION_DEPART_CAN_NOT_HAVE_COMPANY_CHILD("部门下不能添加公司"),

    /**
     * 部门不能作为一级组织
     */
    DEPART_CAN_NOT_BE_FIRST_LEVEL_ORGANIZATION("部门不能作为一级组织"),

    /**
     * 新增员工信息异常
     */
    EMPLOYEE_INSERT_ERROR("新增员工信息异常"),

    /**
     * 更新员工信息异常
     */
    EMPLOYEE_UPDATE_ERROR("更新员工信息异常"),

    /**
     * 查询员工信息异常
     */
    EMPLOYEE_SELECT_ERROR("查询员工信息异常"),

    /**
     * 员工编码不能为空
     */
    EMPLOYEE_CODE_NOT_NULL("员工编码不能为空"),

    /**
     * sequence生成异常
     */
    SEQUENCE_CREATE_ERROR("sequence生成异常"),

    /**
     * 删除员工信息异常
     */
    EMPLOYEE_DEL_ERROR("删除员工信息异常"),

    /**
     * 员工不存在或无效
     */
    EMPLOYEE_NOT_EXIST("员工不存在或无效"),

    /**
     * 根据员工工号查询角色列表失败
     */
    EMPLOYEE_SELECT_ROLE_LIST_ERROR("根据员工工号查询角色列表失败"),

    /**
     * 查询员工的组织权限异常
     */
    EMPLOYEE_SELECT_ORG_LIST_ERROR("查询员工的组织权限异常"),

    /**
     * 查询员工的组织权限异常
     */
    EMPLOYEE_UPDATESTATUS_ERROR("根据编号更改员工状态异常"),

    /**
     * 保存角色到员工失败
     */
    EMPLOYEE_INSERT_ROLE_LIST_ERROR("保存角色到员工失败"),

    /**
     * 保存角色组到员工失败
     */
    EMPLOYEE_INSERT_ROLE_GROUP_LIST_ERROR("保存角色组到员工失败"),

    /**
     * 查询员工下的角色组失败
     */
    EMPLOYEE_SELECT_ROLEGROUP_LIST_ERROR("查询员工下的角色组失败"),

    /**
     * 删除员工下的角色列表失败
     */
    EMPLOYEE_DELETE_ROLE_LIST_ERROR("删除员工下的角色列表失败"),

    /**
     * 删除员工下的角色组列表失败
     */
    EMPLOYEE_DELETE_ROLEGROUP_LIST_ERROR("删除员工下的角色组列表失败"),

    /**
     * 新增考勤结果失败
     */
    ATTEND_INSERT_RESULT_ERROR("新增考勤结果失败"),

    /**
     * 修改考勤结果失败
     */
    ATTEND_UPDATE_RESULT_ERROR("修改考勤结果失败"),

    /**
     * 查询考勤结果失败
     */
    ATTEND_LIST_RESULT_ERROR("查询考勤结果失败"),

    /**
     * 新增考勤结果失败
     */
    ATTEND_INSERT_DETAIL_ERROR("新增考勤明细失败"),

    /**
     * 修改考勤结果失败
     */
    ATTEND_UPDATE_DETAIL_ERROR("修改考勤明细失败"),

    /**
     * 查询考勤结果失败
     */
    ATTEND_LIST_DETAIL_ERROR("查询考勤明细失败"),

    /**
     * 请假人不能为空
     */
    WORKFLOW_LEAVE_EMP_CAN_NOT_NULL("请假人不能为空"),

    /**
     * 申请人不在同一个部门
     */
    WORKFLOW_APPLY_USER_NOT_IN_SAME_ORG("申请人不在同一个部门"),

    /**
     * 删除假勤类型信息异常
     */
    ATTENDTYPE_DEL_ERROR("删除假勤类型信息异常"),

    /**
     * 区域下不能添加区域
     */
    CAN_NOT_ADD_AREA_UNDER_AREA("区域下不能添加区域"),
    /**
     * 部门下不能添加公司
     */
    CAN_NOT_ADD_COMPANY_UNDER_DEPARTMENT("部门下不能添加公司"),
    /**
     * 部门不能拖动到顶级
     */
    CAN_NOT_ADD_DEPARTMENT_TOP("部门不能拖动到顶级"),
    /**
     * 移动组织机构异常
     */
    ORGANIZATION_MOVE_ERROR("移动组织机构异常"),

    /**
     * 组织下包含员工，不能撤销
     */
    ORG_HAS_EMPLOYEE_CAN_NOT_DELETE("组织下拥有员工，不能撤销"),

    /**
     * 组织机构不存在
     */
    ORG_NOT_EXIST("组织机构不存在"),

    /**
     * 组织机构合并异常
     */
    ORGCOMPANY_MERGE_ERROR("组织机构合并异常"),

    /**
     * 不能合并公司和部门
     */
    CAN_NOT_MERGE_COMPANY_AND_DEPARTMENT("不能合并公司和部门"),

    /**
     * 级别下存在员工，不能删除
     */
    LEVEL_HAS_EMP_CAN_NOT_DELETE("级别下存在员工，不能删除"),
    /**
     * 职务下存在员工，不能删除
     */
    POST_HAS_EMP_CAN_NOT_DELETE("职务下存在员工，不能删除"),

    /**
     * 岗位别下存在员工，不能删除
     */
    JOB_HAS_EMP_CAN_NOT_DELETE("岗位下存在员工，不能删除"),

    /**
     * 员工删除异常
     */
    USER_DELETE_ERROR("员工删除异常"),

    /**
     * 恢复员工异常
     */
    USER_RECOVER_ERROR("恢复员工异常"),
    /**
     * 身份证号重复
     */
    IDENTITY_REPEAT("身份证号重复"),
    /**
     * 分页查询集团系统异常
     */
    SYSTEM_FIND_BY_PAGE_ERROR("分页查询集团系统异常"),
    /**
     * 新增集团系统异常
     */
    SYSTEMRANK_ADD_ERROR("新增集团系统异常"),
    /**
     * 更新集团系统异常
     */
    SYSTEMRANK_UPDATE_ERROR("更新集团系统异常"),
    /**
     * 通过主键查询集团系统异常
     */
    SYSTEMRANK_FIND_BY_ID_ERROR("通过主键查询集团系统异常"),
    /**
     * 删除集团系统异常
     */
    SYSTEMRANK_DELETE_ERROR("删除集团系统异常"),
    /**
     * 集团系统不存在
     */
    SYSTEM_NOT_EXIST("集团系统不存在"),
    /**
     * 添加员工到集团系统失败
     */
    INNER_EMPLOYEE_TO_SYSTEM_ERROR("添加员工到集团系统失败"),
    /**
     * 移除集团下的员工失败
     */
    DELETE_EMPLOYEE_TO_SYSTEM_ERROR("移除集团下的员工失败"),

    /**
     * 报文不存在
     */
    SEND_MESSAGE_NOT_EXIST("报文不存在"),

    ;

    /**
     * 方法前缀
     */
    private final String desc;

    /**
     * 构造函数
     *
     * @param code 方法编码
     * @param desc 方法前缀
     */
    private HRResultCode(String desc) {
        this.desc = desc;
    }

    /**
     * 取得desc
     *
     * @return 返回desc。
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 取得code
     *
     * @return 返回code。
     */
    public String getCode() {
        return this.name();
    }
}
