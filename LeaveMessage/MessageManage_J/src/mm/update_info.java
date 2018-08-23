/*
更新用户信息
*/
package mm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class update_info extends HttpServlet {
    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     * HttpServletRequest , javax.servlet.http.HttpServletResponse)
     */
    //主要用于使用者的信息更改，比如用户账号、用户名、类别、密码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql2;
        String sql3;

        String id = null;                     //用户帐号
        String name=null;                    //用户名
        String type=null;                     //类型
        String password=null;                 //密码

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        name = req.getParameter("user_name");                   //获取参数
        password=req.getParameter("password");


        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        sql2="update user set name='"+name+"' where user_id="+ load.id+"";
        sql3="update user set password='"+password+"' where user_id="+ load.id+"";

        try {

            SQLdemo te = new SQLdemo();

            System.out.println("Write Operation succeed");

            PrintWriter out = resp.getWriter();

            if(name==null&&password==null)
            {

            }

            else	if(name!=null&&password==null)
            {
                te.executeUpdate(sql2);
            }

            else	if(name==null&&password!=null)
            {
                te.executeUpdate(sql3);
            }

            else if(name!=null&&password!=null)
            {
                te.executeUpdate(sql2);
                te.executeUpdate(sql3);
            }

            out.print(te.now());

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
