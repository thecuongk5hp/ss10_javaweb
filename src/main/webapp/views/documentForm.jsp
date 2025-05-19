<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Document</title>
</head>
<body>
<h2>Upload Document</h2>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<form:form method="post" modelAttribute="document" action="${pageContext.request.contextPath}/uploadB5" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Title:</td>
            <td><form:input path="title" required="required"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:textarea path="description" rows="4" cols="30" required="required"/></td>
        </tr>
        <tr>
            <td>File (PDF):</td>
            <td><input type="file" name="file" accept="application/pdf" required/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Upload"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
