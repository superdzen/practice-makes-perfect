<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="data" value="love to code"/>
Length of the string <b>${data}</b>: ${fn:length(data)}
<br/><br/>
Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}
<br/><br/>
Does the string <b>${data}</b> starts with <b>love</b>?: ${fn:startsWith(data, "love")}
<br/><br/>
<c:set var="spitted" value="${fn:split(data, ' ')}"/>
Splitting string <b>${data}</b> to array: <c:forEach items="${spitted}" var="myItem">
    <br/>${myItem}
</c:forEach>
<br/><br/>
Joined string of previous array: ${fn:join(spitted,',')}
</body>
</html>
