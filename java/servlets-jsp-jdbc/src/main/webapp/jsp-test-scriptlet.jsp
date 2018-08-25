<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<h3>Scriptlet "for loop" example</h3>
<%
    for (int i = 0; i < 5; i++) {
        out.println("<br/> I love to code: " + i);
    }
%>
</body>
</html>
