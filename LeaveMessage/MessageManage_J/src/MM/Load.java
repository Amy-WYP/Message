package MM;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Load extends HttpServlet {
	public static String id;              //用户id
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest , javax.servlet.http.HttpServletResponse)
	 */
	//主要用于使用者登录
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql1;
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		resp.setHeader("Access-Control-Allow-Credentials", "true");

		id=req.getParameter("user_id");
		
		sql1="SELECT password ,type FROM user where user_id ="+id+"";

		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
	
		try {
			
				SQLdemo te = new SQLdemo();

				System.out.println("Write Operation succeed");

				System.out.println("json ok");

				
					 PrintWriter out = resp.getWriter();
					
					 if(te.executeQuery(sql1))
						 
					 {	 out.print(te.load1(sql1));}

					 else 
					 {		
						 out.print(te.now());
					 }
					 
				
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
