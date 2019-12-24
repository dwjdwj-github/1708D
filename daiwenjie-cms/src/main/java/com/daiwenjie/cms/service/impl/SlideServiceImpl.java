/**
 * 
 */
package com.daiwenjie.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.daiwenjie.cms.dao.SlideMapper;
import com.daiwenjie.cms.domain.Slide;
import com.daiwenjie.cms.service.SlideService;

/**
 * 说明:频道与分类服务
 * 
 * @author 
 * @version 1.0
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class SlideServiceImpl implements SlideService {

	@Resource
	private SlideMapper slideMapper;

	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#save(com.bawei.cms.domain.Slide)
	 */
	@Override
	@Transactional
	public void save(Slide slide) {
		slide.setCreated(new Date());
		slideMapper.insert(slide);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#updateByKey(com.bawei.cms.domain.Slide)
	 */
	@Override
	@Transactional
	public void update(Slide slide) {
		slideMapper.updateByKey(slide);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#deleteById(int)
	 */
	@Override
	@Transactional
	public void remove(int id){
		slideMapper.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#selectById(int)
	 */
	@Override
	public Slide get(int id){
		return slideMapper.selectById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#selectTop(int)
	 */
	@Override
	public List<Slide> getTops(int size){
		return slideMapper.selectTop(size);
	}

	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.SlideService#selectAll()
	 */
	@Override
	public List<Slide> getAall(){
		return slideMapper.selectAll();
	}
	
}
