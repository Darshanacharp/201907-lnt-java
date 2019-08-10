package in.conceptarchitect.banking.web.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.banking.BankManager;
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
//    	String path="C:\\MyWorks\\Corporate\\201907-lnt-java\\accounts.db";
//    	AccountStore store= BankAccountBinaryStore.load(path);
//    	Bank bank=new Bank("ICICI", 12,store);    	
//    	final ArrayList<BankAccount> accounts=new ArrayList<>();    	
//    	bank.processActiveAccounts(accounts::add);  //add all account to this array
    	
    	List<BankAccount> accounts= BankManager.instance.getAllAccounts();
    	
    	//now I know all the accounts    	
    	//Step 2. Request Some JSP To Generate The Page    	
    	//Step 2.1 Before you forward request to jsp, add accounts to the request
    	request.setAttribute("accounts", accounts);     	
    	//Step 2.2 Forward request, response and accounts to JSP page
    	request.getRequestDispatcher("/views/accounts.jsp")  //send the request to acccounts.jsp
    		.forward(request, response); //forward the request and response
    	
    	
    	
	}

}
