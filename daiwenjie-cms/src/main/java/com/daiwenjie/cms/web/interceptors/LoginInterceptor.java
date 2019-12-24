package com.daiwenjie.cms.web.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.daiwenjie.cms.domain.User;
import com.daiwenjie.cms.service.UserInfoService;
import com.daiwenjie.cms.utils.CookieUtils;
import com.daiwenjie.cms.web.forms.UserForm;

/**
 * 用户免登录拦截器
 * 
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Resource
	private UserInfoService userInfoService;

	/**
	 * 预处理方法
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取Cookie
		String userName = CookieUtils.getCookieValue(request, "userName");
		String userPassword = CookieUtils.getCookieValue(request, "userPassword");
		// 判断是否从cookie中取出值
		if (userName != null && userPassword != null) {
			// 把cookie中获取的用户名和密码封装到对象中
			UserForm userForm = new UserForm();
			userForm.setUsername(userName);
			userForm.setPassword(userPassword);
			// 调用业务层
			User user = userInfoService.login(userForm);
			if (user != null) {// 登录成功
				// 放入session
				// Constant.setLoginUserToSession(request, user);
				request.getSession().setAttribute("_LOGIN_USER_", user);
			}
		}

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
