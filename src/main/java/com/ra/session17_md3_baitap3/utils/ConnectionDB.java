package com.ra.session17_md3_baitap3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB
{
	public static Connection openConnection()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/session17_md3_baitap3", "root", "123456");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			throw new RuntimeException(e);
		}
		return con;
	}
	
	public static void closeConnection(Connection con)
	{
		if (con != null)
		{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				throw new RuntimeException(e);
			}
		}
	}
	
}
