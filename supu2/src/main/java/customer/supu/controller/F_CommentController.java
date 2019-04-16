package customer.supu.controller;

import customer.supu.common.po.PageResponse;
import customer.supu.dto.CommentDto;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/outside/comment")
public class F_CommentController {


    @Autowired
    private CommentService commentService;

    /**
     * 前台分页展示评论
     * <p>
     * xueming
     *
     * @param model
     * @param commentDto
     * @return
     */
    @RequestMapping(value = "/getCommenListPublic", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse getCommenListpublic(Model model, CommentDto commentDto) {
        PageResponse response = new PageResponse();
        //查询总数
        try {
            response.setTotal(commentService.selectCommentCountByranchID(commentDto));
            //异步查询评价
            response.setRecords(commentService.selectCommentByranchID(commentDto));

            //成功
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            e.printStackTrace();
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;
    }


    private int getUserId(HttpServletRequest request){
        Object employeeId = request.getSession().getAttribute("employeeId");
        return Integer.parseInt(employeeId.toString());
    }

    /**
     * 前台分页展示评论
     * <p>
     * xueming
     *
     * @param
     * @param commentDto
     * @return
     */
    @RequestMapping(value = "/getCommentgradePN", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse selectCommentgradePN( CommentDto commentDto) {
        PageResponse response = new PageResponse();
        try {
            response.setRecords(commentService.selectCommentgradePN(commentDto));//异步查询评价
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());//返回状态;成功
        } catch (Exception e) {
            response.setResultCode(ResultCodeEnum.FAIL.getCode());//返回状态;失败
        }
        return response;
    }

    /**
     * 私教 课程 门店评价公用方法
     * <p>
     * xueming
     */
    @RequestMapping(value = "/insertComment", method = RequestMethod.POST)
    @ResponseBody
    public PageResponse insertCommentgradePN(HttpServletRequest request , CommentDto commentDto) {
        PageResponse response = new PageResponse();
        commentDto.setaddtimes();//设置添加时间为当前时间
        try {
            //状态：0：删除  1：有效（审核通过）  2：待审核
            commentDto.setStatus(2);
            commentDto.setAppraisercode(getUserId(request) + "");
            response.setRecords(commentService.insertComment(commentDto));//插入新评价
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());//返回状态;成功
        } catch (Exception e) {
            e.printStackTrace();
            response.setResultCode(ResultCodeEnum.FAIL.getCode());//返回状态;失败
        }
        return response;
    }




    /*
     * 私教课评价
     */
    @RequestMapping(value="/priCourseComment",method=RequestMethod.GET)
    public String priCourseComment(@RequestParam(value="id")Integer id ,@RequestParam(value="source")Integer source, Model model){
        model.addAttribute("id",id);
        model.addAttribute("source",source);
        return "outside/buycard/coursepricoach/comment";
    }
}
