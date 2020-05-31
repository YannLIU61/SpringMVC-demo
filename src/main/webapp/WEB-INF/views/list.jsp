<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>Employee List Page</h1>
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Gender</td>
				<td>Departement</td>
				<td>Delete</td>
				<td>Edit</td>
			<tr>
		</thead>


		<c:forEach items="${requestScope.employeelist}" var="employee">
			<tr>
				<td>
					<c:out value="${employee.id }"></c:out>
				</td>

				<td>
					<c:out value="${employee.lastName }"></c:out>
				</td>
				<td>
					<c:out value="${employee.gender }"></c:out>
				</td>
				<td>
					<c:out value="${employee.department.deptName }"></c:out>
				</td>
				<td>
					<form action="delete/${employee.id}" method="post">
						<input type="submit" value="Delete">
					</form>
				</td>
				<td>
					<form action="edit/${employee.id}" method="get">
						<input type="submit" value="edit">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="input">Add new Employee</a>
</body>
</html>