package 流IO;

/**
 * @author Frank
 * @date 2024/10/30/16:02
 */

/*
FileReader 默认使用UTF-8的编码格式
转换流：[自身没有读写能力，需要以来普通的输入输出流（InputStream/OutputStream）]
    InputStreamReader：
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\test.txt"),"GBK");
    OutputStreamWriter：
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\test.txt"),"UTF-8");
 */

public class 转换流读写指定编码的文件_09 {
    public static void main(String[] args) {

    }
}