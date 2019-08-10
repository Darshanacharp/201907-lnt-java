<%@page import="java.util.List"%>
<%@page import="in.conceptarchitect.finance.Action"%>
<%@page import="in.conceptarchitect.finance.BankAccount"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.conceptarchitect.finance.Bank"%>
<%@page import="in.conceptarchitect.finance.store.BankAccountBinaryStore"%>
<%@page import="in.conceptarchitect.finance.AccountStore"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="styles/app.css" >
		<title>List of Bank Accounts</title>
	</head>
	
	<body class='container' >
		<div class='header jumbotron'>
			<h1>Admin - Account List</h1>
		</div>
		
		
		
		
		
		<div>
			<ul class='list-group'>
			
				<% 
					List<BankAccount> accounts= (List<BankAccount>) request.getAttribute("accounts");
					for(BankAccount account : accounts){ %>
					<li class='list-group-item list-group-item-action'>
						<%= account.getAccountType() %>
						<%= account.getAccountNumber() %>
						<%= account.getName() %>
					</li>
				<%} %>
				
				
			</ul>
		</div>
	</body>
</html>