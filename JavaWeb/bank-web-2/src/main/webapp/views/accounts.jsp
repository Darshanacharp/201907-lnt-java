<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles/app.css">


<title>List of Bank Accounts</title>

</head>

<body class='container'>
	<div class='header jumbotron'>
		<h1>Admin - Account List</h1>
	</div>
	
	


	<div>
		<a href="/bank-web/admin/open-account" class='btn btn-primary' >Open Account</a>
		<br/>
		<ul class='list-group'>

			<c:forEach var="account" items="${accounts}">
				<li class='list-group-item list-group-item-action ${account.status.toString().equals("CLOSED")?' label label-danger':'' }   '>
					${account.accountType} ${account.accountNumber} - ${account.name } [${account.status }]
					
					<c:if test='${account.status.toString().equals("ACTIVE")}'>
						<a href="/bank-web/admin/close-account/${account.accountNumber }" class='btn btn-sm btn-danger' >Close</a>
					</c:if>
						
				</li>
			</c:forEach>

		</ul>
	</div>
</body>
</html>