package com.daiwenjie.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiwenjie.cms.dao.ComMessageDAO;
import com.daiwenjie.cms.domain.ComMessage;
import com.daiwenjie.cms.service.ComMessageService;



@Service
@org.springframework.transaction.annotation.Transactional
public class ComMessageServiceImpl implements ComMessageService {
	@Autowired
public ComMessageDAO comMessageDAO;
	
	public int addComMessage(ComMessage comMessage) {
		return comMessageDAO.addComMessage(comMessage);
	}

}
