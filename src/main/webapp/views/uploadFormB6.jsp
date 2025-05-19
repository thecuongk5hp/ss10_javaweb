<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<h2>Upload File lên Cloud</h2>

<form:form action="${pageContext.request.contextPath}/uploadB6" method="post"
           modelAttribute="uploadFile" enctype="multipart/form-data">
    <table>
        <tr>
            <td>File:</td>
            <td><form:input path="file" type="file"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Upload"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
