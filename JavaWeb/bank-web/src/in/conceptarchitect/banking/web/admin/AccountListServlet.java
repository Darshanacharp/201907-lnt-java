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
@WebServlet("/admin/accounts")   
public class AccountListServlet extends HttpServlet {
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
    	
    	writer.println("<html><head><title>List of Accounts</title></head>");
    	
    	writer.println("<body><h1>Account List</h1>");
    	
    	writer.println("<ul>");
    	for(BankAccount account: accounts)
    		writer.printf("<li>%s %d - %s </li>\n", 
    				account.getAccountType(), 
    				account.getAccountNumber(),
    				account.getName() );
    	
    	writer.println("</ul>");
    	
    	writer.println("</body></html>");
    	
    	
	}

}
