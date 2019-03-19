package com.answer.utils;

import com.answer.domain.Question;

import java.util.HashSet;
import java.util.Set;

public class CommonUtil {

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param numberFlag
	 *            是否是数字
	 * @param length
	 * @return
	 */
	public static String createRandom(boolean numberFlag, int length) {

		String retStr = "";

		String strTable = numberFlag ? "1234567890"
				: "1234567890ABCDEFGHIJKMNPQRSTUVWXYZ";

		int len = strTable.length();

		boolean bDone = true;

		do {

			retStr = "";

			int count = 0;

			for (int i = 0; i < length; i++) {

				double dblR = Math.random() * len;

				int intR = (int) Math.floor(dblR);

				char c = strTable.charAt(intR);

				if (('0' <= c) && (c <= '9')) {

					count++;

				}

				retStr += strTable.charAt(intR);

			}

			if (count >= 2) {

				bDone = false;

			}

		} while (bDone);

		return retStr;
	}


	/**
	 * 判断是否回答正确
	 * @param question
	 * @param answerID
	 * @return
	 */
	public static boolean isRight(Question question, String answerID){
		String[] rightAnswers = question.getRightAnswerID().split(",");
		String[] answerIDs = answerID.split(",");

		//答案个数不一样 错误
		if(rightAnswers.length != answerIDs.length){
			return false;
		}else{
			Set<String> answerSet = new HashSet<>();
			for(String rightAnswer : rightAnswers){
				answerSet.add(rightAnswer);
			}
			for(String answer : answerIDs){
				//如果正确答案不包含  回答的答案就是回答错误
				if(!answerSet.contains(answer)){
					return false;
				}
			}
		}
		return true;
	}
}
