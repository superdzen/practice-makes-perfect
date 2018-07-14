<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h3>JSP Built-in Objects</h3>

Request user agent: <%= request.getHeader("User-Agent")%>

<br/>
<br/>

Request language: <%= request.getLocale()%>

</body>
</html>
