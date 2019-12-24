package com.daiwenjie.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daiwenjie.cms.dao.CommentDAO;
import com.daiwenjie.cms.domain.Comment;
import com.daiwenjie.cms.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl  implements CommentService{
	@Resource
	private CommentDAO commentDAO;
	
	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentDAO.addComment(comment);
	}

	@Override
	public List<?> commentList(Integer id) {
		// TODO Auto-generated method stub
		return commentDAO.commentList(id);
	}

}
