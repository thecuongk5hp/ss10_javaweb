<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhập thông tin cá nhân</title>
</head>
<body>
<h1>Nhập thông tin cá nhân</h1>
<form:form action="/profile" method="post" modelAttribute="user">
    Tên: <form:input path="name" />
    Tuổi: <form:input path="age" type="number" />
    Địa chỉ: <form:input path="address" />
    <input type="submit" value="Gửi thông tin"/>
</form:form>
</body>
</html>
