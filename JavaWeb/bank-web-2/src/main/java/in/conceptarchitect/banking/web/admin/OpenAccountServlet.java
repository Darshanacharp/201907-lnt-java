package in.conceptarchitect.banking.web.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.banking.BankManager;
import in.conceptarchitect.finance.AccountStore;
import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.finance.BankingException;
import in.conceptarchitect.finance.store.BankAccountBinaryStore;

/**
 * Servlet implementation class OpenAccountServlet
 */
@WebServlet("/admin/open-account")
public class OpenAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String accountTypes[]= {"Savings Accounts", "Current Account", "Overdraft Account" };
		
//		request.setAttribute("accountTypes",BankManager.instance.getAccountTypes());
//		request.setAttribute("errors", new HashMap<String,String>());
		
		setAttributres(request, new HashMap<String,String>(), "Savings Account", "",0,"" );
		request
			.getRequestDispatcher("/views/open-account.jsp")
			.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HashMap<String, String> errors=new HashMap<>();
		String type="";
		String name="";
		String password="";
		double balance=0;
		try {
			
			
			type=request.getParameter("accountType");
			name=request.getParameter("name");
			password=request.getParameter("password");
			balance=Double
					.parseDouble(request.getParameter("amount"));
			
			
			if(balance<=0)
				errors.put("amount", "Amount must be postivie");
			
			String path="C:\\MyWorks\\Corporate\\201907-lnt-java\\accounts.db";
			
			
			if(name.length()<3)
				errors.put("name", "Name should be at least 3 char");
			
			if(password.length()<6)
				errors.put("password","Password Should be at least 6 char");
			
			
//			AccountStore store=BankAccountBinaryStore.load(path);
//			Bank bank=new Bank("ICICI", 12, store);
//			int accountNumber=bank.openAccount(type, name, password, balance);
			
			//account is created. whats next?
			//response.getWriter().println("Account Created with account Number :"+accountNumber);
		
		
		} catch(NumberFormatException ex) {
			
			errors.put("amount","Amount Must be a Number");
		} catch(BankingException ex) {
			errors.put("accountType", ex.getMessage());
		}
		catch(Exception ex) {
			errors.put("*", ex.getMessage());
		}
		
		if(errors.size()==0) {//good no error
			BankManager
			.instance
			.getBank()
			.openAccount(type, name, password, balance);
			response.sendRedirect("/bank-web/admin/accounts");
		}
		else {
			
			
			setAttributres(request, errors, type, name, balance,password);
			
			
			response.setStatus(400); //bad request
			request.getRequestDispatcher("/views/open-account.jsp").forward(request, response);
			
		}
		
		
		
	}


	private void setAttributres(HttpServletRequest request, HashMap<String, String> errors, String type, String name,
			double balance, String password) {
		request.setAttribute("accountTypes",BankManager.instance.getAccountTypes());
		request.setAttribute("errors", errors);
		request.setAttribute("name", name);
		request.setAttribute("accountType", type);
		request.setAttribute("amount", balance);
		request.setAttribute("password", password);
	}

}
