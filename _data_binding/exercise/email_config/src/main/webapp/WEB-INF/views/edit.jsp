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
    <h2> Settings</h2>
    <form:form modelAttribute="emailConfig" action="/email/edit" method="post">
            <h3> Language:
            <form:select path="languages">
                <form:option value="english" label="English"/>
                <form:option value="vietnamese" label="Vietnamese"/>
                <form:option value="japanese" label="Japanese"/>
                <form:option value="chinese" label="Chinese"/>
            </form:select>
            </h3>
            <h3>Page size: Show
                <form:select path="pageSize">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
                emails per page
            </h3>
            <h3>
                Spams filter:
                <form:checkbox path="spamFilter" value="true" />
                Enable spams filter
            </h3>
            <h3>
                Signature:
                <form:textarea path="signature"/>
            </h3>
        <input type="submit" value="Update">

    </form:form>
</body>
</html>
