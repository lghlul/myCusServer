package customer.supu.service;

import customer.supu.common.po.PageResponse;
import customer.supu.domain.EmployeeBuyPri;
import customer.supu.po.EmployeeAppointCourse;

public interface IEmployeeBuyPriService extends IBaseService<EmployeeBuyPri>{


    public PageResponse selectPriPage(EmployeeBuyPri employeeBuyPri);


    public PageResponse makeAppoint(Long id , Long startTime , Long endTime , int userId);

    public PageResponse selectAppointPage(EmployeeAppointCourse employeeAppointCourse);


    public PageResponse selectPriTime(int coachId  , String dateTime);


    public PageResponse cancleAppoint(int id , int userId);
}
