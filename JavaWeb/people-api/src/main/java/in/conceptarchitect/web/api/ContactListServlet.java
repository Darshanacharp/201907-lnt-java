package in.conceptarchitect.web.api;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.conceptarchitect.contacts.Contact;
import in.conceptarchitect.contacts.ContactBook;

public class ContactListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Step 1. Get the data
		Collection<Contact> contacts= ContactBook.getInstance().getAllContacts();
		
		//Step 2. Return the list as a JSON object
		response.setContentType("application/json");
		Gson gson=new Gson();
		
		String jsonData= gson.toJson(contacts);
		
		response.getWriter().println(jsonData);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
