<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <c:forEach items="${map}" var="m">
      ${m.key}-${m.value}<br>
   </c:forEach>
</body>
</html>