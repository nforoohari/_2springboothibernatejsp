<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="Add Product" onclick="window.location.href='formForAddProduct'">
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Update/Delete</th>
    </tr>
    <c:forEach var="product" items="${products}">

        <c:url var="updateLink" value="formForUpdateProduct">
            <c:param name="ProductId" value="${product.id}"/>
        </c:url>
        <c:url var="deleteLink" value="deleteProduct">
            <c:param name="ProductId" value="${product.id}"/>
        </c:url>

        <tr>
            <th>${product.name}</th>
            <th>${product.description}</th>
            <th>${product.price}</th>
            <th>
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if(!confirm('Are you sure you want to delete?')) return false">Delete</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
