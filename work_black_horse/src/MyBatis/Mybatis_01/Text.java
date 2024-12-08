package MyBatis.Mybatis_01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Frank
 * @date 2024/11/11/18:55
 */
public class Text {
    @Test
    public void test() throws Exception {
        //配置文件路径
        String path = "MyBatis/resources/Mybatis.xml";
        //依据路径创建输入流 Resources是本类的类加载器相当于Text.class.getClassLoader()
        InputStream inputStream = Resources.getResourceAsStream(path);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession ss = sqlSessionFactory.openSession();){

            //Mybatis默认手动事务！！！需要手动提交或回滚
            //delete 等操作会返回受影响行数，返回int
            UserMapper mapper = ss.getMapper(UserMapper.class);
            List<User> all = mapper.findAll();
            for (User user : all) {
                System.out.println(user);
            }

            ss.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}