package customer.supu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.PageResponse;
import customer.supu.dto.CommentDto;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.service.BasicDataService;
import customer.supu.service.CoachService;
import customer.supu.service.CommentService;
import customer.supu.service.StoreService;

@Controller
@RequestMapping("/user/comment")
public class B_CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private BasicDataService basicDataService;

    /**
     * 进入评论页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String listPge(Model model, CommentDto commentDto) {
        try {
            //评论信息
            model.addAttribute("comment", commentService.selectCommentByContion(commentDto));

            //获取所有开业中的门店
            model.addAttribute("store", storeService.selectAllStore());

            //获取所有的合作中教练
            model.addAttribute("coach", coachService.selectAllCoach());

            //获取评价星级
            model.addAttribute("commentStar", basicDataService.getBasicDataByType("commentStar"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "/comment/commentlist";
    }

    /**
     * 修改状态
     */
    @RequestMapping(value = "/updStatus", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse updStatus(@RequestParam(value = "ids") String ids, @RequestParam(value = "status") String status) {
        PageResponse response = new PageResponse();
        try {
            commentService.updateStatus(ids, status);
            //成功
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;
    }

    /**
     * 异步根据条件查询comment
     *
     * @param model
     * @param commentDto
     */

    @RequestMapping(value = "/getCommenList", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse getCommenList(Model model, CommentDto commentDto) {
        PageResponse response = new PageResponse();
        try {
            //异步查询评价
            response.setRecords(commentService.selectCommentByContion(commentDto));

            //成功
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;
    }

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
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        try {
            //异步查询评价
            response.setRecords(commentService.selectCommentByranchID(commentDto));

            //成功
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        } catch (Exception e) {
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;
    }

    /**
     * 前台分页展示评论
     * <p>
     * xueming
     *
     * @param model
     * @param commentDto
     * @return
     */
    @RequestMapping(value = "/getCommentgradePN", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse selectCommentgradePN(Model model, CommentDto commentDto) {
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
    public PageResponse insertCommentgradePN(Model model, CommentDto commentDto) {
        PageResponse response = new PageResponse();
        commentDto.setaddtimes();//设置添加时间为当前时间
        try {
            response.setRecords(commentService.insertComment(commentDto));//插入新评价
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());//返回状态;成功
        } catch (Exception e) {
            response.setResultCode(ResultCodeEnum.FAIL.getCode());//返回状态;失败
        }
        return response;
    }

}
