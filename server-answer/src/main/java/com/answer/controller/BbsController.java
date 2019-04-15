package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.common.PageResult;
import com.answer.domain.Activity;
import com.answer.domain.Bbs;
import com.answer.domain.BbsReply;
import com.answer.domain.Result;
import com.answer.service.IBbsService;
import com.answer.service.IBbsReplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/15 16:04
 * @Modified By：
 */
@RestController
@RequestMapping("/bbs" )
public class BbsController {

    @Autowired
    private IBbsService bbsService;

    @Autowired
    private IBbsReplyService bbsReplyService;


    @GetMapping("list")
    public String list(Bbs bbs , String wxSession) {
        Result result = new Result();
        PageInfo<Bbs> page = bbsService.page(bbs,null);
        result.setResultData(getPageResult(page));
        return JSON.toJSONString(result);
    }


    @GetMapping("listMy")
    public String listMy(Bbs bbs , String wxSession) {
        Result result = new Result();
        PageInfo<Bbs> page = bbsService.page(bbs,wxSession);
        result.setResultData(getPageResult(page));
        return JSON.toJSONString(result);
    }


    @GetMapping("listReply")
    public String listReply(BbsReply bbsReply , String wxSession) {
        Result result = new Result();
        PageInfo<BbsReply> page = bbsReplyService.page(bbsReply,null);
        result.setResultData(getPageResult(page));
        return JSON.toJSONString(result);
    }

    @GetMapping("listMyReply")
    public String listMyReply(BbsReply bbsReply , String wxSession) {
        Result result = new Result();
        PageInfo<BbsReply> page = bbsReplyService.page(bbsReply,wxSession);
        result.setResultData(getPageResult(page));
        return JSON.toJSONString(result);
    }

    private PageResult getPageResult(PageInfo page){
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return pageResult;
    }
    @PostMapping("save")
    public String save(Bbs bbs , String wxSession){
        Result result = new Result();
        bbsService.save(bbs,wxSession);
        return JSON.toJSONString(result);
    }

    @PostMapping("saveReply")
    public String saveReply(BbsReply bbsReply , String wxSession){
        Result result = new Result();
        bbsReplyService.save(bbsReply,wxSession);
        return JSON.toJSONString(result);
    }
}
