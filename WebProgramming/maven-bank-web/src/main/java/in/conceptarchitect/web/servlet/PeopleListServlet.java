package in.conceptarchitect.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.conceptarchitect.peoplemanagement.PeopleManagement;
import in.conceptarchitect.peoplemanagement.Person;

@WebServlet("/api/people")
public class PeopleListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection<Person> people=PeopleManagement.instance.getPeople();
		Gson gson=new Gson();
		String peopleJson=gson.toJson(people);
		resp.setContentType("application/json");
		resp.getWriter().print(peopleJson);
		
	}
	

}
