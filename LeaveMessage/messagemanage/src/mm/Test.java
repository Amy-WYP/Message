/*
测试：连接数据库
*/
package mm;


//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    Connection conn;

    public Test() {
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException var3) {
            var3.printStackTrace();
        }

        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mm?useUnicode=true&characterEncoding=UTF8&useSSL=false", "root", "0101.wyp.0065");
            System.out.println("数据库连接成功");
            this.conn.close();
            System.out.println("数据库gb成功");
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return this.conn;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.getConnection();
    }
}

