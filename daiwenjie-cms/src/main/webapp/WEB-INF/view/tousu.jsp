<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>发布博客</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/libs/bootstrap/css/bootstrap.min.css" />
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/cms.css" />
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/inc/tousu_top.jsp"></jsp:include>

	<!-- 横幅 -->

	<br />
	<!-- 主体内容区 -->
	<div class="container" align="center">
		<div class="row">

			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<h2>我要投诉</h2>
						<hr />

						<form action="/addComMessage" method="post">
							<table>
								<tr>
									<td>投诉人姓名:</td>
									<td><input type="text" name="realname" class="form-control"></td>
								</tr>
								<tr>
									<td>投诉人电话:</td>
									<td><input type="text" name="phone" class="form-control"></td>
								</tr>
										<tr>
									<td>投诉人邮箱:</td>
									<td><input type="text" name="email" class="form-control"></td>
								</tr>
								<tr>
									<td>投诉类型:</td>
									<td>
									<select name="tid" class="form-control">
									<option value="1">垃圾广告</option>
									<option value="2">涉黄淫秽</option>
									<option value="3">政治反动</option>
									<option value="4">网络钓鱼</option>
									<option value="5">网络欺诈</option>
									</select>
                                    </td>
								</tr>
								<tr>
									<td>投诉信息:</td>
									<td><input type="text" name="cominfo" class="form-control"></td>
								</tr>
								<tr>
									<td>文章地址:</td>
									<td><input type="text" name="murl" class="form-control"></td>
								</tr>
								<tr>
							
									<td colspan="2"><input type="submit" value="投诉" class="btn btn-info btn-block"></td>
								</tr>
							</table>
						</form>


					</div>
				</div>

			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/inc/footer.jsp" />
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css" />
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js"></script>
	<link
		href="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
		rel="stylesheet">
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/lang/summernote-zh-CN.min.js"></script>

</body>
</html>