package com.lu.service;

import com.lu.domain.Project;

/**
 * @CLassName IProjectService
 * @Description TODO
 * @Author ll
 * @Date 2018/8/20 11:05
 **/
public interface IProjectService extends BaseService<Project>{

    public void addProject(Project project) throws Exception;
}
