<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
The student is confirmed: ${param.firstName} ${param.lastName}
<br/>
Student's favourite languages:
<br/>
<%
    String[] langs = request.getParameterValues("favouriteLanguage");
    if (langs != null && langs.length != 0) {
        for (String lang : langs) {
            out.print("<li>" + lang + "</li>");
        }
    }
%>
</body>
</html>
