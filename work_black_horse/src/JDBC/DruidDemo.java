package JDBC;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Frank
 * @date 2024/11/09/19:24
 */

/*
this.class.getClassLoader().getResourceAsStream("init.properties")
类加载器,去src下找这个文件
 */

/*
Druid[阿里巴巴开源，自带SQL监控,要导包] 核心类DruidDataSourceFactory
Druid配置参数：
    url:同JDBC
    username:同JDBC
    password:同JDBC
    driverClassName: 驱动类名,一般根据url自动识别为
    initialSize:初始化连接数
    minIdle:最小空闲数
    maxActive:最大活跃数
    maxWait:最大等待时间
    timeBetweenEvictionRunsMillis:最小间隔时间
    minEvictableIdleTimeMillis:最小空闲时间

基本使用:
    1、创建数据库连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(properties对象);
    2、获取数据库连接
        Connection conn = ds.getConnection();
    3、基于conn进行操作同JDBC

 */

public class DruidDemo {
    @Test
    public void test() {
        //加载配置文件
        Properties p = new Properties();
//        InputStream in = DruidDemo.class.getClassLoader().getResourceAsStream("init.properties");
        try (InputStream in = new FileInputStream("src/JDBC/file/init.properties")) {
            p.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //创建连接池
        DataSource da = null;
        try {
            da = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取链接
        Connection conn = null;
        try {
            conn = da.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "select * from usr";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                System.out.println("==============================================");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}