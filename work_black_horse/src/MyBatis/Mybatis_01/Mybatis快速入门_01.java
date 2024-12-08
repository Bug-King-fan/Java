package MyBatis.Mybatis_01;
/**
 * @author Frank
 * @date 2024/11/11/18:08
 */

/*
https://mybatis.org/mybatis-3/zh_CN/getting-started.html 文档
Mapper代理方式：
    1、创建user表
    2、创建maven工程，导入坐标
    3、编写mybatis核心配置 [Mybatis.xml]
    4、定义与SQL映射文件[UserMapper.xml文件]同名的Mapper接口[interface UserMapper]，
                并将其放在同名路径[相对的两个文件找都是(MyBatis.Mybatis_01.xxx)]下
    5、编写SQL映射文件，设置 SQL映射文件的namespace属性为Mapper接口全限定名[MyBatis.Mybatis_01.UserMapper]
    6、在Mapper接口中定义方法，方法名是SQL映射文件中sql语句的ID，并保持参数和返回值一致
    7、编码
        1.定义POJO类[User] [用于数据库的映射]
        2.定义核心配置文件，获取SqlSessionFactory对象
            InputStream inputStream = Resources.getResourceAsStream(Mybatis_config.xml的Path);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        3.加载SqlSession对象[和数据库交互的类]
            SqlSession ss = sqlSessionFactory.openSession() //手动事务
            SqlSession ss = sqlSessionFactory.openSession(true) //自动事务
        4.通过SqlSession的getMapper()方法获取Mapper接口的代理对象
            映射接口 mapper = ss.getMapper(映射接口.class);
        5.通过对应方法执行sql
            mapper.接口定义的方法
        6.释放资源[try抱起来SqlSession，有自动关闭机制]
 */

public class Mybatis快速入门_01 {

}