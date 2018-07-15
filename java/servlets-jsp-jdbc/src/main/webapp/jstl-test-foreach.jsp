<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String[] cities = {"Novosibirsk", "Moscow", "New York"};
    pageContext.setAttribute("myCities", cities);
%>

<c:forEach var="tempCity" items="${myCities}">
    ${tempCity} <br/>
</c:forEach>


</body>
</html>
