<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script type="text/javascript">
	$(f unction(){
	$("#testJson").click(function(){
		var url = this.href;
		var args = {};
		$.post(url, agrs,function(data){
			for(var i=0; i<data.length;i++){
				var id = data[i].id;
				var lastName = data[i].lastName;
				alert(id+" : "+lastName);
				}			
			})
	return false;
		});
		})
</script>
</head>
<body>
	<c:out value="HELLO"></c:out>
	<br>
	<!-- 文件下载 -->
	<a href="springmvc/testResponseEntity"> Test ResponseEntity</a>
	<br>
	<!-- Test HttpMessageConverter  实现文件上传 -->
	<form action="springmvc/testMessageConverter" method="post">
	File:<input type="file" name="file">
	Desc:<input type="text" name="desc">
	<input type="submit" value="Upload">
	</form>
	<br>
	<!-- 1.添加jackson core/databind/annotation jar 2.目标方法返回json对应的对象或集合 3.@ResponseBody注解 原理:HttpMessageConverter<T>-->
	<a href="employeeManager/testJson" id="testJson"> Test JSON</a>
	<br>
	<a href="employeeManager/list">List Employee</a>
	<br>
	<fmt:message key="name"></fmt:message>
	<br>
	<fmt:message key="password"></fmt:message>
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
