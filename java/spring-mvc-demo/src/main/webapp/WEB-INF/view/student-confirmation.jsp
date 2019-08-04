<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Confirmation Page</title>
</head>
<body>

The student is confirmed:
First Name = ${student.firstName} <br/>
Last Name = ${student.lastName} <br/>
Country = ${student.country} <br/>
Favourite Language = ${student.favouriteLanguage} <br/>
Experience with operating systems =
<ul>
    <c:forEach var="tmp" items="${student.operatingSystems}">
        <li>${tmp}</li>
    </c:forEach>
</ul>
</body>
</html>
