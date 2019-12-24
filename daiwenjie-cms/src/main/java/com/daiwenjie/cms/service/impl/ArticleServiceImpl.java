/**
 * 
 */
package com.daiwenjie.cms.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.daiwenjie.cms.core.Page;
import com.daiwenjie.cms.dao.ArticleMapper;
import com.daiwenjie.cms.domain.Article;
import com.daiwenjie.cms.domain.User;
import com.daiwenjie.cms.service.ArticleService;

/**
 * 说明:
 * 
 * @author 
 * @version 1.0
 *
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders) {
		List<Article> articles = articleMapper.selects(conditions, orders, page);
		if(page != null && page.getPageCount() == 0){
			int totalCount = articleMapper.count(conditions);
			page.setTotalCount(totalCount);
		}
		return articles;
	}

	@Override
	public List<?> articleList(User loginUser) {
		// TODO Auto-generated method stub
		List<?> list=articleMapper.articleList(loginUser);
		return list;
	}

	@Override
	public int saveBlog(Article blog) {
		// 1判断summary(摘要)是否为空字符串 "" 如果为空   截取content(内容)放到summary中
		if(blog.getSummary().length()<1) {
			String content = blog.getContent();
			// 取到内容后需要先将内容的标签去掉
			String replaceAll = content.replaceAll("<.+?>", "");
			// 去内容中的前5个字
			blog.setSummary(replaceAll.substring(0,5));
		}
		// blog 中有title  有content  有summary  有author（作者）
		//hits 点击量
		blog.setHits(0);
		//hot 是否上头条  默认上
		blog.setHot(true);
		//是否审核通过 默认通过：1
		blog.setStatus(1);
		//设置文章为不删除
		blog.setDeleted(false);
		// 创建时间及修改时间
		blog.setCreated(new Date());
		blog.setUpdated(blog.getCreated());
		int i=0;
		if(blog.getId()==null) {
			// 添加
			i=articleMapper.saveBlog(blog);
		}else {
			// 修改
			i=articleMapper.updateByKey(blog);
		}
	
		

		
		return i;
	}

	@Override
	public Article getArticle(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int remove(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.remove(id);
	}

	@Override
	public List<?> articleListAll() {
		// TODO Auto-generated method stub
		return articleMapper.articleListAll();
	}

	@Override
	public int updStatus(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.updStatus(id);
	}
	
	
}
