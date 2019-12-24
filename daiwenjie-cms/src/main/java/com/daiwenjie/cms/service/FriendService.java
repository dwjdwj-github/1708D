package com.daiwenjie.cms.service;

import java.util.List;

import com.daiwenjie.cms.domain.FriendShip;
/**
 * 友情链接
 * @author Administrator
 *
 */
public interface FriendService {

	List<?> friendList();

	int addFriend(FriendShip friend);

}
