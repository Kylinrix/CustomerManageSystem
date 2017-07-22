<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/pageCss.css"/>
<title>Insert title here</title>
</head>
<body>
 <c:import url="top.jsp"></c:import> 
<h3>${msg}</h3>
    <table align="center">
    <thead> 
    	<tr>
    	<th colspan="7">客户列表</th>
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
        <c:forEach items="${custJson}" var="cust">
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