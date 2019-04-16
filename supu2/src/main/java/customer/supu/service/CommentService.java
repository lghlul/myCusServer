package customer.supu.service;

import java.util.List;

import customer.supu.dto.CommentDto;

public interface CommentService {
	//根据条件查询评论
	public List<CommentDto> selectCommentByContion(CommentDto commentDto) throws Exception;


	/**
	 * 审核 评论
	 * @param ids
	 * @param status
	 */
	public void updateStatus(String ids,String status) throws Exception;
	
	/**
	 * 
	 * 	前端展示评价-分页展示-依据评级来源-评价ID
	 */
	public List<CommentDto> selectCommentByranchID(CommentDto  commentDto) throws Exception;

	/**
	 * 
	 * 	前端展示查询总数-分页展示-依据评级来源-评价ID
	 */
	public Integer selectCommentCountByranchID(CommentDto  commentDto) throws Exception;

	/**
	 * 
	 * 	前端展示查询总数-分页展示-依据评级来源-评价ID
	 */
	public CommentDto selectCommentgradePN(CommentDto  commentDto) throws Exception;
	
	/**
	 *	插入新评价
	 */
	public Integer insertComment(CommentDto commentDto) throws Exception;
	
}
