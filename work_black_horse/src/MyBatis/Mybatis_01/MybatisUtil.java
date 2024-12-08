package MyBatis.Mybatis_01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Frank
 * @date 2024/11/12/13:06
 */
public class MybatisUtil {

    private static SqlSessionFactory ssf = null;

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("MyBatis/resources/Mybatis.xml");
            ssf = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("static静态代码块初始失败");
        }
    }

    private MybatisUtil() {

    }

    public static SqlSession openSession() {
        return ssf.openSession();
    }

    public static SqlSession openSession(boolean autoCommit) {
        return ssf.openSession(autoCommit);
    }

    public static void close(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}