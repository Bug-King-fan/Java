package Advanced.面向对象;

import java.util.ArrayList;

interface AService {
    public abstract  void printInfo(ArrayList<Student1> st);

    public abstract void printAverageScore(ArrayList<Student1> st);
}

/**
 * @author Frank
 * @date 2024/09/22/10:42
 */
public class 学生管理系统接口 {
    public static void main(String[] args) {
        ArrayList<Student1> stu = new ArrayList<>();
        stu.add(new Student1("张三", "男", 90));
        stu.add(new Student1("李四", "男", 80));
        stu.add(new Student1("王五", "女", 70));
        stu.add(new Student1("赵六", "女", 60));
        AService as = new AServiceImpl();
        as.printInfo(stu);
        as.printAverageScore(stu);
    }
}

class Student1 {
    private String name;
    private String sex;
    private double score;

    public Student1() {

    }

    public Student1(String name, String sex, double score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", score=" + score +
                '}';
    }

    public String getSex() {
        return sex;
    }

    public double getScore() {
        return score;
    }
}

class AServiceImpl implements AService {
    @Override
    public void printInfo(ArrayList<Student1> st) {
        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i));
        }
    }

    @Override
    public void printAverageScore(ArrayList<Student1> st) {
        double sum = 0;
        for (int i = 0; i < st.size(); i++) {
            sum += st.get(i).getScore();
        }
        System.out.println("全班成绩平均值：" + sum / st.size());
    }

}
