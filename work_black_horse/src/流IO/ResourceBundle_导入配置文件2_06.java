package 流IO;

import java.util.ResourceBundle;

/**
 * @author Frank
 * @date 2024/10/30/14:23
 */

/*
RescueBundle是一个抽象类,我们可以使用他的子类：PropertyResourceBundle来导入.properties配置文件
作用：读取项目src目录下的.properties配置文件

创建对象：
    ResourceBundle rb = ResourceBundle.getBundle("路径,且配置文件不能写后缀");
方法：
    String value = rb.getString("key");
    String value = rb.getString("key", "默认值");
 */

public class ResourceBundle_导入配置文件2_06 {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("流IO/file/05Properties");
        System.out.println(rb.getString("Hive"));
    }
}