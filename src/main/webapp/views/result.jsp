<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang kết quả</title>
</head>
<body>
<c:if test="${not empty user}">
    <h2>Thông tin người dùng:</h2>
    <p>Tên: ${user.name}</p>
    <p>Tuổi: ${user.age}</p>
    <p>Địa chỉ: ${user.address}</p>
</c:if>

<c:if test="${not empty product}">
    <h2>Thông tin sản phẩm:</h2>
    <p>Tên sản phẩm: ${product.name}</p>
    <p>Giá: ${product.price}</p>
    <p>Mô tả: ${product.description}</p>
</c:if>

<c:if test="${not empty url}">
    <h2>Ảnh đại diện đã upload:</h2>
    <img src="${url}" alt="Avatar" width="200" height="200"/>
</c:if>

<c:if test="${not empty urlB6}">
    <p>Mô tả: ${description}</p>
    <img src="${urlB6}" alt="file" width="300" height="300"/>
</c:if>
</body>
</html>
