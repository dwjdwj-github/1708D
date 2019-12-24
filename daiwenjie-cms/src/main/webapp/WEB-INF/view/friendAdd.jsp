<%@page import="com.hc.cms.metas.Gender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- 友情链接添加页面 -->
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>欢迎回来</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
 	<link rel="stylesheet" type="text/css" href="/css/cms.css"/>
 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>

		<div class="container" align="center">
		<div class="row passport_bg">
			<div class="col-md-6">
				<div class="passport_panel">
					<div class="card">
					  <div>
					    <form:form modelAttribute="friend" action="/addFriend" class="form-inline" method="post">
					    	<p class="w-100" align="center" class="red">${message}</p>
					    	  <!--    <form:hidden path="url"/>   -->
					    	<p class="w-100">网站名称：<form:input path="text" placeholder="请填文本名称" class="form-control"/></p>
					    	<p class="w-100">收藏网址：<form:input path="url" placeholder="请填写正确地址" class="form-control"/></p>
					    	<p class="w-100">　　　　　<button type="submit" class="btn btn-info">添加</button></p>
					    </form:form>
					  </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
  </body>
</html>