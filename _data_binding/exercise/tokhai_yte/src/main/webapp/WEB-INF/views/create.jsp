<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/24/2021
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Config</title>
</head>
<body>
<h3 style="text-align: center">TỜ KHAI Y TẾ</h3>
<h4 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG.....</h4>
<h4 style="text-align: center;color: red">Khuyến cáo: Khai báo thông tin sai là bi phạmm....</h4>
<form:form modelAttribute="medicalDeclaration" action="/declaration/create" method="post">
    <h3>Họ tên(ghi chữ IN HOA) (*)</h3>
    <form:input path="name"/>
    <h3>Năm sinh(*)</h3>
    <form:input path="dateOfBirth"/>
    <h3>Số hộ chiếu...</h3>
    <form:input path="cardId"/>
    <h3>Thông tin đi lại(*)</h3>
    <form:radiobutton path="travelInformation" value="airplane" label="Tàu bay"/>
    <form:radiobutton path="travelInformation" value="train" label="Tàu thuyền"/>
    <form:radiobutton path="travelInformation" value="car" label="O tô"/>
    <form:radiobutton path="travelInformation" value="other" label="Khác"/>
    <h3>Trong vòng 14 ngày qua,...</h3>
    <form:input path="travelCity"/>
    <h3>Địa chỉ liên lạc</h3>
    <form:input path="address"/>
    <h3>Địa chỉ nơi ở</h3>
    <form:input path="home"/>
    <h3>Điện thoại</h3>
    <form:input path="phoneNumber"/>
    <h3>Email</h3>
    <form:input path="email"/>
    <h3>Trong vòng 14 ngày qua, anh chị có triệu chứng...</h3>
    <form:checkboxes path="sympathy" items="${sympathyList}"/>
    <h3>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, anh chị có </h3>
    <form:checkboxes path="exposure" items="${exposureList}"/>
    <input type="submit" value="Gửi tờ khai">
</form:form>
</body>
</html>
