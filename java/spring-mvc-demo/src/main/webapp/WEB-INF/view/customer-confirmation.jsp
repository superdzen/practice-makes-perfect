<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Confirmation Page</title>
</head>
<body>

The Customer is confirmed:<br/>
First Name = ${customer.firstName} <br/>
Last Name = ${customer.lastName} <br/>
Free passes = ${customer.freePasses}<br/>
Postal code = ${customer.postalCode}<br/>
Course code = ${customer.courseCode}<br/>
</body>
</html>
