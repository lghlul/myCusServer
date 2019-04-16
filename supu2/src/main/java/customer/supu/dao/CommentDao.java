package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CommentDto;
import customer.supu.mapper.CommentMapper;

public interface CommentDao extends CommentMapper{

	//根据条件查询评论
	public List<CommentDto> selectCommentByContion(CommentDto commentDto);


	//更新状态
	public  void updStatus(Map<String,Object> map);

//	前端展示评价-分页展示-依据评级来源-评价ID
	public List<CommentDto> selectCommentByranchID(CommentDto commentDto);
//	前端展示计数  -分页展示-依据评级来源-评价ID
	public Integer selectCommentCountByranchID(CommentDto commentDto);
//	查询评价平均分数  和   评价的人数
	public CommentDto selectCommentgradePN(CommentDto commentDto);
//	插入新评价
	public int insertComment(CommentDto commentDto);
}
