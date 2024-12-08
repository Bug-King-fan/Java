package 基础;

/**
 * @author Frank
 * @date 2024/09/16/9:48
 */
public class While使用_09 {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 100) {
            i++;
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }

        }
        System.out.println("**************************");
        i = -1;
        do {
            System.out.println(i);
            i--;
        } while (i >= 0);
        System.out.println("**************************");
        //逢7过
        i = 1;
        while (i < 100) {
            int ge = i % 10;
            int shi = (i / 10) % 10;
            if (ge == 7 || shi == 7 || i % 7 == 0) {
                System.out.print("过 ");
            } else {
                System.out.print(i + " ");
            }
            if (i % 10 == 0) {
                System.out.println();
            }
            i++;
        }
        //break 与 continue
        i = 1;
        while (true) {
            if (i >= 8848) {
                break;
            } else {
                i *= 2;
                continue;
            }
//            System.out.println("baga");  不可达，continue即进入下一次循环，跳过之后的语句
        }

    }
}