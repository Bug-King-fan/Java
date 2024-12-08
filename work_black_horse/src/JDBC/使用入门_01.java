package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Frank
 * @date 2024/11/08/18:43
 */

/*
JDBC:
    1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
    2、获取链接
        String  url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
    3、定义SQL
        String sql = "select * from user";
    4、获取执行SQL对象
        Statement stmt = conn.createStatement();
    5、执行SQL
        ResultSet rs = stmt.executeQuery(sql);
    6、处理结果集
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
    7、释放资源
        rs.close();
        stmt.close();
        conn.close();
 */

/*
API详解：
    DriverManager:驱动管理类[注册驱动，获取数据库链接]
        1、注册驱动[mysql5之后，自动注册，可省略]
            Class.forName("com.mysql.jdbc.Driver"); 加载driver类
        2、获取链接
            url = jdbc:mysql://ip:端口/t数据库?键值对1&键值对2&...
            Connection conn = DriverManager.getConnection(url, username, password);
    Connection:数据库链接[获取执行SQL对象、事务管理]
        1 、获取SQL执行对象
            Statement stmt = conn.createStatement();
        2、事务管理
            conn.setAutoCommit(false);手动提交
            conn.commit();
            conn.rollback();
    Statement:执行SQL
        1、执行SQL
            ResultSet rs = stmt.executeQuery(sql); DQL[返回ResultSet集合]
            int status = stmt.executeUpdate(sql);  DDL[创建返回0表示成功] DML[增删改返回受影响行数]
    PreparedStatement:预编译SQL[防止SQL注入] Statement的子接口
        1、获取对象[sql提前创建好，使用？占位符进行占位]
            sql = select * from usr where usrname = ? and password = md5(?) ;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            psmt.setXXX(index, value);
        2、执行SQL
            psmt.executeQuery();
    ResultSet:结果集
        1、处理结果集[一个指针指向第一行数据]
            while (rs.next()) {
                System.out.println(rs.getSInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        2、获取列数
            ResultSet.getMetaData().getColumnCount()
        3、获取表名
            ResultSet.getMetaData().getTableName(1)
        4、获取i列类型
            ResultSet.getMetaData().getColumnType(i)
        5、获取i列长度
            ResultSet.getMetaData().getColumnDisplaySize(i)
        6、获取i列索引
            ResultSet.getMetaData().getColumnLabel(i)
        7、获取i列名
            ResultSet.getMetaData().getColumnName(i)

 */

public class 使用入门_01 {

    @Test
    public void userLogin() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/frank_sql?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "frankwu";
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement smt = conn.createStatement();
        String name = "admin";
        String pwd = "admin";
        String sql = "select * from usr where usrname = '" + name + "' and password = md5('" + pwd.trim() + "');";

        ResultSet rs = smt.executeQuery(sql);
        if (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            System.out.println("登录成功!");
        } else {
            System.out.println("登录失败!");
        }
    }

    @Test
    public void test() throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2、获取链接
        String url = "jdbc:mysql://localhost:3306/frank_sql?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "frankwu";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3、定义SQL
        String sql = "select * from usr";
        //4、获取执行SQL对象
        Statement stmt = conn.createStatement();
        //5、执行SQL
        ResultSet rs = stmt.executeQuery(sql);
        //6、处理结果集
        System.out.println("id " + "\t" + "name" + "\t" + " password");
        while (rs != null && rs.next()) {
            System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "    " + rs.getString(3));
            System.out.println("=======================================================");
        }
        //7、释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}