package com.daiwenjie.cms.service;

import com.daiwenjie.cms.domain.Settings;

/**
 * 说明:系统设置
 * 
 * @author
 * @version 1.0
 *
 */
public interface SettingsService {

	public abstract void save(Settings settings);

	public abstract void update(Settings settings);

	public abstract Settings get();

}