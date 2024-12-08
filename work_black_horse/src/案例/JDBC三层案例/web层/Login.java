package 案例.JDBC三层案例.web层;

import org.junit.Test;
import 案例.JDBC三层案例.User.User;
import 案例.JDBC三层案例.server层.Server;

/**
 * @author Frank
 * @date 2024/11/09/18:40
 */
/*
Web层： 接收客户端数据-》封装为对象-》调用server层方法-》返回结果
 */

public class Login {
    @Test
    public void login() {
        String name = "user3";
        String password = "123";

        User usr = new User();
        usr.setUserName(name);
        usr.setPassword(password);

        Server server = new Server();
        boolean result = server.userLogin(usr);

        if (result) {
            System.out.println("回馈客户端：登录成功。。。");
        } else {
            System.out.println("回馈客户端：登录失败。。。");
        }




    }
}