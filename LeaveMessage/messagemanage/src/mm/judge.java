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


public class judge extends HttpServlet {
    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     * HttpServletRequest , javax.servlet.http.HttpServletResponse)
     */
    //主要用于查看留言板留言属性
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql_judge;
        String sql_pass;
        String sql_delete;
        String messageType;
        String messageId;

        String pass=null;
        String delete=null;

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

//        messageType = req.getParameter("messageType");
        pass=req.getParameter("pass");
        delete=req.getParameter("dele");
        messageId = req.getParameter("messageId");


        sql_judge="SELECT user_id,messageId,name,DATE_FORMAT(time,'%Y-%m-%d %H:%i:%s') as time,message,messageType,background,fontColor FROM messages";

        sql_delete="update messages set messageType='"+2+"' where messageId='"+ messageId+"'";
        sql_pass="update messages set messageType='"+1+"' where messageId='"+ messageId+"'";


        try {
            SQLdemo te = new SQLdemo();

            System.out.println("Write Operation succeed");

            PrintWriter out = resp.getWriter();
            out.print(te.ShowMessage(sql_judge));

            if(pass.equals("pass")&&delete.equals(""))
            { te.executeUpdate(sql_pass); }
            else	if(pass.equals("")&&delete.equals("delete"))
            {
                te.executeUpdate(sql_delete);
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

