package 流IO;

/**
 * @author Frank
 * @date 2024/10/24/17:43
 */

/*
IO可以实现程序中存储在内存中的数据写入到文件中，或将文件内容读取到内存中
    I:输入流,读数据
        字节输入流(操作所有类型文件包括音频、视频等)
        字符输入流(操作包括.java .txt 等纯文本文件)
    O:输出流,写数据
        字节输出流(操作所有类型文件包括音频、视频等)
        字符输出流(操作包括.java .txt 等纯文本文件)

字符流和字节流区别：
    1. 数据类型：字节流以字节为单位进行读写，而字符流以字符为单位进行读写。字节流可以处理任意类型的数据，包括文本、图像、音频等，而字符流主要用于处理文本数据。
    2. 编码方式：字节流是以字节的形式直接读写数据，不关心数据的具体编码方式。而字符流是以字符的形式读写数据，会根据指定的字符编码将字符转换为字节进行处理。
    3. 处理效率：字节流的处理效率通常比字符流高，因为字节流直接操作底层的字节数据，不需要进行字符编码的转换。
    4. 使用场景：字节流适用于处理二进制数据，如文件的复制、网络传输等。字符流适用于处理文本数据，如文件的读写、文本的处理等。

字符流和字节流联系：
    1. 继承关系：字节流和字符流都是抽象类InputStream和OutputStream的子类，以及Reader和Writer的子类。
    2. 使用方式：字节流和字符流都提供了类似的读写方法，如read()和write()方法。
    3. 转换：可以通过InputStreamReader和OutputStreamWriter类将字节流转换为字符流，以便处理文本数据。
    4. 字符流是建立在字节流的基础上的。在字符流中，使用了字符编码来处理字符数据，而字符编码又是通过字节流来实现的。因此，字符流可以看作是字节流的高级封装，提供了更方便的字符处理功能。

字节流相关类：
    1. InputStream：所有字节输入流的超类。
    2. FileInputStream：从文件中读取数据的输入流。
    3. BufferedInputStream：带有缓冲区的输入流，提高读取效率。
    4. DataInputStream：可以从输入流中读取Java基本数据类型的输入流。
    5. ObjectInputStream：可以从输入流中读取Java对象的输入流。
    6. OutputStream：所有字节输出流的超类。
    7. FileOutputStream：向文件中写入数据的输出流。
    8. BufferedOutputStream：带有缓冲区的输出流，提高写入效率。
    9. DataOutputStream：可以向输出流中写入Java基本数据类型的输出流。
    10. ObjectOutputStream：可以向输出流中写入Java对象的输出流。
    11. ByteArrayInputStream：是一个输入流，它从一个字节数组中读取数据
    12. ByteArrayOutputStream：是一个输出流，它将数据写入一个字节数组中。

字符流相关类：
    1. Reader：所有字符输入流的超类。
    2. FileReader：从文件中读取字符的输入流。
    3. BufferedReader：带有缓冲区的输入流，提高读取效率。
    4. InputStreamReader：将字节流转换为字符流的输入流。
    5. Writer：所有字符输出流的超类。
    6. FileWriter：向文件中写入字符的输出流。
    7. BufferedWriter：带有缓冲区的输出流，提高写入效率。
    8. OutputStreamWriter：将字符流转换为字节流的输出流。


 */

public class IO概述和分类_01 {
    public static void main(String[] args) {

    }
}