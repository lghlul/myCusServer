package com.answer.controller;

import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.ScoreLog;
import com.answer.domain.query.ScoreLogQuery;
import com.answer.service.IScoreLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/10/10 11:03
 * @Modified By：
 */
@RestController
@RequestMapping("/scoreLog")
public class ScoreLogController {

    @Autowired
    private IScoreLogService scoreLogService;

    @GetMapping("list")
    public Object list(ScoreLogQuery scoreLogQuery) {
        PageInfo<ScoreLog> page = scoreLogService.page(scoreLogQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }
}
