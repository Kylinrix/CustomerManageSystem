<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/pageCss.css"/>
<title>Insert title here</title>
</head>


<body>
 <c:import url="top.jsp"></c:import> 
<div class="basic-grey">
<form action="<c:url value='/CustomerServlet'/>" method="post" >

<h1>高级搜索
<span> 请填写下列内容 </span>
</h1>

<label>
<span>姓名 :</span>
<input id="name" type="text" name="name" placeholder="请输入客户姓名"    />
</label>

<label>
<span>性别:</span>
<select name="sex">
<!-- <option value="" selected="selected" disabled="disabled">选择性别</option> -->
<option value="男">男</option>
<option value="女">女</option>
</select>
</label>

<label>
<span>电话 :</span>
<input id="number" type="text" name="phone" placeholder="请输入电话号码" />
</label>

	<input type="hidden" name="submitType" value="advancedSearchCustomer"></input>
	<label>
	<span>&nbsp;</span>
	<button type="submit" class="button"  value="Send" >提交</button>
	</label>

</form>

</div>
<h3 align="center">${advancedSearchErrorMessage}</h3>
<table align="center">
    <thead> 
    	<tr>
    	<th colspan="7">搜索结果</th>
    	</tr>
        <tr>
        	<th>ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
	</thead> 
        <c:forEach items="${advancedSearchCustomerJson}" var="cust">
        <tr>
        	<td>${cust.id}</td>
            <td>${cust.name}</td>
            <td>${cust.sex}</td>
            <td>${cust.phone}</td>
            <td>${cust.email}</td>
            <td>${cust.description}</td>
            <td>
                <a href="<c:url value='/CustomerServlet?&method=doGet&submitType=sendCustomerToEdit&id=${cust.id}'/> ">编辑</a>
                <a href="<c:url value='/CustomerServlet?method=doGet&submitType=deleteCustomer&id=${cust.id}'/> ">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>
<c:import url="footer.jsp"></c:import> 
</body>
</html>