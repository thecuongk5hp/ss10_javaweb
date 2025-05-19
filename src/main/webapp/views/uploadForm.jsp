<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Avatar</title>
</head>
<body>
<h2>Upload Ảnh Đại Diện</h2>

<form:form modelAttribute="userProfile" method="post" action="upload" enctype="multipart/form-data">
    <label for="username">Tên người dùng:</label>
    <form:input path="username" /><br/><br/>

    <label for="avatar">Chọn ảnh đại diện:</label>
    <form:input path="avatar" type="file"/><br/><br/>

    <input type="submit" value="Upload"/>
</form:form>

</body>
</html>
