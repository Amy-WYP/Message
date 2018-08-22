/*
测试：通过 Servlet  读取数据，并返回为 JSON 格式的数据。
*/
package MM;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class STest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public STest() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置响应内容类型
        // 设置响应内容类型
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();


        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?useSSL=false","root","0101.wyp.0065");

            Statement stmt = connect.createStatement(); //创建Statement对象
            String sql;
            sql = "SELECT user_id,type,name,password FROM userinfo";
            ResultSet rs = stmt.executeQuery(sql);
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                jsonobj.put("账号", rs.getString("user_id"));
                jsonobj.put("类型", rs.getString("type"));
                jsonobj.put("用户名", rs.getString("name"));
                jsonobj.put("密码", rs.getString("password"));

                jsonarray.add(jsonobj);
            }
            // 输出数据
            out = response.getWriter();

            out.println(jsonarray);
            // 完成后关闭
            rs.close();
            stmt.close();
            connect.close();
        }catch (Exception e) {
            out.print("获取用户数据失败!");
            e.printStackTrace(); }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}