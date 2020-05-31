<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="HELLO"></c:out>
	<h1>Success Page</h1>
	<fmt:message key="i18n.name"></fmt:message>
	<br>
	<fmt:message key="i18n.password"></fmt:message>
	<br>
	<p>Bonjour ${requestScope.user}</p>
	<br>
	<p>Words: ${requestScope.names }</p>
</body>
</html>