<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>
        <c:choose>
            <c:when test="${empty project.name}">
                Tạo dự án
            </c:when>
            <c:otherwise>
                Cập nhật dự án
            </c:otherwise>
        </c:choose>
    </title>
</head>
<body>
<h2>
    <c:choose>
        <c:when test="${empty project.name}">
            Tạo mới dự án
        </c:when>
        <c:otherwise>
            Cập nhật dự án
        </c:otherwise>
    </c:choose>
</h2>

<form:form method="post" action="${empty project.name ? 'createProject' : 'updateProject'}"
           modelAttribute="project" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Tên:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td><form:textarea path="description"/></td>
        </tr>
        <tr>
            <td>Tài liệu:</td>
            <td>
                <input type="file" name="files" multiple/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:choose>
                    <c:when test="${empty project.name}">
                        <input type="submit" value="Tạo"/>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Cập nhật"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</form:form>
<br>
<a href="listProjects">Xem danh sách dự án</a>
</body>
</html>
