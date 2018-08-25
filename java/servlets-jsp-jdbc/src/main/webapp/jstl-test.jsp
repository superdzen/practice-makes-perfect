<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="currentDate" value="<%= new java.util.Date()%>"/>

Time on the server is ${currentDate}

</body>
</html>
