<%--
  Created by IntelliJ IDEA.
  User: khai trinh
  Date: 05/02/2021
  Time: 5:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="${product.getName()}"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><input type="text" name="description" value="${product.getDescription()}"></td>
        </tr>

    </table>
    <input type="submit" value="submit">
</form>
</body>
</html>
