<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head title="GSQ-学生列表">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>学生列表-GSQ-学生管理系统</title>
	<link rel="stylesheet" href="static/css/bootstrap.min.css">   
	<style type="text/css">
		body{ font-family: 'Microsoft YaHei';}
		/*.panel-body{ padding: 0; }*/
	</style>
</head>
<body>
<div class="jumbotron">
	<div class="container">
  		<h3>搞事情工作室学生信息列表</h3>
  		
	</div>
</div>
<div class="container">
	<div class="main">
		<div class="row">
			<!-- 左侧内容 -->
			<div class="col-md-3">
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/getStudents?currentPage=1&currentCount=10" class="list-group-item text-center active">学生列表</a>
					<a href="${pageContext.request.contextPath}/addstudent.jsp" class="list-group-item text-center ">添加学生</a>
				</div>
			</div>
			<!-- 右侧内容 -->
			<div class="col-md-9">
				<!-- 成功提示框 -->
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="false">&times;</span><span class="sr-only">Close</span></button>
					<strong>成功！</strong> 操作成功提示
				</div>
				<!-- 失败提示框 -->
				<div style="display: none" class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<strong>失败！</strong> 操作失败提示
				</div>
				<!-- 自定义内容 -->
				<div class="panel panel-default">
					<div class="panel-heading">学生列表</div>
					<div class="panel-body">
						<table class="table table-striped table-responsive table-hover">
							<thead>
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>出生日期</th>
									<th>性别</th>
									<th>民族</th>
									<th>政治面貌</th>
									<th>职务</th>
									<th width="120">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${page.list}" var="student">
								<tr>
									<th>${student.id}</th>
									<td>${student.name}</td>
									<td>${student.date}</td>

									<c:if test="${student.xb==1}">
										<td>男</td>
									</c:if>
									<c:if test="${student.xb==2}">
										<td>女</td>
									</c:if>
									<td>${student.minzu}</td>
									<td>${student.zzmm}</td>
									<td>${student.zhiwu}</td>
									<td>
										<%--<a href="">详情</a>--%>
										<a href="${pageContext.request.contextPath}/delete?id=${student.id}">删除</a>
										<a href="${pageContext.request.contextPath}/student-update.jsp?id=${student.id}&name=${student.name}&date=${student.date}&xb=${student.xb}&minzu=${student.minzu}&zzmm=${student.zzmm}&zhiwu=${student.zhiwu}">修改</a>
									</td>
								</tr>
							</c:forEach>


							</tbody>
						</table>
					</div>
				</div>

				<nav>
					<ul class="pagination pull-right">
					<li  class="previous"><a href="#">&laquo;</a></li>
						<c:forEach begin="1" end="${page.totalPage}" var="Page">
							<li><a href="${pageContext.request.contextPath}/getStudents?currentPage=${Page}&currentCount=10">${Page}</a></li>
							<%--<!-- 判断是否是当前页 -->--%>
							<%--<c:if test="${page==page.currentPage }">--%>
							<%--<li class="active"><a href="javascript:void(0);">${page}</a></li>--%>
						<%--</c:if>--%>
							<%--<c:if test="${page!=page.currentPage }">--%>
								<%--<li><a href="${pageContext.request.contextPath}/productListByCid?cid=${cid}&currentPage=${page }">${page }</a></li>--%>
							<%--</c:if>--%>
						</c:forEach>

						<li><a href="#">&raquo;</a></li>
					</ul>

				</nav>

				<!--分页 -->
				<%--<nav>--%>
					<%--<ul class="pagination pull-right">--%>
						<%--<li  class="previous"><a href="#">&laquo;</a></li>--%>
						<%--<c:forEach begin="1" end="${page.totalPage}" var="Page">--%>
							<%--<li><a href="${pageContext.request.contextPath}/getStudents&currentPage=${Page}&currentCount=10">${Page}</a></li>--%>
						<%--</c:forEach>--%>
						<%--<li><a href="#">&raquo;</a></li>--%>
					<%--</ul>--%>

				</nav>







				<!-- 分页结束 -->
				<%--<ul class="pagination pull-right">--%>
					<%--<li  class="previous"><a href="#">&laquo;</a></li>--%>
					<%--<c:forEach begin="1" end="${pageBean.totalPage+1}" var="page">--%>
						<%--<li><a href="${pageContext.request.contextPath}/category?method=getCategoryList&currentPage=${page}&currentCount=10">${page}</a></li>--%>
					<%--</c:forEach>--%>
					<%--<li><a href="#">&raquo;</a></li>--%>
				<%--</ul>--%>
			</div>
		</div>
  	</div>
</div>
<!-- 尾部 -->
<div class="jumbotron" style=" margin-bottom:0;margin-top:105px;">
	<div class="container">
	<span>&copy; 2019 GSQ</span>
	</div>
</div>


	<script src="static/js/jquery-3.1.0.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>