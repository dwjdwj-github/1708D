package com.daiwenjie.cms.web.controllers;

import java.util.List;

/**
 * 收藏控制器
 */
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.daiwenjie.cms.domain.Fav;
import com.daiwenjie.cms.service.FavService;
@Controller
public class FavController {
	@Resource
	private FavService favService;
	@RequestMapping("fav")
	public String list(Fav fav,Model model,@RequestParam(value="cpage",defaultValue="1") Integer cpage) {
		PageHelper.startPage(cpage, 2);
		List<Fav> list = favService.list();
		PageInfo<Fav> pageInfo = new PageInfo<>(list);
		model.addAttribute("pi", pageInfo);
		return "/user-space/blog_fav";
	}
}
