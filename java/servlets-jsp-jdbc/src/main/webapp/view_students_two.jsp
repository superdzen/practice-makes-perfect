<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC Demo two</title>
</head>
<body>

<h2>Student Table Demo</h2>
<hr>
<br/>

<table border="1">
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
    </tr>

    <c:forEach var="tempStudent" items="${student_list}">
    <tr>
        <td>${tempStudent.firstName}</td>
        <td>${tempStudent.lastName}</td>
        <td>${tempStudent.email}</td>
    </tr>
    </c:forEach>

</table>


</body>
</html>
