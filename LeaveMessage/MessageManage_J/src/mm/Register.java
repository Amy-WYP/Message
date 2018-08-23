package mm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest , javax.servlet.http.HttpServletResponse)
	 */
	//用于用户注册，填写相关的个人信息
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql;
		String sql2;
		String sql3;
		String id = null;                        //用户id
		String name = null;                      ///用户名
		String password = null;                  //用户密码
		


		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");

		id = req.getParameter("user_id");                    ///获取参数
		name = req.getParameter("user_name");
		password=req.getParameter("password");

		sql = "INSERT INTO users VALUES("+id+",'"+password+"',1)";
		//对应的更新语句
        sql2="INSERT INTO user_infor(user_id,name,sex,birth)VALUES("+id+",'"+name+"') ";
		sql3="SELECT password ,type FROM users where user_id ="+id+"";
        
        
		System.out.println(sql);

		
		try {
			SQLdemo te = new SQLdemo();

			PrintWriter out = resp.getWriter();
			
		if(	te.executeUpdate(sql)&&te.executeUpdate(sql2))
			
		{
			out.print(te.load1(sql3));                                     //返回结果
		}
			
		
		else {
			out.print(te.now());
		}
		
		
		System.out.println("Write Operation succeed");
            
			
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
