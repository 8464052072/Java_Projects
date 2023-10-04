package Capstone_Project;

import java.sql.*;

public class dbCon {

	Connection conn;
	Statement stat;
	ResultSet rs;
	ResultSetMetaData md;
	public dbCon()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chandu","chandu","Gopi@123");
			stat=conn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
