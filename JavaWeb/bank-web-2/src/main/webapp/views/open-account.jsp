<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="../styles/styles.css" >
<title>Open An Account</title>
</head>
<body>
<h1>Open An Account</h1>

<c:if test="${errors.size()>0 }">
	<ul>
	<c:forEach var='key' items="${errors.keySet() }"   > 
		<li class='label label-danger' ><strong>${key } :</strong> ${errors.get(key) } </li>
	 </c:forEach>
	 </ul>
</c:if>

<form  method="post"  class="form-group" >
	
	<label for="accountType">Account Type</label>
	<select name="accountType" class="form-control" >
		<c:forEach var='type' items="${accountTypes }">
		
			<c:if test='${type.equals(accountType) }' >
				<option selected >${type}</option>				
			</c:if>
			
			<c:if test='${!type.equals(accountType) }' >
				<option  >${type}</option>				
			</c:if>
			
		</c:forEach>		
	</select>
	
	<label for="name">Name</label>
	<input type="text" name="name" class="form-control"  value='${name }'/>
	
	<label for="accountNumber">Password</label>
	<input type="password" name="password" class="form-control" value='${password }'/>
	
	<label for="accountNumber">Initial Deposit</label>
	<input type="text" name="amount" class="form-control"  value='${amount }' />

	<br/>
	<input type="submit" value="Open Account" class="form-control"/>
	

</form>

</body>
</html>