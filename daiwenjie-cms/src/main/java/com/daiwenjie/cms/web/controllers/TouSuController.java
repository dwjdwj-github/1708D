package com.daiwenjie.cms.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daiwenjie.cms.domain.ComMessage;
import com.daiwenjie.cms.domain.User;
import com.daiwenjie.cms.service.ComMessageService;
import com.daiwenjie.cms.web.Constant;

/**
 * 前端投诉控制器
 * @author Administrator
 *
 */
@Controller
public class TouSuController {
	@Autowired
	public ComMessageService comMessageService;
	/**
	 * 点击投诉链接进入投诉页面
	 * @param aid
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toTouSu") //   
	public String toTouSu(Integer aid ,Model model,HttpSession session) {
		System.out.println("被投诉的文章ID:"+aid);
		//把被投诉的文章id
		session.setAttribute("aid", aid);
		return "tousu";
	}
	
	/**
	 * 添加投诉信息
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping("/addComMessage") //    /article/95
	public String addComMessage(ComMessage message,Model model,HttpSession session) {
		//从session中取出文章id
		Integer aid=(Integer)session.getAttribute("aid");
		System.out.println("被投诉的文章ID:"+message);
		//从session中取出用户id
		//User user=(User)session.getAttribute("_LOGIN_USER_");//_LOGIN_USER_:用户登录成功后，存到sesssion中的属性
		User user=(User)session.getAttribute(Constant.LOGIN_USER);//http://localhost:8080/article/96=Constant.LOGIN_USER
		Integer uid=user.getId();
		//把用户id和文章id封装到message对象中
		message.setAid(aid);
		message.setUid(uid);
		//
		System.out.println(message);
		//调用业务层保存
		comMessageService.addComMessage(message);
		return "redirect:home";
	}
}
