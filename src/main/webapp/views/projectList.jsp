<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Dự án</title>
</head>
<body>
<h2>Danh sách Dự án</h2>

<table border="1">
    <tr>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="project" items="${projects}">
        <tr>
            <td>${project.name}</td>
            <td>${project.description}</td>
            <td>
                <a href="editProject?name=${project.name}">Sửa</a> |
                <a href="deleteProject?name=${project.name}" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="bai7">Tạo dự án mới</a>
</body>
</html>
