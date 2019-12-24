package com.daiwenjie.cms.dao;

import java.util.List;

import com.daiwenjie.cms.domain.Comment;
/**
 * 评论dao层接口
 * @author Administrator
 *
 */
public interface CommentDAO {

	int addComment(Comment comment);

	List<?> commentList(Integer id);

}
