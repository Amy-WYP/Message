/**
 *主要用于连接数据库，实现数据库查询，更新，以及返回JSON数组
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SQLDemo {

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

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://192.168.1.101:8080/test/load\",\"jsonData\":[ ";

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



    public String user(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回    用户个人信息
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://192.168.1.101:8080/test/user\",\"jsonData\":[ ";

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



    public String storage(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回    超市物品信息 >>留言板
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http:// 192.168.1.101:8080/MM/storage\",\"jsonData\":[ ";

        Connection conn = getConection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery(sql);
        rsd = rs.getMetaData();
        while (rs.next()) {

            str = str + "{\"id\":" + rs.getString(1) + ","
                    + "\"name\":\"" + rs.getString(2)
                    + "\",\"type\":\"" + rs.getString(5) + "\","
                    + "\"in_price\":" + rs.getString(7) + ","
                    + "\"price\":" + rs.getString(3) + ","
                    + "\"profit\":" + rs.getString(8) + ","
                    + "\"number\":" + rs.getString(4) + "" + "},";
        }

        str = str.substring(0, str.length() - 1);
        str = str + "]}";
        System.out.println(str);

        return str;

    }




    public String orders(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回   订单信息
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://192.168.1.101:8080/test/orders\",\"jsonData\":[ ";

        Connection conn = getConection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery(sql);
        rsd = rs.getMetaData();

        while (rs.next()) {

            str = str + "{\"order_id\":" + rs.getString(1) + "," + "\"date\":\"" + rs.getString(2) + "\",\"allprice\":"
                    + rs.getString(3) + "" + "},";
        }

        str = str.substring(0, str.length() - 1);
        str = str + "]}";

        return str;

    }



    public String profitTable(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回   用户订单信息
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://192.168.1.101:8080/test/profit\",\"jsonData\":[ ";

        Connection conn = getConection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery(sql);
        rsd = rs.getMetaData();

        while (rs.next()) {

            str = str + "{\"order_id\":" + rs.getString(1) + "," + "\"uid\":" + rs.getString(2) + ","
                    + "\"all_in_price\":" + rs.getString(5) + "," + "\"all_price\":" + rs.getString(4) + ","
                    + "\"date\":\"" + rs.getString(3) + "" + "\",\"all_profit\":" + rs.getString(6) + "" + "},";
        }

        str = str.substring(0, str.length() - 1);
        str = str + "]}";

        return str;

    }

    public String order_item(String sql) throws SQLException
    // 连接数据库根据sql语句参数执行查询，并以JSON数组格式返回  订单详情 >>  留言详情
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://192.168.1.101:8080/test/cusitem\",\"jsonData\":[ ";

        Connection conn = getConection();
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery(sql);
        rsd = rs.getMetaData();

        while (rs.next()) {

            str = str  + "{\"goods_id\":" + rs.getString(1) + "," + "\"goods_name\":\"" + rs.getString(2) + "\"," + "\"price\":"
                    + rs.getString(3) + "," + "\"goods_number\":" + rs.getString(4) + "" + "},";
        }

        str = str.substring(0, str.length() - 1);
        str = str + "]}";

        return str;

    }










    public String now() throws SQLException
            //点击进货
    {

        String str = "{\"code\":1,\"msg\":\"\",\"url\":\"http://192.168.1.101:8080/test/warebuy\",\"jsonData\":[ ";



        str = str  + "{ \"all_price\":0," + "\"type\": 0" + "}";



        str = str + "]}";
        System.out.print(str);

        return str;

    }







}
