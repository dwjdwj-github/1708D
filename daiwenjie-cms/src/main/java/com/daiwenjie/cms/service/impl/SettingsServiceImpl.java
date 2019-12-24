/**
 * 
 */
package com.daiwenjie.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.daiwenjie.cms.dao.SettingsMapper;
import com.daiwenjie.cms.domain.Settings;
import com.daiwenjie.cms.service.SettingsService;

/**
 * 说明:频道与分类服务
 * 
 * @author 
 * @version 1.0
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class SettingsServiceImpl implements SettingsService {

	@Resource
	private SettingsMapper settingsMapper;

	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SettingsService#save(com.bawei.cms.domain.Settings)
	 */
	@Override
	public void save(Settings settings) {
		settings.setId(Settings.DEFAULT_ID);
		settingsMapper.insert(settings);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SettingsService#update(com.bawei.cms.domain.Settings)
	 */
	@Override
	public void update(Settings settings) {
		settings.setId(Settings.DEFAULT_ID);
		settingsMapper.update(settings);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SettingsService#get()
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public Settings get() {
		return settingsMapper.select();
	}

}
