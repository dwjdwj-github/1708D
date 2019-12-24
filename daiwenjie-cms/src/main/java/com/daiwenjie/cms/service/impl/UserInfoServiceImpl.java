package com.daiwenjie.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.daiwenjie.cms.dao.UserInfoDAO;
import com.daiwenjie.cms.domain.User;
import com.daiwenjie.cms.service.UserInfoService;
import com.daiwenjie.cms.utils.AssertUtil;
import com.daiwenjie.cms.web.forms.UserForm;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoDAO  userInfoDAO;

	// 注册方法
	
	public int reg(UserForm userForm) {
		// 判断用户名密码是否为null
		// 断言  执行  用户名不能为null 如果为空抛出异常
		AssertUtil.isTrue(!userForm.getUsername().equals(""), "用户名不能为空");
		AssertUtil.isTrue(!userForm.getPassword().equals(""), "密码不能为空");
		AssertUtil.isTrue(userForm.getPassword().equals(userForm.getRePassword()), "密码与确认密码不一致");
		
		// 需要判断用户名在数据库中是否存在
		// 方法说明：通过用户名在数据库中查找由几个
		int i=userInfoDAO.getCountByUname(userForm.getUsername());
		AssertUtil.isTrue(i==0, "用户名已存在");
		
		// 如果以上断言都通过那么可以执行注册对象的复制：将user Form中的值 存到 user对象中
		User user=new User();   // 密码？
		user.setUsername(userForm.getUsername());
		user.setNickname(user.getUsername());
		user.setGender(userForm.getGender()); // userForm中的性别就是user中的性别（com.hq.cms.metas.Gender是枚举类型）
		user.setLocked(true); // 默认设置用户不锁定    false 锁定   true 不锁定
		user.setCreated(new Date());
		user.setUpdated(user.getCreated());
		// 密码的操作  加密（加盐）
		user.setPassword(UserInfoService.encrypt(user.getUsername(), userForm.getPassword()));
		// 注册 
		int j=userInfoDAO.reg(user);
		return j;
	}

	// 方法说明：登录
	@Override
	public User login(UserForm userForm) {
		// 断言验证用户名密码不能为空
		AssertUtil.isTrue(!userForm.getUsername().equals(""), "用户名不能为空");
		AssertUtil.isTrue(!userForm.getPassword().equals(""), "密码不能为空");
		
		User user=userInfoDAO.getUserByUsername(userForm.getUsername());
		// user为从数据库中查找的对象 也就是说密码是  加密后的
		// 从user Form中获取加密前的密码并且 通过方法加密 然后与user对象中的password 对比 
		// password 是将userForm对象的密码进行加密
		AssertUtil.isTrue(user!=null, "用户名不存在");
		String password = UserInfoService.encrypt(userForm.getUsername(), userForm.getPassword());
		AssertUtil.isTrue(user.getPassword().equals(password), "用户名或密码错误");
		System.out.println("===="+user.getLocked());
		// 当值为true 时 是开方的  当值为false 时   用户锁定
		AssertUtil.isTrue(user.getLocked(), "用户已锁定请尽快联系管理员");
		// 创建一个新的user对象用于存放在session中
		User target=new User();
		BeanUtils.copyProperties(user, target, "password");
		return target;
	}

	@Override
	public List<?> userList() {
		// TODO Auto-generated method stub
		return userInfoDAO.userList();
	}

	@Override
	public int lockedUser(Integer id) {
		// TODO Auto-generated method stub
		return userInfoDAO.lockedUser(id);
	}

	/**
	 * 根据用户名手动生成密码
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(UserInfoService.encrypt("test", "123456"));
	}
	// 完成注册操作
	
}
