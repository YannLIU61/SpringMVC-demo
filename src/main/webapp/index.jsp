<!DOCTYPE html>
<html>
<body>
	<c:out value="HELLO"></c:out>
	<br>
	<a href="employeeManager/list">List Employee</a>
	<br>
	<fmt:message key="i18n.name"></fmt:message>
	<br>
	<fmt:message key="i18n.password"></fmt:message>
	<br>
	<a href="springmvc/testRequestParam?username=LIU">Test request
		param</a>
	<br>
	<a href="springmvc/testParam?username=LIU&age=29">Test param</a>
	<br>
	<a href="helloworld">Hello World!</a>
	<br>
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="Test method">
	</form>
	<br>
	<a href="springmvc/testRest/1">Test Rest GET</a>
	<br>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="Test Rest POST">
	</form>
	<br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="Test Rest PUT">
	</form>
	<br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" value="DELETE" name="_method">
		<input type="submit" value="Test Rest delete">
	</form>

	<br>
	<form action="springmvc/testPojo" method="post">
		Name:
		<input type="text" name="name">
		<br>
		Mail:
		<input type="email" name="mail">
		<br>
		Password:
		<input type="password" name="pwd">
		<br>
		Age:
		<input type="text" name="age">
		<br>
		<!-- Province:
		<input type="text" name="addresse.province">
		<br>
		City:
		<input type="text" name="addresse.city">
		<br> -->
		<input type="submit" value="Submit">
		<br>
	</form>
	<a href="springmvc/testServletApi">Test servlet Api</a>
	<br>
	<a href="springmvc/testModelAndView">Test ModelAndView</a>
	<br>
	<a href="springmvc/testMap">Test Map</a>
	<br>
	<form action="springmvc/testModelAttribute" method="post">
		<input type="hidden" name="id" value=1>
		Name:
		<input type="text" name="name">
		<br>
		Mail:
		<input type="email" name="mail">
		<br>
		Age:
		<input type="text" name="age">
		<br>

		<input type="submit" value="Modify">
		<br>
	</form>
	<br>
	<a href="springmvc/testView">Test View</a>
</body>
</html>
