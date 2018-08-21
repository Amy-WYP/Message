package MMJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import MM.User;
import MMJdbc.JdbcUser;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class UserDAO {
    //数据库连接对象
    public  User  login(String username,String password) {
        User u=null;
        Connection connection =null;
        PreparedStatement pstmt=null;
        ResultSet resultSet=null;

        //赋值
        try {
            connection=JdbcUser.getCon();
            //静态sql语句
            String sql = "select * from user where name=? and password=?";
            pstmt = (PreparedStatement) connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                u=new User();
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                System.out.println("登录成功！");
            }else{
                System.out.println("用户名或者密码错误！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUser.close(pstmt, connection);
        }
        return u;

    }
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
            connection = JdbcUser.getCon();

            String sql  ="insert into user(id,name,password,role)values(?,?,?,?);";

            psmt = (PreparedStatement) connection.prepareStatement(sql);

            //运用实体对象进行参数赋值
            psmt.setInt(1, user.getId());
            psmt.setString(2, user.getName());
            psmt.setString(3,user.getPassword());
            psmt.setInt(4, user.getRole());
            psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JdbcUser.close(psmt, connection);
        }
    }
}
