package 异常;

/**
 * @author Frank
 * @date 2024/10/15/10:47
 */
public class 手动抛异常_05 {
    public static void main(String[] args) {
        Student9 s = new Student9();
        try {
            s.reg(-1001);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(s);
        }
    }
}

class Student9 {
    private int id;

    public void reg(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            //System.out.println("id非法");
            //手动抛出异常
            //1、无需函数旁的throws和调用时的try-catch
            //throw new RuntimeException("id非法");
            //2、
            throw new Exception("id 非法");
        }
    }

    @Override
    public String toString() {
        return ("id: " + this.id);
    }
}