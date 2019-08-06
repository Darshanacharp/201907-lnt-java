package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Connection con= DriverManager
				.getConnection("jdbc:mysql://localhost:3306/banking","root","training");
				
		
		System.out.println("Connection Successful. Connected to "+ con.getClass());
		
		
		
		Statement statement= con.createStatement();
		
		createAccount(statement);		
		printAccountList(statement);
		
		
		
		con.close();
		
	}

	private static void createAccount(Statement statement) throws SQLException {
		// TODO Auto-generated method stub
		Input kb=new Input();
		
		String type=kb.readString("type?");
		if(type==null || type.equals(""))
			return ;
		
		String name=kb.readString("name?");
		String password=kb.readString("password?");
		double balance=kb.readDouble("amount?");
		
		int status=0; //ACTIVE
		
		String qry=String.format(
				"insert into bankaccounts(name,password,balance,type,status)" + 
				"values('%s','%s',%f,'%s',%d);",
				name,password,balance,type,status
				);
		
		statement.executeUpdate(qry);
		System.out.println("Record Added Successfully");
		
		
	}

	private static void printAccountList(Statement statement) throws SQLException {
		String [] statusValues= {"ACTIVE","CLOSED","SUSPENDED"};
		
		ResultSet rs= statement.executeQuery("select * from bankaccounts");
		
		while(rs.next()) {
			int status=rs.getInt("status");
			//System.out.println(status);
			System.out.printf("%s %d\t%s\t%s\t%f\t%s\n", 
					rs.getString("type"),
					rs.getInt("account_number"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getDouble("balance"),
					statusValues[status]
					
					);
			
		}
	}

}
