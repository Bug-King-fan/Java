package 基础;
import  java.util.Scanner;

/**
 * @author Frank
 * @date 2024/09/16/9:34
 */
public class Switch使用_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        switch (s) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
            case "c":
                System.out.println("c");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}