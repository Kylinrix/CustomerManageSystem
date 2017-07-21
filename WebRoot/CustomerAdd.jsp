<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/pageCss.css"/>

<title>Insert title here</title>
</head>
<body>
<div class="basic-grey">
<form action="<c:url value='/CustomerServlet'/>" method="post" >
<h1>客户添加
<span> 请填写下列内容 </span>

</h1>
<label>
<span>姓名 :</span>
<input id="name" type="text" name="name" placeholder="请输入客户姓名"    required="required"/>
</label>

<label>
<span>性别:</span>
<select name="sex">
<option value="male">男</option>
<option value="female">女</option>
</select>
</label>

<label>
<span>电话 :</span>
<input id="number" type="text" name="phone" placeholder="请输入电话号码"  required="required" />
</label>

<label>
<span>邮箱 :</span>
<input id="email" type="email" name="email" placeholder="请输入邮箱地址"  required="required"/>
</label>

<label>
<span>描述详情 :</span>
<textarea id="message" name="description" placeholder="请输入关于此客户的描述"></textarea>
</label>



<input type="hidden" name="submitType" value="addCustomer"></input>

<label>
<span>&nbsp;</span>
<button type="submit" class="button"  value="Send" >提交</button>
</label>

</form>
</div>
</body>
</html>