package com.daiwenjie.cms.service;

import java.util.List;

import com.daiwenjie.cms.domain.Slide;

/**
 * 说明:广告
 * 
 * @author 
 * @version 1.0
 *
 */
public interface SlideService {

	public abstract void save(Slide slide);

	public abstract void update(Slide slide);

	public abstract void remove(int id);

	public abstract Slide get(int id);

	public abstract List<Slide> getTops(int size);

	public abstract List<Slide> getAall();

}