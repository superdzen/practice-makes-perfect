<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h3>Method declaration test</h3>
<%!
    String makeItLower(String data) {
        return data.toLowerCase();
    }
%>
<br/>
Lower case of "Hello World": <%= makeItLower("Hello World!")%>

</body>
</html>
