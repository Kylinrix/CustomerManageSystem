<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/pageCss.css"/>
</head>
<body>
 <c:import url="top.jsp"></c:import> 
<div class="basic-grey">
	<form action="<c:url value='/customerEditEditServlet'/>" method="post" >
	<h1 align="center">编辑客户
	<span>请填写下列内容</span>
	</h1>
	<label>
	<span>客户ID</span>
	<input id="name" type="text" name="id" required="required" placeholder="请输入您想修改的客户ID"   value="${customerEdit.id}"  />
		</label>

	</h1>
	<label>
	<span>姓名 :</span>
	<input id="name" type="text" name="name" required="required" placeholder="请输入姓名" value="${customerEdit.name}"   />
	</label>
	<label>
	<span>性别 :</span><select name="sex">
	<option value="男">男</option>
	<option value="女">女</option>
	</select>
	</label>
	<label>
	<span>电话 :</span>
	<input id="phone" type="text" name="phone" required="required" placeholder="请输入电话号码" value="${customerEdit.phone}" />
		</label>

	<label>
	<span>邮箱 :</span>
	<input id="email" type="email" name="email" required="required" placeholder="请输入邮箱地址" value="${customerEdit.email}"  />
	</label>
	<label>
	<span>描述详情 :</span>
	<textarea id="message" name="description" placeholder="请输入客户描述">${customerEdit.description} </textarea>
	</label>
	
	<input type="hidden" name="submitType" value="updateCustomer"></input>
	<label>
	<span>&nbsp;</span>
	<button type="submit" class="button"  value="Send" >Submit</button>
	</label>
	
	</form>
</div>
<c:import url="footer.jsp"></c:import> 
</body>
</html>