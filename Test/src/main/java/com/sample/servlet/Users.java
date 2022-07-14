package com.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Users extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      JSONArray users=new JSONArray();
		      for(int i=1;i<11;i++)
		    	  {
		    	  JSONObject user=new JSONObject();
		    	  user.put("name", "User" + i);
		    	  users.put(user);
		    	  }
		     	      PrintWriter writer = response.getWriter();
		     	     writer.println(users.toString());
		   }

}
