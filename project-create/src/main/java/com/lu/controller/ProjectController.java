package com.lu.controller;

import com.alibaba.fastjson.JSON;
import com.lu.domain.Project;
import com.lu.enums.CodeConstant;
import com.lu.service.IProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @CLassName ProjectController
 * @Description TODO
 * @Author ll
 * @Date 2018/10/10 11:27
 **/
@RestController
@RequestMapping("/project")
public class ProjectController {

    private static Logger logger = LogManager.getLogger(ProjectController.class);

    @Autowired
    IProjectService projectService;

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("create")
    public Object create(Project project) throws Exception{
        logger.info("create start...project=" + JSON.toJSONString(project));
        projectService.addProject(project);
        return CodeConstant.SUCCESS.getResultBean();
    }

    @RequestMapping("test")
    public Object test(Project project) throws Exception{
        restTemplate.getForEntity("https://view.officeapps.live.com/op/view.aspx?src=http%3a%2f%2fvideo.ch9.ms%2fbuild%2f2011%2fslides%2fTOOL-532T_Sutter.pptx",String.class);
        return CodeConstant.SUCCESS.getResultBean();
    }
}
