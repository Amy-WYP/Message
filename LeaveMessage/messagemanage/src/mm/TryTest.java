/*
测试：通过 Servlet  读取数据，并返回为 JSON 格式的数据。
*/
package mm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TryTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TryTest() {
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
            sql = "SELECT * FROM message";
            ResultSet rs = stmt.executeQuery(sql);
            JSONArray jsonarray = new JSONArray();
            JSONObject jsonobj = new JSONObject();
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                jsonobj.put("用户名", rs.getString("name"));
                jsonobj.put("留言", rs.getString("message"));


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
            out.print("获取数据失败!");
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