package 反射注解动态代理;

import org.junit.Test;

/**
 * @author Frank
 * @date 2024/11/10/16:07
 */

/*
注解通常结合反射技术去使用
哪些地方可以写注解：
    1、类、接口、自定义注解
    2、构造器
    3、方法
    4、属性
    5、参数

自定义注解格式：
[public] @interface 注解名称 {
    public 属性类型 属性名() default 默认值;
}
其中属性类型包含：八大基本数据类型，String ，Class，注解类型，枚举类型，以上类型组成的一维数组

 */

@interface Annotation {
    public String name();

    public double price() default 99.0;
}


@Annotation(name = "嫦娥")
public class 注解_03 {
    @Annotation(name = "猪八戒", price = 100.0)
    private String name;

    @Annotation(name = "构造")
    public 注解_03() {

    }
    @Annotation(name = "方法")
    public void mod(@Annotation(name = "参数") String str) {

    }
    @Test
    public void test() {

    }
}