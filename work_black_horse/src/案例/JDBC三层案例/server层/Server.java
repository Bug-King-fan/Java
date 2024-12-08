package 案例.JDBC三层案例.server层;

import 案例.JDBC三层案例.User.User;
import 案例.JDBC三层案例.dao层.UserDao;

/**
 * @author Frank
 * @date 2024/11/09/18:48
 */
//用户业务类
public class Server {

    public boolean userLogin(User u) {
        if (u == null) {
            throw new RuntimeException("传递用户为空！！！");
        }

        //省略加密解密...

        UserDao userDao = new UserDao();
        User user = userDao.checkLogin(u);
        if (user == null) {
            System.out.println("数据库返回null");
            return false;
        }
        System.out.println(user);
        return true;
    }
}