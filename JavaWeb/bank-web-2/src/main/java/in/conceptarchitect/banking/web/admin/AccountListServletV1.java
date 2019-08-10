package in.conceptarchitect.banking.web.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.finance.BankAccount;
import in.conceptarchitect.finance.store.BankAccountBinaryStore;

/**
 * Servlet implementation class AccountListServlet
 */
@WebServlet("/admin/accounts/v1")   
public class AccountListServletV1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	//Step 1. Get the Data 
    	String path="C:\\MyWorks\\Corporate\\201907-lnt-java\\accounts.db";
    	AccountStore store= BankAccountBinaryStore.load(path);
    	Bank bank=new Bank("ICICI", 12,store);
    	
    	final ArrayList<BankAccount> accounts=new ArrayList<>();
    	
    	bank.processActiveAccounts(accounts::add);  //add all account to this array
    	
    	//now I know all the accounts
    	
		//Step 2. Generate The Page
    	PrintWriter writer=response.getWriter();
    	
    	writer.println("<html><head><title>List of Accounts</title>"
    			+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n" + 
    			"<link rel=\"stylesheet\" href=\"styles/app.css\" >"
    			+ "</head>");
    	
    	writer.println("<body class='container'><h1 class='jumbotron'>Account List</h1>");
    	
    	writer.println("<ul class='list-group' >");
    	for(BankAccount account: accounts)
    		writer.printf("<li class='list-group-item list-group-item-action' >%s %d - %s </li>\n", 
    				account.getAccountType(), 
    				account.getAccountNumber(),
    				account.getName() );
    	
    	writer.println("</ul>");
    	
    	writer.println("</body></html>");
    	
    	
	}

}
