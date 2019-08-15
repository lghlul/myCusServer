package com.answer.service;


import com.answer.domain.*;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IBbsService {

	PageInfo<Bbs> page(Bbs bbs, String wxSession);

	int save (Bbs bbs, String wxSession);
}

