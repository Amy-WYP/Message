/*
 *主要用于连接数据库，实现数据库查询，更新，以及返回JSON数组
 */
package mm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLdemo {

    private static String driverName = "com.mysql.jdbc.Driver";
    //连接数据库的参数
    private static String dbURL = "jdbc:mysql://localhost:3306/mm?"
            + "user=root&password=0101.wyp.0065&useUnicode=true&characterEncoding=UTF8&useSSL=false";
    private static String userName = "root";
    private static String userPwd = "0101.wyp.0065";

    String type = null;
    String sql = null;
    Statement stmt = null;
    ResultSet rs = null;
    ResultSetMetaData rsd = null;

    public static Connection getConection() {                                                //连接
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.print("----------------连接失败");
        }
        return null;
    }

    public static boolean  executeQuery(String SQL)
    {
        try

        {
            Connection conn=getConection();
            System.out.println("---------------连接数据库成功");
            // String SQL = "SELECT PlanTypeID, PlanTypeName FROM C_PlanType ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
		     /* while (rs.next())
		      {
		         System.out.println(rs.getString("PlanTypeID") + ", " + rs.getString("PlanTypeName"));
		      }*/
            // rs.close();
            // stmt.close();
            return  true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("----------------查询失败");
        }
        return false;
    }


    public static boolean executeUpdate(String SQL) {                                    //返回更新布尔值
        try {
            Connection conn = getConection();
            System.out.println("---------------连接数据库成功");

            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(SQL);
            if (result > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("----------------更新失败");
        }
        return false;
    }


    public String load1(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回   用户密码,类型

    {
        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://localhost:8080/MMJ/loading\",\"jsonData\":[ ";

        Connection conn = getConection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery(sql);
        rsd = rs.getMetaData();

        while (rs.next()) {

            str = str  + "{\"password\":" + rs.getString(1) + "," + "\"type\":"
                    + rs.getString(2) + "" + "},";
        }

        str = str.substring(0, str.length() - 1);
        str = str + "]}";

        return str;

    }

    public String User(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回   用户个人信息
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://localhost:8080/MMJ/user\",\"jsonData\":[ ";

        Connection conn = getConection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery(sql);
        rsd = rs.getMetaData();

        while (rs.next()) {

            str = str + "{\"password\":\"" + rs.getString(1) + "\",\"user_name\":\""
                    + rs.getString(2) + "\",\"sex\":\""
                    + rs.getString(3) + "\"," + "\"birth\":\"" + rs.getString(4) + "\"" + "},";
        }

        str = str.substring(0, str.length() - 1);
        str = str + "]}";

        return str;

    }


    public String ShowMessage(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回     留言信息
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://localhost:8080/MMJ/show_board\",\"jsonData\":[ ";

        Connection conn = getConection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery(sql);
        rsd = rs.getMetaData();
        while (rs.next()) {

            str = str + "{\"id\":" + rs.getString(1) + "," + "\"scource\":\"" + rs.getString(2) + ","+ "\"name\":" + rs.getString(3) + "," + "\"time\":" + rs.getString(4)+ "\",\"message\":\""
                    + rs.getString(5) + "\"," + "\"messageType\":\"" + rs.getString(6) + "\"," + "\"background\":"
                    + rs.getString(7) + ","  + "\"fontColor\":" + rs.getString(8)
                     + "" + "},";
        }

        str = str.substring(0, str.length() - 1);
        str = str + "]}";
        System.out.println(str);

        return str;

    }



    public String now() throws SQLException
    //返回   空的字符数组
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://localhost:8080/MMJ\",\"jsonData\":[ ";

        str = str + "]}";
        System.out.print(str);

        return str;

    }














}
