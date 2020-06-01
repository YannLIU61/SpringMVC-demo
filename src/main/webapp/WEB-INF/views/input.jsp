<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>

	<form action="testConversionService" method="post">
		Employee:
		<input type="text" name="employee">
		<input type="submit" value="Submit">
	</form>
	<br>
	<!-- 使用 form标签: 可以快速的开发出表单页面, 而且更方便进行表单值回显 -->
	<form:form action="add" method="post" modelAttribute="employee">
		<!-- path属性对应name属性值 -->
		<!-- 数据类型转化conversionservice 输入字符串后台解析 -->
		<!-- 数据格式化1995/11/27-> Date -->
		<!-- 数据检验 JSR 303:添加jar(hibernate validator) 添加注解@NotNull  @Max @Size...@Email(配置LocalValidatorFactoryBean: 在mvc配置文件中添加<mvc:annotation-driven></mvc:annotation-driven>),
		在目标方法上添加@Valid注解 -->
	LastName: <form:input path="lastName" />
		<form:errors path="lastName"></form:errors>
		<br>
	Email: <form:input path="email" />
		<form:errors path="email"></form:errors>
		<br>
		<%
			Map<String, String> genders = new HashMap();
		genders.put("male", "male");
		genders.put("female", "female");

		request.setAttribute("genders", genders);
		%>
	Gender: <form:radiobuttons path="gender" items="${genders}" />
		<br>
		<!-- 可以在handler对应方法中使用 initbinder方法, bindingresul 显示错误信息 -->
	Department:<form:select path="department.id" items="${deptlist }"
			itemLabel="deptName" itemValue="id"
		></form:select>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>