package in.conceptarchitect.web.api;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.conceptarchitect.contacts.Contact;
import in.conceptarchitect.contacts.ContactBook;

/**
 * Servlet implementation class ContactByIdServlet
 */
public class ContactByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HashMap<String,String> error=new HashMap<>();
    	response.setContentType("application/json");
    	Contact contact=null;
    	int status=200;
    	try {
    		String [] parts=request.getPathInfo().split("/");
    		String email=parts[1];
    		contact=ContactBook.getInstance().getContact(email);
    		System.out.println(contact.getName());
    		
    		
    	}catch(NullPointerException ex) {
    		//no contact with given id
    		status=404;
    		error.put("error", "not found");
    	}catch(IndexOutOfBoundsException ex) {
    		status=400;
    		error.put("error", "invalid url");
    		error.put("suggestion", "use url format /api/contact/email");
    	}
    	
    	Gson gson=new Gson();
    	String json="";
    	if(status==200) {
    		json=gson.toJson(contact);
    	}else {
    		json=gson.toJson(error);
    	}
    	
    	response.setStatus(status);
    	response.getWriter().println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
