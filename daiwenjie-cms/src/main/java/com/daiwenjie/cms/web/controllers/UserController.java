/**
 * 
 */
package com.daiwenjie.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.daiwenjie.cms.domain.Article;
import com.daiwenjie.cms.domain.Comment;
import com.daiwenjie.cms.domain.User;
import com.daiwenjie.cms.service.ArticleService;
import com.daiwenjie.cms.service.ChannelCategoryService;
import com.daiwenjie.cms.service.CommentService;
import com.daiwenjie.cms.utils.FileUploadUtil;
import com.daiwenjie.cms.web.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.Date;
/**
 * 说明:个人空间控制器
 * 
 * @author 
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/my")
public class UserController {

	// 用到业务层的articleService
	@Resource
	private ArticleService articleService;
	@Resource
	private ChannelCategoryService  channelCategoryService;
	@Resource
	private CommentService commentService;
	
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}
	
	
	// 将文章信息 发布到 列表中
	/*描述：1： 导入分页的依赖
	 * 	  2：在spring-context.xml 的SQLSessionFactory中加入pageHelper的配置
	 *    3： 在方法中使用pagehelper拦截器
	 * 	4：分页操作
	 * 	 5：使用bootstrap完成分页的样式展示
	 */
	@RequestMapping({"/blogs"})
	public String blogs(Model model,@RequestParam(value="cpage",defaultValue="1")Integer cpage,HttpServletRequest request) {
		User loginUser = Constant.getLoginUser(request);
		PageHelper.startPage(cpage,5);
		List list=articleService.articleList(loginUser);
		
		PageInfo<?> pi = new PageInfo<>(list);
		model.addAttribute("blogs", list);
		model.addAttribute("pi", pi);
		// 导航
		
		return "user-space/blog_list";
	}
	
	@RequestMapping("/blog/edit")
	// 因为有JSR 303 的操作  所以需要在model中验证是否有 对象存在 
	// 因为有错误信息也是存在对象中的 所以对象如果存在证明 
	// 验证不成功--直接将model 中的对象发送到前台页面即可
	public String editBlog(Model model,Integer id) {
		// 添加页面的跳转带jsr303
		if(id==null) {
			if(!model.containsAttribute("blog")) {
				model.addAttribute("blog", new Article());
			}
			// 说明id有值那么通过id 查询取到对象
			// 回显 带jsr303
		}else {
			Article article=articleService.getArticle(id);
			model.addAttribute("blog", article);
		}
		return "user-space/blog_edit";
	}
	
	
	
	
	// 当前方法为频道的下拉列表  因为是Ajax 所以有responseBody
	@RequestMapping("/blog/channelList")
	@ResponseBody
	public Object channelList() {
		List list=channelCategoryService.getChannels();
		return list;
	}
	
	// 当前方法为频道的下拉列表  因为是Ajax 所以有responseBody
	@RequestMapping("/blog/categoryList")
	@ResponseBody
	public Object categorylList(Integer cid) {
		List list=channelCategoryService.getCategories(cid);
		return list;
	}
	
	@RequestMapping("/blog/save")
	// jsr 303 验证  需要在被验证对象前加入注解@valid 与@modelAttribute 
	// 被验证对象与BindingResult 对象之间不可以插入任意参数
	public String saveBlog(MultipartFile file ,Model model,@Valid @ModelAttribute("blog") Article blog,BindingResult br,HttpServletRequest request ) {
		if(br.hasErrors()) {
			List<ObjectError> allErrors = br.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			// 当验证失败直接调用方法而不是操作 跳转及转发
			return editBlog(model,null);
		}
		// 如果添加了新的图片那么这个判断成立
		if(file.getOriginalFilename().length()>0) {
			// 图片上传  
			// 返回值为删除图片的路径
			String load = FileUploadUtil.load(request.getSession(), file, Constant.UPLOAD_DIR);
			// 将路径添加到文章中
			blog.setPicture(Constant.UPLOAD_DIR+"/"+load);
		}
		// 文章添加
		// 从session作用域中取出当前登录的用户对象
		User loginUser = Constant.getLoginUser(request);
		// 设置blog（文章的Author 作者） 的值为当前登录的用户对象
		blog.setAuthor(loginUser);
		int i=articleService.saveBlog(blog);
		return "redirect:../blogs";
	}
	
	// 假删
	@RequestMapping(value="/blog/remove",method=RequestMethod.GET)
	@ResponseBody
	public Object remove(Integer id) {
		int i=articleService.remove(id);
		return i;
	}
	
	@RequestMapping("/comment/{id}")
	@ResponseBody
	public Object comment(@PathVariable Integer id,Comment comment,HttpServletRequest request) {
		// 给评论对象  赋值（文章id的值）
		comment.setBlog(new Article(id));
		// 给评论对象赋值（作者的id）
		User loginUser = Constant.getLoginUser(request);
		comment.setAuthor(loginUser);
		//赋值推荐service 操作 
		comment.setDisplayTime(new Date());
		int i=commentService.addComment(comment);
		return i;
	}
}
