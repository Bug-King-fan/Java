package 案例.JDBC三层案例.dao层;

import 案例.JDBC三层案例.JDBCUnitls.Untils;
import 案例.JDBC三层案例.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Frank
 * @date 2024/11/09/18:53
 */

//用户数据访问层[数据库交互]
public class UserDao {
    //登录
    public User checkLogin(User u) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User temp = null;
        //链接数据库
        try {
            conn = Untils.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("链接数据库失败！");
        }
        //编写SQL
        String sql = "select * from usr where usrname = ? and password = ? ;";
        //执行SQL
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getUserName());
            pstmt.setString(2, u.getPassword());
            rs = pstmt.executeQuery();

            //返回结果
            if (rs != null && rs.next()) {
                temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Untils.close(conn, pstmt, rs);
        }
        return temp;
    }

    //添加用户
    public int addUser(User u) {

        return 1;
    }

    //修改用户
    public int updateUser(User u) {

        return 1;
    }

    //删除用户
    public int deleteUser(User u) {

        return 1;
    }

    //返回用户列表
    public ArrayList<User> getUserList() {

        return null;
    }


}