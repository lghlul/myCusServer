package customer.supu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.utils.StringUtils;
import customer.supu.dao.CommentDao;
import customer.supu.dto.CommentDto;
import customer.supu.jenum.AuditStatusEnum;
import customer.supu.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;

		//根据条件查询评论
		public List<CommentDto> selectCommentByContion(CommentDto commentDto) throws Exception{

			//如果没有状态，则默认加载待审核的评价
			if(commentDto.getStatus()==null || commentDto.getStatus()<=0){
				//待审核
				commentDto.setStatus(AuditStatusEnum.WAIT.getCode());
			}
			return commentDao.selectCommentByContion(commentDto);

		}

		/**
		 * 审核 评论
		 * @param ids
		 * @param status
		 */
		public void updateStatus(String ids,String status) throws Exception{

			List<String> idList=new ArrayList<String>();

			if(StringUtils.hasText(ids)){
				Map<String,Object> map=new HashMap<String,Object>();
				String[]  id=ids.split("[,，]");
				if(id !=null){
					//遍历数组
					for(int i=0;i<id.length;i++){
						idList.add(id[i]);
					}
					//更新状态
					map.put("ids",idList);
					map.put("status",status);
					commentDao.updStatus(map);

				}else{
					throw new Exception("数据缺失");
				}
			}else{
				throw new Exception("数据缺失");
			}

		}

		/**
		 * 	前端展示评价-分页展示-依据评级来源-评价ID
		 *  
		 *  (non-Javadoc)
		 * @see customer.supu.service.CommentService#selectCommentByranchID(java.lang.Integer, java.lang.Integer)
		 */
		public List<CommentDto> selectCommentByranchID(CommentDto  commentDto) throws Exception {
			return commentDao.selectCommentByranchID(commentDto);
		}

		
		/**
		 * 	前端展示评价-分页展示-依据评级来源-评价ID
		 *  
		 *  (non-Javadoc)
		 * @see customer.supu.service.CommentService#selectCommentByranchID(java.lang.Integer, java.lang.Integer)
		 */
		public Integer selectCommentCountByranchID(CommentDto  commentDto) throws Exception {
			return commentDao.selectCommentCountByranchID(commentDto);
		}

		@Override
		public CommentDto selectCommentgradePN(CommentDto commentDto) throws Exception {
			return commentDao.selectCommentgradePN(commentDto);
		}

		@Override
		public Integer insertComment(CommentDto commentDto) throws Exception {
			return commentDao.insertComment(commentDto);
		}
		
		
}
