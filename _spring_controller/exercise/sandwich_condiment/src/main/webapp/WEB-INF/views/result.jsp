<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/23/2021
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>List of condiment:</h2>
    <c:forEach items="${lists}" var="lists">
        ${lists}
    </c:forEach>
</body>
</html>
