
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Session Variable</title>
</head>
<body>
    <h1>Session Variable</h1>
    <p>Username: <%= session.getAttribute("role") %></p>
</body>
</html>
    