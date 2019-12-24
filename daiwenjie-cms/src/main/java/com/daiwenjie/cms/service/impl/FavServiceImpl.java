package com.daiwenjie.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daiwenjie.cms.dao.FavDAO;
import com.daiwenjie.cms.domain.Fav;
import com.daiwenjie.cms.service.FavService;


@Service
public class FavServiceImpl implements FavService {
	
	@Resource
	private FavDAO favDAO;
	@Override
	public List<Fav> list() {
		// TODO Auto-generated method stub
		return favDAO.list();
	}

}
