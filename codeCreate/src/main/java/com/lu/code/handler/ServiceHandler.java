package com.lu.code.handler;

import com.lu.project.PathConfig;
import com.lu.utils.CodeUtil;
import com.lu.utils.FileUtil;
import com.lu.utils.PropertiesUtil;

/**
 * @CLassName ServiceHandler
 * @Description 生成service
 * @Author ll
 * @Date 2018/9/29 10:25
 **/
public class ServiceHandler {


    private PathConfig pathConfig;
    private String basePackage;
    private String serviceImplPath;
    private String servicePath;

    public ServiceHandler(PathConfig pathConfig) {
        this.pathConfig = pathConfig;
        this.basePackage = pathConfig.getBasePackage();
        this.serviceImplPath = pathConfig.getServiceImplPath();
        this.servicePath = pathConfig.getServicePath();
    }

    /*
     * @author ll
     * @Description 生成 baseService 类
     * @date 2018/9/29 15:29
     * @param []
     * @return void
     */
    public void writeBaseService(){
        String ibaserServiceCode = getIBaseServiceCode();
        String path = servicePath + "/" + PropertiesUtil.CLASS_IBASE_SERVICE + ".java";
        FileUtil.writeFileByStr(ibaserServiceCode, path);

        String baseServiceImplCode = getBaseServiceImplCode();
        path = serviceImplPath + "/" + PropertiesUtil.CLASS_BASE_SERVICE_IMPL + ".java";
        FileUtil.writeFileByStr(baseServiceImplCode, path);
    }

    /*
     * @author ll
     * @Description 生成 service 类
     * @date 2018/9/29 15:29
     * @param []
     * @return void
     */
    public void writeService(String domainName){
        String iserviceCode = getIServiceCode(domainName);
        String path = servicePath + "/I" + domainName + "Service.java";
        FileUtil.writeFileByStr(iserviceCode, path);

        String serviceImplCode = getServiceImplCode(domainName);
        path = serviceImplPath + "/" + domainName + "ServiceImpl.java";
        FileUtil.writeFileByStr(serviceImplCode, path);
    }


    /*
     * @author ll
     * @Description 获取 IBaseService 代码
     * @date 2018/9/29 15:27
     * @param []
     * @return java.lang.String
     */
    public String getIBaseServiceCode(){
        StringBuffer ibaserServiceCode = new StringBuffer();
        ibaserServiceCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_SERVICE + ";");
        ibaserServiceCode.append(CodeUtil.getChangeLine(1));
        // import
        String[] ibaserServiceImports = PropertiesUtil.BASESERVICE_IMPORT.split(";");
        for (String serviceImport : ibaserServiceImports) {
            ibaserServiceCode.append(CodeUtil.getChangeLine(1));
            ibaserServiceCode.append("import " + serviceImport + ";");
        }


