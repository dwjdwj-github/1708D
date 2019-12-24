/**
 * 
 */
package com.daiwenjie.cms.dao;

import com.daiwenjie.cms.domain.Settings;

/**
 * 说明:系统设置dao层接口
 * 
 * @author 
 * @version 1.0
 *
 */
public interface SettingsMapper {

	public void insert(Settings settings);
	
	public void update(Settings settings);

	public Settings select();
	
}
