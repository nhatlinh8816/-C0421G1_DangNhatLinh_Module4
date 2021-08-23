<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/23/2021
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>Sandwich Condiment</h2>
<form action="/condiment">
    <input type="radio" name = "lettuce" value="Lettuce">Lettuce
    <input type="radio" name = "tomato" value="Tomato">Tomato
    <input type="radio" name = "mustard" value="Mustard">Mustard
    <input type="radio" name = "sprouts" value="Sprouts">Sprouts
    <button type="submit">Save</button>
</form>
</body>
</html>
