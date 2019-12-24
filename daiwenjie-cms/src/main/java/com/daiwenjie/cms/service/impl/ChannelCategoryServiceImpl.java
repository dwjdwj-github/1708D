/**
 * 
 */
package com.daiwenjie.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.daiwenjie.cms.dao.CategoryMapper;
import com.daiwenjie.cms.dao.ChannelMapper;
import com.daiwenjie.cms.domain.Category;
import com.daiwenjie.cms.domain.Channel;
import com.daiwenjie.cms.service.ChannelCategoryService;

/**
 * 说明:频道与分类服务
 * 
 * @author 
 * @version 1.0
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class ChannelCategoryServiceImpl implements ChannelCategoryService {

	@Resource
	private ChannelMapper channelMapper;
	
	@Resource
	private CategoryMapper categoryMapper;
	
	

	//----------------------------------频道----------------------------
	
	
	@Transactional
	public void saveChannel(Channel channel) {
		channelMapper.insert(channel);
	}

	@Transactional
	public void removeChannel(int id) {
		channelMapper.deleteById(id);
	}
	
	public Channel getChannel(int id) {
		return channelMapper.selectById(id);
	}

	public List<Channel> getChannels() {
		return channelMapper.selectAll();
	}

	
	//----------------------------------分类----------------------------
	
	@Transactional
	public void saveCategory(Category category) {
		categoryMapper.insert(category);
	}

	@Transactional
	public void removeCategory(int id) {
		categoryMapper.deleteById(id);
	}
	
	public Category getCategory(int id) {
		return categoryMapper.selectById(id);
	}

	public List<Category> getCategories(int channelId) {
		return categoryMapper.selectByChannel(channelId);
	}

	public List<Category> getCategories() {
		return categoryMapper.selectAll();
	}
	
	
}
