package customer.supu.common.utils;

/**
 * 系统常量
 *
 * @author
 * @version C01 2015年2月28日
 * @since JESHING
 */
public interface SysConstants {

    String EXPORT_WORK = "exports/work/";

    String ORGANIZATION_RELATION_CODE_START = "G";

    /**
     * 默认密码888888
     */
    String DEFAULT_PASSWORD = "888888";

    /**
     * 用户session名称
     */
    String USERSESSIONNAME = "userinfo";

    /**
     * 员工档案
     */
    int ARCHIVES = 1;

    /**
     * 员工档案存放
     */
    int ARCHIVESDEP = 2;

    /**
     * 职业生涯规划
     */
    int CAREER = 3;

    /**
     * 员工教育背景
     */
    int EDUCATION = 4;

    /**
     * 员工紧急联系人
     */
    int EMERGENCY = 5;

    /**
     * 员工家庭状况
     */
    int FAMILY = 6;

    /**
     * 员工掌握语言
     */
    int LANGUAGE = 7;

    /**
     * 员工兵役情况
     */
    int MILITARY = 8;

    /**
     * 员工个人考核结果
     */
    int PPERESULT = 9;

    /**
     * 员工职称经历
     */
    int PROFESSIONALTITLE = 10;

    /**
     * 员工项目经验
     */
    int PROJECT = 11;

    /**
     * 员工培训经历
     */
    int TRAIN = 12;

    /**
     * 员工工作简历
     */
    int WORK = 13;

    /**
     * 员工培训规划
     */
    int EMP = 14;

    /**
     * 组织岗位
     */
    int ORGJOB = 15;

    String TOP_PCODE = "00000000";

    boolean isContactToHR = false;

    boolean isContactToOA = true;
}
