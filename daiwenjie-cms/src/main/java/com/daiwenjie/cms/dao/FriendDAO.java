package com.daiwenjie.cms.dao;

import java.util.List;

import com.daiwenjie.cms.domain.FriendShip;
 /**
  * 友情链接dao层接口
  * @author Administrator
  *
  */
public interface FriendDAO {

	List<?> friendList();

	int addFriend(FriendShip friend);


}
