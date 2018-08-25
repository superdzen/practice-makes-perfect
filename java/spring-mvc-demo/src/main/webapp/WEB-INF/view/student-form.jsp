<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student" method="get">
    First Name: <form:input path="firstName"/>
    <br/>
    Last Name: <form:input path="lastName"/>
    <br/>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
