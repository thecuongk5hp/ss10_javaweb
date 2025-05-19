<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo tài khoản</title>
</head>
<body>
<h1>Tạo tài khoản</h1>
<form:form action="addAccount" method="post" modelAttribute="account">
    Tên đăng nhập: <form:input path="username" />
    Mật khẩu: <form:password path="password" />
    Email: <form:input path="email" />
    <input type="submit" value="Tạo tài khoản"/>
</form:form>

<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>
</body>
</html>
