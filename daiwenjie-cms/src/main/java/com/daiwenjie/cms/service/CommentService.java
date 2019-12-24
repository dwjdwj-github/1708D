package com.daiwenjie.cms.service;

import java.util.List;

import com.daiwenjie.cms.domain.Comment;
/**
 * 评论业务层
 * @author Administrator
 *
 */
public interface CommentService {

	int addComment(Comment comment);

	List<?> commentList(Integer id);

}
