<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 后台投诉管理页面 -->
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CMS后台管理系统</title>
     <!-- Bootstrap core CSS-->
    <link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
<!--     <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<!--     <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css"> -->
	<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">
	<script type="text/javascript">
		function fenye(cpage){
			location="/admin/mangmentUser?cpage="+cpage;
		}
	
	
	</script>
  </head>

  <body id="page-top">
    <!-- 后台管理系统顶部 -->
 	<jsp:include page="_inc_top.jsp"/>
    <div id="wrapper">
      	<!-- 后台管理系统左部菜单 -->
 		<jsp:include page="_inc_left.jsp"/>
      <div id="content-wrapper">
        <div class="container-fluid">
          <!-- 面包屑 -->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">后台首页</a>
            </li>
            <li class="breadcrumb-item active">投诉管理</li>
          </ol>
          <!-- Page Content -->
          <h1>投诉管理</h1>
          <hr>
			<!-- 用户的列表展示 -->
		<table class="table table-bordered">
		<tr>
		
				<td colspan="9">
					 投诉次数:
				 <input typt="text" style="width:120px" class="form-control">
				投诉类型:
				<select name="tid"  style="width:120px" class="form-control">
									<option value="1">垃圾广告</option>
									<option value="2">涉黄淫秽</option>
									<option value="3">政治反动</option>
									<option value="4">网络钓鱼</option>
									<option value="5">网络欺诈</option>
									</select>
				
			
				 <input type="submit" value="查询">
				 </td>
				
				
			</tr>
			<tr>
				<td>投诉编号</td>
				<td>投诉人姓名</td>
				<td>投诉电话</td>
				<td>投诉人邮箱</td>
				<td>投诉信息</td>
				<td>文章地址</td>
				<td>投诉类型</td>
				<td>投诉次数</td>
				<td>如何操作</td>
			</tr>
		<!-- 遍历投诉信息 -->
		
				<tr>
				<td>投诉编号</td>
				<td>投诉人户名</td>
				<td>投诉电话</td>
				<td>投诉人邮箱</td>
				<td>投诉信息</td>
				<td>文章地址</td>
				<td>投诉类型</td>
				<td>投诉次数</td>
				<td>如何操作</td>
				</tr>
			
			
		</table>
			
        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © Your Website 2018</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/libs/jquery/jquery.min.js"></script>
    <script src="/libs/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/libs/sb-admin/sb-admin.min.js"></script>

  </body>

</html>
