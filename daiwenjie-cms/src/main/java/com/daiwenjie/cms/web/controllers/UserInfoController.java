package com.daiwenjie.cms.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daiwenjie.cms.core.CMSRuntimeException;
import com.daiwenjie.cms.domain.User;
import com.daiwenjie.cms.service.UserInfoService;
import com.daiwenjie.cms.utils.CookieUtils;
import com.daiwenjie.cms.web.Constant;
import com.daiwenjie.cms.web.forms.UserForm;


/**
 * 用户登录  注册控制器
 * @author Administrator
 *
 */
@Controller
public class UserInfoController {
	@Resource
	private UserInfoService  userInfoService;

	/**
	 * 进入注册页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/reg",method=RequestMethod.GET)
	public String toReg(Model model) {
		model.addAttribute("userForm", new UserForm());
		
		return "passport/reg";
	}
	/**
	 * 用户注册
	 * @param userForm
	 * @param attr
	 * @param model
	 * @return
	 */
	// 当点击注册按钮时完成此功能
	// 方法说明：注册
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(UserForm userForm,RedirectAttributes attr,Model model) {
		try {
			userInfoService.reg(userForm);
			// 重定向传值
			attr.addFlashAttribute("message", "注册成功");
			return "redirect:reg";
		} catch (CMSRuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "passport/reg";
	}
	
	/**
	 * 进入登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String tologin() {
		
		return "passport/login";
	}
	/**
	 * 用户登录
	 * @param model
	 * @param userForm
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Model model,UserForm userForm,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("userForm", new UserForm());
		// userForm 中由用户名及密码 但是    数据库中的密码是加密后的而前台接受的密码是未加密
		try {
			//调用登录业务
			User user=userInfoService.login(userForm);
			// 如果登录成功需要将user对象放入到session中   
			Constant.setLoginUserToSession(request, user);
			//免登录开始
			//获取是否记住我标记
			if("rememberMe".equalsIgnoreCase(userForm.getRemember())) {
				if(user!=null) {//表示登录成功
					//把用户名和密码存入Cookie中
					CookieUtils.setCookie(request, response, "userName", userForm.getUsername(), 1000*60*60*24*7);
					CookieUtils.setCookie(request, response, "userPassword", userForm.getPassword(), 1000*60*60*24*7);
				}
			}
			//免登录结束

			return "redirect:/index";
		} catch (CMSRuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "passport/login";
	}
	
	@RequestMapping("/logout")
	public String logOut(Model model,HttpServletRequest request) {
		request.getSession().removeAttribute("_LOGIN_USER_");
		// 注销session作用域
		request.getSession().invalidate();
		// 退回到主页面
		model.addAttribute("userForm", new UserForm());
		//return "redirect:/index";
		return "passport/login";
	}
}
