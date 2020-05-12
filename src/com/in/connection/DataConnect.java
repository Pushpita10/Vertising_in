 package com.in.connection;
    import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	public class DataConnect 
	{
	  public Connection con;
	  public ResultSet rs;
	   
	   public Connection dataConnect()
	   {
		 try 
	      {
	    	  //System.out.println("hiss");
	    
	          Class.forName("com.mysql.jdbc.Driver");  
	          System.out.println("Loading");
	        
	      } 
	      catch (ClassNotFoundException ex) 
	      {
	    	 System.out.println("driver load...........");
	       System.out.println(ex);
	      }
	      try
	      
          {
	          con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/vertisinginn","root","");
	          System.out.println("Loaded");
          }
	      
	      catch (SQLException ex)
	      {
	    	 
             System.out.println(ex);
	      }
	      return con;
	   
	   
	}
	}
