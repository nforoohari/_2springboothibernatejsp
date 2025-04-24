<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="saveProduct" modelAttribute="product" method="post">
    <form:hidden path="id"/>
    <table>
        <tbody>
        <tr>
            <td><label>Name:</label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><label>Description:</label></td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td><label>Price:</label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save Product"></td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
