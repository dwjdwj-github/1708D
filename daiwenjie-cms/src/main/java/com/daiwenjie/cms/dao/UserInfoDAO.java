package com.daiwenjie.cms.dao;

import java.util.List;

import com.daiwenjie.cms.domain.User;
/**
 * 用户dao层接口
 * @author Administrator
 *
 */
public interface UserInfoDAO {

	int getCountByUname(String username);

	int reg(User user);

	User getUserByUsername(String username);

	List<?> userList();

	int lockedUser(Integer id);

}
