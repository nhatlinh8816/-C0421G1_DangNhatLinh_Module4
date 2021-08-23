<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/23/2021
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Calculator</h1>
    <form action="/calculator">
        <input type="number" name="firstNum">
        <input type="number" name="secondNum">
        <button type="submit" name="operator" value="add" >Addition</button>
        <button type="submit" name="operator" value="sub" >Subtraction</button>
        <button type="submit" name="operator" value="multi" >Multiplication</button>
        <button type="submit" name="operator" value="div" >Division</button>
    </form>
</body>
</html>
