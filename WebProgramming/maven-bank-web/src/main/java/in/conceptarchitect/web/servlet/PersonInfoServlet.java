package in.conceptarchitect.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.conceptarchitect.peoplemanagement.InfoNotFoundException;
import in.conceptarchitect.peoplemanagement.PeopleManagement;
import in.conceptarchitect.peoplemanagement.Person;

/**
 * Servlet implementation class PersonInfoServlet
 */

@WebServlet("/api/people/*")
public class PersonInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String [] parts=request.getPathInfo().split("/");
				
		Logger logger=Logger.getLogger(PersonInfoServlet.class.getName());
		
		logger.info("path:"+request.getPathInfo());
		
		int x=0;
		for(String part : parts) {
			logger.info(""+(++x)+":"+part);
		}
		
		logger.info("parts.length="+parts.length);
		
		String json= "{}";
		int status=200;
		Gson gson=new Gson();
		int id=0;
		HashMap<String,String> errors=new HashMap<String,String>();
		
		try {
			logger.info("id string "+ parts[0]);
			
			id=Integer.parseInt(parts[1]);
			Person person=PeopleManagement.instance.getPersonById(id);
			
			json=gson.toJson(person);
		} catch(NumberFormatException ex) {
			status=400;
			errors.put("error", "Invalid Id Type. Must be a number");
			errors.put("format", "/api/people/{id}");
			json=gson.toJson(errors);
		} catch(IndexOutOfBoundsException ex) {
			status=400;
			errors.put("error", "Missing Id");
			errors.put("format", "/api/people/{id}");
			json=gson.toJson(errors);
		} catch(InfoNotFoundException ex) {
			status=404;
			errors.put("error", "Missing Id");
			errors.put("missing-id",""+id);
			json=gson.toJson(errors);
		}
			
		response.setStatus(status);
		response.getWriter().println(json);
		
	}

	

}
