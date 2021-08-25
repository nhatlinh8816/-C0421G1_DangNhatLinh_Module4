<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/24/2021
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Config Detail</title>
</head>
<body>
<h2>Settings</h2>
<h3>Language: ${config.languages}</h3>
<h3>Page Size: ${config.pageSize}</h3>
<c:choose>
    <c:when test="${config.spamFilter==true}">
        <h3>Enable spam filter</h3>
    </c:when>
    <c:when test="${config.spamFilter==false}">
        <h3>Disable spam filter</h3>
    </c:when>
</c:choose>
<h3>Signature: ${config.signature}</h3>
<a href="/email/edit">Edit Settings</a>
</body>
</html>
