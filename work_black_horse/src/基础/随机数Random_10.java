package 基础;

import java.util.Random;

/**
 * @author Frank
 * @date 2024/09/16/10:01
 */
public class 随机数Random_10 {
    public static void main(String[] args) {
        Random r = new Random();
        for(int i=0;i<10;i++){
            System.out.print(r.nextInt(100) + " ");
        }
        System.out.println();
        for(int i=0;i<10;i++){
            System.out.print(r.nextDouble(50) + " ");
        }
    }
}