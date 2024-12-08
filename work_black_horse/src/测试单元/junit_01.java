package 测试单元;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Frank
 * @date 2024/11/02/11:52
 */
/*
Junit单元测试:
    Junit提供多个注解：
        @BeforeClass 全局只会执行一次，而且是第一个运行（标记方法需要是静态无参无返回值的方法）
        @Before 在测试方法运行前运行(非静态无参无返回值方法)
        @Test 测试方法(非静态无参无返回值方法)
        @After 在测试方法运行后运行(非静态无参无返回值方法)
        @AfterClass 全局只会执行一次，而且是最后一个运行（标记方法需要是静态无参无返回值的方法）
        @Ignore 忽略此方法
Assert:断言类[断言为假报错，断言为真不报错]
    Assert.assertEquals(期望,真实); //断言相等
    Assert.assertNotEquals(期望,真实); //断言不相等
    Assert.assertTrue(a); //断言为真
    Assert.assertFalse(a); //断言为假
    Assert.assertNull(a); //断言为null
    Assert.assertNotNull(a); //断言不为null
 */

public class junit_01 {


    @Before
    public void before() {
        System.out.println("测试前置方法");
        Assert.assertEquals(5, 5);
    }

    @After
    public void after() {
        System.out.println("测试后置方法");
    }

    //设置该方法运行时间在time内
    @Test(timeout = 1000)
    public void method() {
        System.out.println("测试方法1");
    }

    @Test
    public void method2() {
        System.out.println("测试方法2");
    }

}