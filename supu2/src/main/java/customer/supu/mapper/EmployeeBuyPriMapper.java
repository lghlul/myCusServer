package customer.supu.mapper;


import customer.supu.domain.EmployeeBuyPri;
import customer.supu.domain.PriCoachCourse;

import java.util.List;

public interface EmployeeBuyPriMapper extends BaseMapper<EmployeeBuyPri>{
    public int updateBuyPriByCourse(EmployeeBuyPri employeeBuyPri);

    public int selectPriCoachPageCount(EmployeeBuyPri employeeBuyPri);

    public List<PriCoachCourse> selectPriCoachPage(EmployeeBuyPri employeeBuyPri);
}