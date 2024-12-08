package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/19/11:09
 */
/*
java中可以用 extern 表示类的继承关系（java中只能单继承！！！）
    子类可以直接使用父类成员/方法 (非private成员)



 */


public class 继承_04 {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.age = 18;
        zi.mod();
        zi.mod3();
    }
}

class Fu {
    public int age;
    private String name;

    public void mod(){
        System.out.println("mod");
    }
    private void mod2(){
        System.out.println("mod2");
    }
    protected void mod3(){
        System.out.println("mod3");
    }
}

class Zi extends Fu {

}
