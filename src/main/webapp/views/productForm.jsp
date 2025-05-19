<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h1>Thêm sản phẩm</h1>
<form:form action="addProduct" method="post" modelAttribute="product">
    Tên sản phẩm: <form:input path="name" />
    <form:errors path="name" /><br/>

    Giá: <form:input path="price" />
    <form:errors path="price" /><br/>

    Mô tả: <form:input path="description" />
    <form:errors path="description" /><br/>

    <input type="submit" value="Thêm sản phẩm"/>
</form:form>
</body>
</html>
