package com.lu.service.impl;

import com.lu.code.CodeCreate;
import com.lu.domain.Project;
import com.lu.mapper.ProjectMapper;
import com.lu.project.ProjectConfig;
import com.lu.project.ProjectCreate;
import com.lu.service.IProjectService;
import com.lu.utils.FileUtil;
import com.lu.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @CLassName TrainServiceImpl
 * @Description TODO
 * @Author ll
 * @Date 2018/8/20 11:05
 **/
@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements IProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public void addProject(Project project) throws Exception{

        ProjectConfig projectConfig = new ProjectConfig();
        String databaseName = project.getDatabase();
        projectConfig.setBasePackage(project.getGroupId());
        projectConfig.setProjectName(project.getArtifactId());
        projectConfig.setDrivenClass("com.mysql.jdbc.Driver");
        projectConfig.setDatabase(databaseName);
        projectConfig.setUrl("jdbc:mysql://" + project.getHost() + "/" + databaseName + "?useUnicode=true");
        projectConfig.setUsername(project.getUsername());
        projectConfig.setPassword(project.getPassword());
        //生成项目
        ProjectCreate projectHandler = new ProjectCreate();
        projectHandler.init(projectConfig);
        projectHandler.create();
        //写入代码
        CodeCreate codeCreate = new CodeCreate();
        codeCreate.create(projectConfig , projectHandler.getPathConfig());

        //打包
        FileUtil.zip(PropertiesUtil.BASEPATH + "/" + project.getArtifactId() , PropertiesUtil.BASEPATH + "/" + project.getArtifactId() + ".zip");

        //projectMapper.insert(project);
    }
}
