package com.lu.code.handler;

import com.lu.project.PathConfig;
import com.lu.utils.CodeUtil;
import com.lu.utils.FileUtil;
import com.lu.utils.PropertiesUtil;

/**
 * @CLassName ControllerHandler
 * @Description TODO
 * @Author ll
 * @Date 2018/10/8 14:17
 **/
public class ControllerHandler {

    private String controllerPath;

    private String basePackage;

    public ControllerHandler(PathConfig pathConfig) {
        this.controllerPath = pathConfig.getControllerPath();
        this.basePackage = pathConfig.getBasePackage();
    }
    /*
     * @author ll
     * @Description 写BaseController.java文件
     * @date 2018/10/8 16:06
     * @param []
     * @return void
     */
    public void writeBaseController(){
        String baseControllerCode = getBaseControllerCode();
        String path = controllerPath + "/" + PropertiesUtil.CLASS_CONTROLLER + ".java";
        FileUtil.writeFileByStr(baseControllerCode, path);
    }

    /*
     * @author ll
     * @Description BaseController 代码
     * @date 2018/10/8 16:05
     * @param []
     * @return java.lang.String
     */
    private String getBaseControllerCode(){
        StringBuffer baseControllerCode = new StringBuffer();
        baseControllerCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_CONTROLLER + ";");
        baseControllerCode.append(CodeUtil.getChangeLine(2));
        String[] springController = PropertiesUtil.SPRING_CONTROLLER.split(";");
        String[] springModelAttribute = PropertiesUtil.SPRING_MODELATTRIBUTE.split(";");
        baseControllerCode.append("import " + springController[0] + ";");
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append("import " + springModelAttribute[0] + ";");
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append("import javax.servlet.http.HttpServletRequest;");
        baseControllerCode.append(CodeUtil.getChangeLine(2));
        baseControllerCode.append(springController[1]);
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append("public class " +  PropertiesUtil.CLASS_CONTROLLER + "{");
        baseControllerCode.append(CodeUtil.getChangeLine(1));

        baseControllerCode.append(CodeUtil.getIndent(1) + springModelAttribute[1] + "(\"basePath\")");
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append(CodeUtil.getIndent(1) + "public String basePath(HttpServletRequest request){");
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append(CodeUtil.getIndent(2) + "String basePath = request.getContextPath();");
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append(CodeUtil.getIndent(2) + "return basePath.endsWith(\"/\") ? basePath.substring(0, basePath.length() - 1) : basePath;");
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append(CodeUtil.getIndent(1) + "}");
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append(CodeUtil.getChangeLine(1));
        baseControllerCode.append("}");
        return baseControllerCode.toString();
    }

    /*
     * @author ll
     * @Description 写TestController.java文件
     * @date 2018/10/8 17:04
     * @param []
     * @return void
     */
    public void writeTestController(String domainName){
        String baseControllerCode = getTestControllerCode(domainName);
        String path = controllerPath + "/TestController" + ".java";
        FileUtil.writeFileByStr(baseControllerCode, path);
    }

    /*
     * @author ll
     * @Description TestController.java 代码
     * @date 2018/10/8 17:01
     * @param []
     * @return java.lang.String
     */
    public String getTestControllerCode(String domainName){
        StringBuffer testControllerCode = new StringBuffer();
        testControllerCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_CONTROLLER + ";");
        testControllerCode.append(CodeUtil.getChangeLine(2));
        String[] springController = PropertiesUtil.SPRING_CONTROLLER.split(";");
        String[] springRequestMapping = PropertiesUtil.SPRING_REQUESTMAPPING.split(";");
        String[] springAutowired = PropertiesUtil.SPRING_AUTOWIRED.split(";");
        String[] springResponseBody = PropertiesUtil.SPRING_RESPONSEBODY.split(";");
        String serviceName = CodeUtil.toCaseFirstOne(domainName , 2) + "ServiceImpl";
        String iserviceName = "I" + domainName + "Service";

        testControllerCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_SERVICE + "." + iserviceName + ";");
        testControllerCode.append(CodeUtil.getChangeLine(1));

        testControllerCode.append("import " + springController[0] + ";");
        testControllerCode.append(CodeUtil.getChangeLine(1));

        testControllerCode.append("import " + springRequestMapping[0] + ";");
        testControllerCode.append(CodeUtil.getChangeLine(1));

        testControllerCode.append("import " + springResponseBody[0] + ";");
        testControllerCode.append(CodeUtil.getChangeLine(1));

        testControllerCode.append("import " + springAutowired[0] + ";");
        testControllerCode.append(CodeUtil.getChangeLine(2));

        testControllerCode.append(springController[1]);
        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append(springRequestMapping[1] + "(\"/test\")");
        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append("public class TestController extends " + PropertiesUtil.CLASS_CONTROLLER + "{");
        testControllerCode.append(CodeUtil.getChangeLine(2));
        testControllerCode.append(CodeUtil.getIndent(1) + springAutowired[1]);
        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append(CodeUtil.getIndent(1) + "private " + iserviceName + " " +serviceName + ";");
        testControllerCode.append(CodeUtil.getChangeLine(2));

        testControllerCode.append(CodeUtil.getIndent(1) + springResponseBody[1]);
        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append(CodeUtil.getIndent(1) + springRequestMapping[1] + "(\"/testJson\")");
        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append(CodeUtil.getIndent(1) + "public Object testJson(String id){");
        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append(CodeUtil.getIndent(2) + "return " + serviceName + ".queryById(id);");
        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append(CodeUtil.getIndent(1) + "}");


        testControllerCode.append(CodeUtil.getChangeLine(1));
        testControllerCode.append("}");
        return testControllerCode.toString();
    }
}
