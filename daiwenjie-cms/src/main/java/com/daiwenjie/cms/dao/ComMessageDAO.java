package com.daiwenjie.cms.dao;

import com.daiwenjie.cms.domain.ComMessage;
/**
 * 投诉信息dao
 * @author Administrator
 *
 */
public interface ComMessageDAO {
	/**
	 * 添加投诉信息
	 * @param comMessage
	 * @return
	 */
public int addComMessage(ComMessage comMessage);
}
