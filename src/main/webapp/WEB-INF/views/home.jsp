<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Webkochbuch</title>
</head>
<body>
<h1>
	Webkochbuch  
</h1>

<P>Hier entsteht das Webkochbuch. Es ist ${serverTime}. Das ist ein Keks:</P>
<img src="<c:url value="resources/images/test_keks.jpg" />" alt="Beispielbild" />
</body>
</html>
