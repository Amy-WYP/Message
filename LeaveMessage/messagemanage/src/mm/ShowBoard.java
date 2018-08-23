/*
查看留言板
*/
package mm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ShowBoard extends HttpServlet {
    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     * HttpServletRequest , javax.servlet.http.HttpServletResponse)
     */
    //主要用于查看留言板留言属性
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql_select;
        String sql_addMessage;
        String aql;


        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        sql_addMessage="insert into message(user_id)values("+ load.id+")";                  //创建留言

        sql_select = "SELECT * FROM  message where messageType=1";

        try {
            SQLdemo te = new SQLdemo();

            te.executeUpdate(sql_addMessage);

            System.out.println("Write Operation succeed");


            PrintWriter out = resp.getWriter();
            out.print(te.ShowMessage(sql_select));                                   //返回 留言信息 给前端


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

