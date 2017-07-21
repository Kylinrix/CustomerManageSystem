<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/mainPageCss.css"/>

<title>Insert title here</title>
</head>
<body>

<ul id="nav"> 
<li><a href="welcome.jsp">客户管理首页</a></li>
<li><a href="CustomerAdd.jsp">添加客户</a></li>
<li><a href="CustomerEdit.jsp">编辑客户</a></li>
<li> <a href="<c:url value='/CustomerServlet?method=doGet&submitType=showAllCustomer'/>">查询客户</a></li>
<li><a href="CustomerSearch.jsp">搜索客户</a></li>
<li><a href="welcome.jsp">关于</a></li>
</ul> 

</body>
</html>