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
    <title>Declaration Detail</title>
</head>
<body>

<h3>Họ tên: ${declaration.name}</h3>
<h3>Năm sinh: ${declaration.dateOfBirth}</h3>
<h3>Chứng minh nhân dân: ${declaration.cardId}</h3>
<h3>Thông tin đi lại: ${declaration.travelInformation}</h3>
<h3>Tỉnh thành phố đi qua trong vòng 14 ngày: ${declaration.travelCity}</h3>
<h3>Địa chỉ liên lạc: ${declaration.address}</h3>
<h3>Địa chỉ nơi ở: ${declaration.home}</h3>
<h3>Triệu chứng:
    <c:forEach items="${declaration.sympathy}" var="lang">
        <span>${lang}</span>
    </c:forEach>
</h3>
<h3>Lịch sử phơi nhiễm:
    <c:forEach items="${declaration.exposure}" var="lang">
        <span>${lang}</span>
    </c:forEach>
</h3>
<a href="/declaration/create">Sửa lại</a>
</body>
</html>
