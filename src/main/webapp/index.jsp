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
    <style>
      h1 {
        color: red;
      }
    </style>
  </head>
  <body>
  <h1>CHÚC MỪNG NĂM MỚI</h1>
  <h1>Vạn sự như ý , tâm tưởng sự thành, mã đáo thành công</h1>
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
