package com.answer.service.impl;

import com.answer.cache.CacheHelper;
import com.answer.domain.QuesType;
import com.answer.domain.Result;
import com.answer.domain.WXSessionCache;
import com.answer.mapper.QuesTypeMapper;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.UserAnswerMapper;
import com.answer.service.IQuesTypeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuesTypeServiceImpl implements IQuesTypeService {
	@Autowired
	private QuesTypeMapper quesTypeMapper;
	@Autowired
	private UserAnswerMapper userAnswerMapper;
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private CacheHelper cacheHelper;

	public Result getQuesTypeList(String wxSession, int type) {
		Result result = new Result();
		List<QuesType> typeList = new ArrayList<>();
		if (type == 1) {
			WXSessionCache session = this.cacheHelper.getSession(wxSession);
			typeList = this.quesTypeMapper.queryQuesTypeListWithQuesNum(session.getOpenID());
			/*Map<String, Object> map = new HashMap<>();
			map.put("openID", session.getOpenID());
			if (typeList != null) {
				for (QuesType quesType : typeList) {
					if (quesType.getTypeList() != null) {
						for (QuesType childType : quesType.getTypeList()) {
							map.put("typeID", Long.valueOf(childType.getTypeID()));
							int answerNum = this.userAnswerMapper.queryAnswerCountByUserType(map);
							childType.setAnswerNum(answerNum);
							int allNum = this.questionMapper.queryQuestionNumByType(childType.getTypeID());
							childType.setAllNum(allNum);
						}
					}
				}
			}*/
		} else{
			typeList = this.quesTypeMapper.queryQuesTypeList();
		}
		result.setResultData(typeList);
		
		return result;
	}
}
