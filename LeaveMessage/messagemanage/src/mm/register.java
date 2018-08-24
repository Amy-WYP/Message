package mm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;



public class register extends HttpServlet {
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest , javax.servlet.http.HttpServletResponse)
	 */
	//用于用户注册，填写相关的个人信息
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//跨域
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
		resp.setHeader("Access-Control-Allow-Credentials", "true");

//		//读取请求传递过来的JSON格式数据，返回JSON字符串
//
//			StringBuffer json=new StringBuffer();
//			String lineString=null;
//			try {
//				BufferedReader reader=req.getReader();
//				while ((lineString=reader.readLine())!=null) {
//					json.append(lineString);
//				}
//			} catch (Exception e) {
//				System.out.println(e.toString());
//			}
//			System.out.println( json.toString());


		String sql_register;
		String sql3;
		String id = null;                        //用户id
		String name = null;                      //用户名
		String password = null;                  //用户密码

		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");

		id = req.getParameter("user_id");                    //获取参数
		name = req.getParameter("name");
		password=req.getParameter("password");

		sql_register = "INSERT INTO user(user_id,type,name,password) VALUES("+id+",0,'"+name+"','"+password+"')";
		//对应的更新语句
		sql3="SELECT password,type,name FROM user where user_id ="+id+"";

		System.out.println(sql_register);

		try {
			SQLdemo te = new SQLdemo();

			PrintWriter out = resp.getWriter();

		if(	te.executeUpdate(sql_register))

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

//	//读取请求传递过来的JSON格式数据，返回JSON字符串
//	private String readJSONData(HttpServletRequest request) {
//		StringBuffer json=new StringBuffer();
//		String lineString=null;
//		try {
//			BufferedReader reader=request.getReader();
//			while ((lineString=reader.readLine())!=null) {
//				json.append(lineString);
//			}
//		} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//		return json.toString();
//	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
