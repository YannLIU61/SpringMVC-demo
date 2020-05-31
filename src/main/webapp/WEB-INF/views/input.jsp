<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
	<!-- 使用 form标签: 可以快速的开发出表单页面, 而且更方便进行表单值回显 -->
	<form:form action="add" method="post" modelAttribute="employee">
		<!-- path属性对应name属性值 -->
	LastName: <form:input path="lastName" />
		<br>
	Email: <form:input path="email" />
		<br>
		<%
			Map<String, String> genders = new HashMap();
		genders.put("male", "male");
		genders.put("female", "female");

		request.setAttribute("genders", genders);
		%>
	Gender: <form:radiobuttons path="gender" items="${genders}" />
		<br>
	Department:<form:select path="department.id" items="${deptlist }"
			itemLabel="deptName" itemValue="id"
		></form:select>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>