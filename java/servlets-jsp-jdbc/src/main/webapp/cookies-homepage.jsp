<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>Training Portal</h3>
<%
    // if there are no cookies, default faLang = "Java"
    String favLang = "Java";

    // get the cookies from the browser request
    Cookie[] theCookies = request.getCookies();

    // get the certain cookie
    if (theCookies != null) {
        for (Cookie tempCookie : theCookies) {
            if ("myApp.favouriteLanguage".equals(tempCookie.getName())) {
                favLang = URLDecoder.decode(tempCookie.getValue(), "UTF-8");
                break;
            }
        }
    }
%>
<h4>New Books for <%= favLang%>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>
<br/>
<h4>Latest News Reports for <%= favLang%>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>
<br/>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>
