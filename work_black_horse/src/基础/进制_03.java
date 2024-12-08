package 基础;

/**
 * @author Frank
 * @date 2024/09/15/16:43
 */
public class 进制_03 {
    public static void main(String[] args) {
        //图片在存储时一般采用二进制存储，每个方格占 4 字节, (透明度,R,G,B) 每个值为0-255
        //声音按照波段存储，每个波段占 2 字节，-32768~32767
        //视频按照帧存储，每个帧占 1 字节，0~255
        // 10进制
        int a = 10;
        // 16进制(0x)
        int b = 0x10;
        // 8进制(0)
        int c = 010;
        // 2进制(0b)
        int d = 0b10;
        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println("**********************");
        //Integer类
        int e = 345;
        System.out.println(Integer.toBinaryString(e));
        System.out.println(Integer.toHexString(e));
        System.out.println(Integer.toOctalString(e));
        //ASCII码
        char f = 68;
        System.out.println(f);
    }
}