<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 05/02/2021
  Time: 3:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Product</title>
  </head>
  <body>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Description</th>
    </tr>
    <c:forEach items="${danhSach}" var="product">
      <tr>
        <td>${product.getId()}</td>
        <td>${product.getName()}</td>
        <td>${product.getDescription()}</td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
