<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid footer">
<!-- 页脚界面 -->
	<div class="container">
		<div id="friend" align="center">
		<!-- 友情链接 -->
		<a href="/toFriendAdd">添加友情链接</a> 友情链接：
	</div>
		<p align="center" class="small text-secondary">本项目是大数据学院专高一教学练习项目，旨在提高学生对项目的意识和编码能力。 </p>
		<p align="center">XXXXX&nbsp;&nbsp;&nbsp;&nbsp;mailto：<a href="mailto:442847015@qq.com">xxxxxx@qq.com</a></p>
	</div>
</div>
	<script type="text/javascript" src="/libs/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="/libs/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" >
		$(function (){
			// 动态加载 友情链接
			$.ajax({
				url:"/friendList",
				type:"post",
				dataType:"json",
				success:function (obj){
					// 追加到 div中
					for(var i in obj){
						//alert("<a href="+obj[i].url+">"+obj[i].text+"</a>&nbsp;&nbsp;");
						$("#friend").append("<a href="+obj[i].url+">"+obj[i].text+"</a>&nbsp;&nbsp;")
					}
				}
			})
		})
	</script>