        ibaserServiceCode.append(CodeUtil.getChangeLine(2));
        ibaserServiceCode.append("public interface " + PropertiesUtil.CLASS_IBASE_SERVICE + "<T> {");
        ibaserServiceCode.append(CodeUtil.getChangeLine(1));
        //方法
        String[] ibaseServiceMethods = PropertiesUtil.BASESERVICE_METHOD.split(";");
        for (String serviceMethod : ibaseServiceMethods) {
            ibaserServiceCode.append(CodeUtil.getChangeLine(1));
            ibaserServiceCode.append(CodeUtil.getIndent(1) + serviceMethod + ";");
            ibaserServiceCode.append(CodeUtil.getChangeLine(1));
        }
        ibaserServiceCode.append(CodeUtil.getChangeLine(1));
        ibaserServiceCode.append("}");
        return ibaserServiceCode.toString();
    }


    /*
     * @author ll
     * @Description 获取baseServiceImpl代码
     * @date 2018/9/30 14:49
     * @param []
     * @return java.lang.String
     */
    public String getBaseServiceImplCode(){
        StringBuffer baserServiceImplCode = new StringBuffer();
        baserServiceImplCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_SERVICE + "." +PropertiesUtil.PACKAGE_SERVICE_IMPL + ";");
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        // import
        String[] ibaserServiceImports = PropertiesUtil.BASESERVICE_IMPORT.split(";");
        //引工具包
        for (String serviceImport : ibaserServiceImports) {
            baserServiceImplCode.append(CodeUtil.getChangeLine(1));
            baserServiceImplCode.append("import " + serviceImport + ";");
        }
        // BaseMapper 包
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        baserServiceImplCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + "." + PropertiesUtil.CLASS_BASE_MAPPER + ";");
        // IBaseService 包
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        baserServiceImplCode.append("import " + basePackage + "." +  PropertiesUtil.PACKAGE_SERVICE + "."  + PropertiesUtil.CLASS_IBASE_SERVICE + ";");
        // autowrite 注解  下标0 包  1 注解
        String[] autoWrite = PropertiesUtil.SPRING_AUTOWIRED.split(";");
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        baserServiceImplCode.append("import " + autoWrite[0] + ";");
        // service 注解  下标0 包  1 注解
        String[] service = PropertiesUtil.SPRING_SERVICE.split(";");
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        baserServiceImplCode.append("import " + service[0] + ";");

        baserServiceImplCode.append(CodeUtil.getChangeLine(2));
        //@Service
        baserServiceImplCode.append(service[1]);
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        baserServiceImplCode.append("public class " + PropertiesUtil.CLASS_BASE_SERVICE_IMPL + "<T> implements " + PropertiesUtil.CLASS_IBASE_SERVICE + "<T>{");
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));

        //声明 BaseMapper
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        //@Autowired
        baserServiceImplCode.append(CodeUtil.getIndent(1) + autoWrite[1]);
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        String baseMapper = CodeUtil.toCaseFirstOne(PropertiesUtil.CLASS_BASE_MAPPER ,2);
        baserServiceImplCode.append(CodeUtil.getIndent(1) + "private " + PropertiesUtil.CLASS_BASE_MAPPER + " " + baseMapper + ";");
        baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        //方法
        String[] ibaseServiceMethods = PropertiesUtil.BASESERVICE_METHOD.split(";");
        String[] serviceMapperMethods = PropertiesUtil.SERVICE_IMPL_MAPPER_METHOD.split(";");
        for (int i = 0 ; i < ibaseServiceMethods.length ; i ++) {
            String serviceMethod = ibaseServiceMethods[i];
            String serviceMapperMethod = serviceMapperMethods[i];
            baserServiceImplCode.append(CodeUtil.getChangeLine(1));
            baserServiceImplCode.append(CodeUtil.getIndent(1) + "public " + serviceMethod + "{");
            baserServiceImplCode.append(CodeUtil.getChangeLine(1));
            baserServiceImplCode.append(CodeUtil.getIndent(2) + "return " + baseMapper + "." + serviceMapperMethod + ";");
            baserServiceImplCode.append(CodeUtil.getChangeLine(1));
            baserServiceImplCode.append(CodeUtil.getIndent(1) + "}");
            baserServiceImplCode.append(CodeUtil.getChangeLine(1));
        }
        baserServiceImplCode.append("}");
        return baserServiceImplCode.toString();
    }

    /*
     * @author ll
     * @Description IService
     * @date 2018/9/30 15:41
     * @param [domainName]
     * @return java.lang.String
     */
    private String getIServiceCode(String domainName){
        StringBuffer iserviceCode = new StringBuffer();
        iserviceCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_SERVICE + ";");
        iserviceCode.append(CodeUtil.getChangeLine(2));
        // import
        iserviceCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + "." + domainName + ";");
        iserviceCode.append(CodeUtil.getChangeLine(2));
        iserviceCode.append("public interface I" + domainName + "Service extends " + PropertiesUtil.CLASS_IBASE_SERVICE + "<" + domainName + ">{");
        iserviceCode.append(CodeUtil.getChangeLine(1));
        iserviceCode.append("}");
        iserviceCode.append(CodeUtil.getChangeLine(1));
        return iserviceCode.toString();
    }

    /*
     * @author ll
     * @Description ServiceImpl
     * @date 2018/9/30 15:41
     * @param [domainName]
     * @return java.lang.String
     */
    private String getServiceImplCode(String domainName){
        StringBuffer serviceImplCode = new StringBuffer();
        serviceImplCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_SERVICE + "." + PropertiesUtil.PACKAGE_SERVICE_IMPL + ";");
        serviceImplCode.append(CodeUtil.getChangeLine(2));
        // import
        serviceImplCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + "." + domainName + ";");
        serviceImplCode.append(CodeUtil.getChangeLine(1));
        serviceImplCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_SERVICE + ".I" + domainName + "Service;");
        // service 注解  下标0 包  1 注解
        String[] service = PropertiesUtil.SPRING_SERVICE.split(";");
        serviceImplCode.append(CodeUtil.getChangeLine(1));
        serviceImplCode.append("import " + service[0] + ";");
        serviceImplCode.append(CodeUtil.getChangeLine(2));

        serviceImplCode.append(service[1]);
        serviceImplCode.append(CodeUtil.getChangeLine(1));
        serviceImplCode.append("public class " + domainName + "ServiceImpl extends " + PropertiesUtil.CLASS_BASE_SERVICE_IMPL + "<" + domainName+ "> implements " + "I" + domainName + "Service{");
        serviceImplCode.append(CodeUtil.getChangeLine(1));
        serviceImplCode.append("}");
        serviceImplCode.append(CodeUtil.getChangeLine(1));
        return serviceImplCode.toString();
    }


}
