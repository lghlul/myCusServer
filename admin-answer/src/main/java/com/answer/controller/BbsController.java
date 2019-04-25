package com.answer.controller;

import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.*;
import com.answer.service.IBbsReplyService;
import com.answer.service.IBbsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/3 11:36
 * @Modified By：
 */
@RestController
@RequestMapping("/bbs")
public class BbsController {

    @Autowired
    private IBbsService bbsService;


    @Autowired
    private IBbsReplyService bbsReplyService;


    @GetMapping("list")
    public Object list(Bbs bbs) {
        PageInfo<Bbs> page = bbsService.page(bbs);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }

    @GetMapping("listReply")
    public Object list(BbsReply bbsReply) {
        PageInfo<BbsReply> page = bbsReplyService.page(bbsReply);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }

    @PostMapping("delete")
    public Object delete(Long bbsID){
        Bbs bbs = new Bbs();
        bbs.setBbsID(bbsID);
        bbsService.delete(bbs);
        return ResultCodeEnum.SUCCESS.getResponse();
    }


    @PostMapping("deleteReply")
    public Object deleteReply(Long replyID){
        BbsReply bbsReply = new BbsReply();
        bbsReply.setReplyID(replyID);
        bbsReplyService.delete(bbsReply);
        return ResultCodeEnum.SUCCESS.getResponse();
    }



}
