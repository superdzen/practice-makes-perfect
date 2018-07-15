<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.superdzen.jsp.tagdemo.Student" %>
<%
    List<Student> data = new ArrayList<>();

    data.add(new Student("John", "Doe", false));
    data.add(new Student("Denis", "Kush", true));
    data.add(new Student("Pavel", "Ivanov", false));

    pageContext.setAttribute("myStudents", data);
%>

<html>
<head>
    <title>Student List</title>
</head>
<body>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gold Customer</th>
    </tr>
    <c:forEach var="tempStudent" items="${myStudents}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>

            <td><c:if test="${tempStudent.goldCustomer}">
                Special Discount
            </c:if>
                <c:if test="${not tempStudent.goldCustomer}">
                    -
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
