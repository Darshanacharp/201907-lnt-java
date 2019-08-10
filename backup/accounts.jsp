<%@page import="in.conceptarchitect.finance.Action"%>
<%@page import="in.conceptarchitect.finance.BankAccount"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.conceptarchitect.finance.AccountStore"%>
<%@page import="in.conceptarchitect.finance.store.BankAccountBinaryStore"%>
<%@page import="in.conceptarchitect.finance.Bank"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="../styles/styles.css" >

<style>
.accounts{
	width:80%;
	padding:10%;
}

.accounts li{
	cursor:pointer;
}


</style>

<title>Accounts List</title>
</head>
<body>

<%
	String path="C:\\MyWorks\\Corporate\\201907-lnt-java\\accounts.db";
	AccountStore store=BankAccountBinaryStore.load(path);
	Bank bank=new Bank("ICICI",12,store);
	final ArrayList<BankAccount> accounts=new ArrayList<>();
	
	Action<BankAccount> addToList=new Action<BankAccount>(){
		public void act(BankAccount account){
			accounts.add(account);
		}
	};
	
	bank.processActiveAccounts(addToList);
	

%>

<div class='accounts' >


	<h1>Accounts List</h1>

	<ul class='list-group hover' >
	<% for(BankAccount account: accounts){ %>
		
		<li class='list-group-item list-group-item-action'><%= account.getAccountType()+" "+account.getAccountNumber()+" "+account.getName() %></li>
		
	<%} %>
	</ul>
</div>

</body>
</html>