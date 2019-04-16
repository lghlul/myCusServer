package customer.supu.controller;

import com.alibaba.fastjson.JSON;
import customer.supu.common.po.PageResponse;
import customer.supu.domain.EmployeeBuyPri;
import customer.supu.po.EmployeeAppointCourse;
import customer.supu.service.IEmployeeBuyPriService;
import customer.supu.service.impl.EmployeeBuyPriImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/outside/priCoach")
public class F_PriCoachController {

    private Logger logger = Logger.getLogger(F_PriCoachController.class);

    @Autowired
    private IEmployeeBuyPriService employeeBuyPriService;


    private int getUserId(HttpServletRequest request){
        Object employeeId = request.getSession().getAttribute("employeeId");
        return Integer.parseInt(employeeId.toString());
    }

    /*
     * @author ll
     * @Description 我的私教列表
     * @date 2018/11/5 15:57
     * @param [employeeBuyPri]
     * @return customer.supu.common.po.PageResponse
     */
    @ResponseBody
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public PageResponse coachList(EmployeeBuyPri employeeBuyPri , HttpServletRequest request){
        logger.info("coachList start...employeeBuyPri=" + JSON.toJSONString(employeeBuyPri));
        if(employeeBuyPri.getPageNo() == null){
            employeeBuyPri.setPageNo(1);
        }
        if(employeeBuyPri.getPageSize() == null){
            employeeBuyPri.setPageSize(10);
        }
        int userId = getUserId(request);
        employeeBuyPri.setUserId(userId);
        employeeBuyPri.setPageNo((employeeBuyPri.getPageNo() - 1) * employeeBuyPri.getPageSize());
        PageResponse response = employeeBuyPriService.selectPriPage(employeeBuyPri);
        logger.info("coachList end...response=" + JSON.toJSONString(response));
        return response;
    }


    /*
     * @author ll
     * @Description 私教课预约
     * @date 2018/11/5 16:07
     * @param []
     * @return customer.supu.common.po.PageResponse
     */
    @ResponseBody
    @RequestMapping(value="/appoint",method = RequestMethod.POST)
    public PageResponse appoint(Long id , Long startTime , Long endTime , HttpServletRequest request){
        logger.info("appoint start...id=" + id + ",startTime=" + startTime + ",endTime=" + endTime);
        int userId = getUserId(request);
        PageResponse response = employeeBuyPriService.makeAppoint(id, startTime, endTime, userId);
        logger.info("appoint end...response=" + JSON.toJSONString(response));
        return response;
    }


    /*
     * @author ll
     * @Description 已经预约过的列表
     * @date 2018/11/5 18:13
     * @param [id, startTime, endTime, request]
     * @return customer.supu.common.po.PageResponse
     */
    @ResponseBody
    @RequestMapping(value="/appointList",method = RequestMethod.GET)
    public PageResponse appointList(EmployeeAppointCourse employeeAppointCourse , HttpServletRequest request){
        logger.info("appointList start...appointList=" + JSON.toJSONString(employeeAppointCourse));
        if(employeeAppointCourse.getPageNo() == null){
            employeeAppointCourse.setPageNo(1);
        }
        if(employeeAppointCourse.getPageSize() == null){
            employeeAppointCourse.setPageSize(10);
        }
        int userId = getUserId(request);
        employeeAppointCourse.setUserid(userId);
        employeeAppointCourse.setPageNo((employeeAppointCourse.getPageNo() - 1) * employeeAppointCourse.getPageSize());
        PageResponse response = this.employeeBuyPriService.selectAppointPage(employeeAppointCourse);
        logger.info("appointList end...response=" + JSON.toJSONString(response));
        return response;
    }


    /*
     * @author ll
     * @Description 继续预约 返回 私教工作时间  以及被预约时间
     * @date 2018/11/5 18:16
     * @param []
     * @return customer.supu.common.po.PageResponse
     */
    @ResponseBody
    @RequestMapping(value="/toAppoint",method = RequestMethod.GET)
    public PageResponse toAppoint(Integer coachId  , String dateTime){
        logger.info("toAppoint start...coachId=" + coachId + ",dateTime=" + dateTime);
        PageResponse response = this.employeeBuyPriService.selectPriTime(coachId, dateTime);
        logger.info("toAppoint end...response=" + JSON.toJSONString(response));
        return response;
    }

    /*
     * @author ll
     * @Description 取消预约
     * @date 2018/11/6 10:17
     * @param []
     * @return customer.supu.common.po.PageResponse
     */
    @ResponseBody
    @RequestMapping(value="/cancelAppoint",method = RequestMethod.POST)
    public PageResponse cancelAppoint(Integer id , HttpServletRequest request){
        logger.info("cancelAppoint start...id=" + id);
        int userId = getUserId(request);
        PageResponse response = this.employeeBuyPriService.cancleAppoint(id, userId);
        logger.info("cancelAppoint end...response=" + JSON.toJSONString(response));
        return response;
    }



}
