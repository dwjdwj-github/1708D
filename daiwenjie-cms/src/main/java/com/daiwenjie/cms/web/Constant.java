/**
 * 
 */
package com.daiwenjie.cms.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.daiwenjie.cms.domain.User;

/**
 * 说明:
 * 
 * @author
 * @version 1.0
 *
 */
public class Constant implements Serializable {

	
	private static final long serialVersionUID = 1L;

	/**上传目录**/
	public static final String UPLOAD_DIR = "/upload";
	
	/**管理员登录key**/
	public static final String LOGIN_ADMIN = "_LOGIN_ADMIN_";
	
	/**登录用户key，用户登录成功后，存到sesssion中的属性**/
	public static final String LOGIN_USER = "_LOGIN_USER_";
	/**
	 * 把登录用户信息存入session中
	 * @param request
	 * @param user
	 */
	public static void setLoginUserToSession(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		setLoginUser(session, user);
	}
	
	public static void setLoginUser(HttpSession session, User user){
		session.setAttribute(Constant.LOGIN_USER, user);
	}
	
	public static User getLoginUser(HttpServletRequest request){
		return getLoginUser(request.getSession(false));
	}
	
	public static User getLoginUser(HttpSession session){
		User user = session == null ? null : (User) session.getAttribute(Constant.LOGIN_USER);
		return user;
	}

}
