<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World Forms</title>
</head>
<body>

Process form using request.getParameter
<form action="/hello/processFormVTwo" method="get">
    <input type="text" placeholder="Enter your name" name="studentName"/>
    <input type="submit">
</form>

Process form using @RequestParam
<form action="/hello/processFormVThree" method="get">
    <input type="text" placeholder="Enter your name" name="studentName"/>
    <input type="submit">
</form>


</body>
</html>
