<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2018/8/20
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;" language="java" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>

<%
    //加载驱动程序
    String driverName="com.mysql.jdbc.Driver";
//数据库信息
    String userName="root";
//密码
    String userPasswd="0101.wyp.0065";
//数据库名
    String dbName="mm";
//表名
    String tableName="用户表";
//将数据库信息字符串连接成为一个完整的url（也可以直接写成url，分开写是明了可维护性强）

    String url="jdbc:mysql://localhost/"+dbName+"?"+"user="+userName+"&password="+userPasswd+"useUnicode=true&characterEncoding=utf8";
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn=DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();
    String sql="SELECT user_id,name,password FROM "+tableName;
    ResultSet rs = stmt.executeQuery(sql);
    out.print("user_id");
    out.print("|");
    out.print("name");
    out.print("|");
    out.print("password");
    out.print("<br>");
    while(rs.next()) {
        out.print(rs.getString(1)+" ");
        out.print("|");
        out.print(rs.getString(2)+" ");
        out.print("|");
        out.print(rs.getString(3));
        out.print("<br>");
    }
    out.print("<br>");
    out.print("ok， Database Query Successd！");
    rs.close();
    stmt.close();
    conn.close();
%>
