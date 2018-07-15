<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>

<%
    // read form data
    String favLang = request.getParameter("favouriteLanguage");

    // encode cookie data
    favLang = URLEncoder.encode(favLang, "UTF-8");

    // create new Cookie object
    Cookie newCookie = new Cookie("myApp.favouriteLanguage", favLang);

    // set the life span in seconds
    newCookie.setMaxAge(60 * 60 * 24 * 365);

    // send cookie to browser
    response.addCookie(newCookie);

%>

<body>
Thanks! We set your favourite language to: ${param.favouriteLanguage}
<br/><br/>

<a href="cookies-homepage.jsp">Return to homepage.</a>

</body>
</html>
