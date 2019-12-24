/**
 * 
 */
package com.daiwenjie.cms.web.controllers.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.daiwenjie.cms.service.ArticleService;
import com.daiwenjie.cms.service.UserInfoService;

/**
 * 说明:后台控制器
 * 
 * @author 
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private ArticleService articleService;
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
	
	/**
	 * 进入后台投诉管理界面
	 * @param model
	 * @param cpage
	 * @return
	 */
	
	@RequestMapping("/toComMessages")
	public String comMessages(Model model,@RequestParam(value="cpage",defaultValue="1")Integer cpage) {
		//PageHelper.startPage(cpage,8);
		//查询投诉信息
		
		//投诉信息存入Model中
		
		return "admin/tousu-manage";
	}
	// 用户管理页面
	@RequestMapping("/mangmentUser")
	public String userMangerList(Model model,@RequestParam(value="cpage",defaultValue="1")Integer cpage) {
		PageHelper.startPage(cpage,8);
		// 查询用户列表
		List<?> list=userInfoService.userList();
		PageInfo<?> pi=new PageInfo<>(list);
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "admin/user-manage";
	}
	
	@RequestMapping("/lockedUser")
	public String lockedUser(Integer id) {
		int i=userInfoService.lockedUser(id);
		if(i>0) {
			return "redirect:/admin/mangmentUser";
		}
		else {
			return "redirect:/admin/mangmentUser";
		}
	}
	
	
	@RequestMapping("/articleMangment")
	public String articleMangment(Model model,@RequestParam(value="cpage",defaultValue="1")Integer cpage) {
		// 文章管理 相当于  管理员 对所有文章都具有可视性
		PageHelper.startPage(cpage,10);
		List<?> list=articleService.articleListAll();
		PageInfo<?> pi=new PageInfo<>(list);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "admin/article-manage";
	}
	
	@RequestMapping("/updStatus")
	public String updStatus(Integer id) {
		int i=articleService.updStatus(id);
		if(i>0) {
			return "redirect:/admin/articleMangment";
		}
		else {
			return "redirect:/admin/articleMangment";
		}
		
	}
	/**
	 * 自定义测试分页功能,与考试无关
	 * @param model
	 * @param cpage
	 * @return
	 */
	@RequestMapping("/testArticleMangment")
	public String testArticleMangment(Model model,@RequestParam(value="cpage",defaultValue="1")Integer cpage) {
		// 文章管理 相当于  管理员 对所有文章都具有可视性
		PageHelper.startPage(cpage,2);
		List<?> list=articleService.articleListAll();
		PageInfo<?> pi=new PageInfo<>(list);
		System.out.println("分页对象信息"+pi);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "admin/article-test-page";
	}
}
