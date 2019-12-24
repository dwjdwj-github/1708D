/**
 * 
 */
package com.daiwenjie.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.daiwenjie.cms.domain.Category;

/**
 * 说明:类目dao层接口
 * 
 * @author 
 * @version 1.0
 *
 */
public interface CategoryMapper {

	public void insert(Category category);

	public void deleteById(int id);

	public Category selectById(int id);
	
	public List<Category> selectAll();
	
	public List<Category> selectByChannel(@Param("channel_id") int channelId);
	
	
}
