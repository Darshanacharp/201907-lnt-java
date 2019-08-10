package in.conceptarchitect.banking.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer= resp.getWriter();
		
		Date date=new Date();
		
		writer.println("<html><head><title>Bank's Home Page</title></head>");
		writer.println("<body>");
		writer.println("<h1>Welcome to Bank's Home Page</h1>");
		writer.printf("<p>Today is %s</p>\n",date);
		writer.println("</body></html>");
	}

}
