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



public class write extends HttpServlet {
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


        String sql_write;
        String sql_update;
        String id = null;                        //用户id
        String time=null;                        //留言时间
        String name = null;                      //用户名
        String message = null;                  //留言内容
        String background=null;                 //留言板背景颜色
        String fontColor=null;                  //留言字体颜色


        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        id = req.getParameter("user_id");                    //获取参数
        name = req.getParameter("name");
        message=req.getParameter("password");
        time=req.getParameter("time");
        background=req.getParameter("bg");
        fontColor=req.getParameter("fc");


        sql_write = "INSERT INTO message(user_id,name,time,message,messageType,background,fontColor)"
                +"VALUES("+id+",'"+name+"','"+message+"',0,'"+fontColor+"')";
        //对应的更新语句
        sql_update="SELECT name,time,message,messageType,background,fontColor FROM message where user_id ="+id+"";

        System.out.println(sql_write);

        try {
            SQLdemo te = new SQLdemo();

            PrintWriter out = resp.getWriter();

            if(	te.executeUpdate(sql_write))

            {
                out.print(te.ShowMessage(sql_update));                                     //返回结果
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
