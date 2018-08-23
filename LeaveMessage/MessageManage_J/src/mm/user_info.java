/*
查看用户信息
*/
package mm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class user_info extends HttpServlet {
    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     * HttpServletRequest , javax.servlet.http.HttpServletResponse)
     */
    //主要用于使用者的信息更改，比如id，类型名字，密码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql1;

        String user_id=null;                //账号
        String type=null;                 //类型
        String name=null;               //用户名
        String password=null;           //密码

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");


        sql1="SELECT user_id,type,name,password"
                + "FROM user "
                + "WHERE user.user_id="+ load.id+"";


        try {

            SQLdemo te = new SQLdemo();

            System.out.println("Write Operation succeed");

            System.out.println("json ok");

            PrintWriter out = resp.getWriter();

            out.print(te.User(sql1));

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
