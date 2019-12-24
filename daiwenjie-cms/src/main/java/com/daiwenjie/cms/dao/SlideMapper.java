/**
 * 
 */
package com.daiwenjie.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.daiwenjie.cms.domain.Slide;

/**
 * 说明:广告dao层接口
 * 
 * @author
 * @version 1.0
 *
 */
public interface SlideMapper {

	public void insert(Slide slide);
	
	public void updateByKey(Slide slide);

	public void deleteById(int id);

	public Slide selectById(int id);
	
	public List<Slide> selectTop(@Param("size") int size);

	public List<Slide> selectAll();
	
}
