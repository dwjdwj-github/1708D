package com.daiwenjie.cms.service;

import com.daiwenjie.cms.domain.ComMessage;

public interface ComMessageService {
	/**
	 * 添加投诉信息
	 * @param comMessage
	 * @return
	 */
public int addComMessage(ComMessage comMessage);
}
