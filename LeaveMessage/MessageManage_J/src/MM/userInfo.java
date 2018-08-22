package MM;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 测试数据库
 */
public class userInfo extends HttpServlet{
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/mm?useUnicode=true&characterEncoding=utf8";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "0101.wyp.0065";
    public static void main(String[] args){
        Connection connection = null;
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //mysql查询语句

            //String sql_userinfo = "SELECT name FROM user";
            String UserInfo = "SELECT user_id,name,password,type"+" FROM user ";
            PreparedStatement prst = connection.prepareStatement(UserInfo);

            //结果集
            ResultSet rs = prst.executeQuery();
            System.out.println("-----------用户信息表----------");
            while (rs.next()) {
                System.out.println("账号:" + rs.getString("user_id"));
                System.out.println("用户名:" + rs.getString("name"));
                System.out.println("密码:" + rs.getString("password"));
                System.out.println("账号类型:" + rs.getString("type"));
                System.out.println("--------------------------");
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}