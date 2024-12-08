package API.字符串;

/**
 * @author Frank
 * @date 2024/09/29/11:39
 */
/*
StringBuffer和StringBuilder的区别
StringBuffer是线程安全的，StringBuilder是线程不安全的
方法基本相同
 */

public class StringBuilder_01 {
    public static void main(String[] args) {
        //创建对象 修改是不会开辟新的空间，原对象修改
        StringBuilder sb1 = new StringBuilder(); //空
        StringBuilder sb2 = new StringBuilder("hello world");
        System.out.println(sb2.toString());
        System.out.println("********");
        //方法
        // append delete reverse length toString insert replace deleteCharAt charAt
        // toString
        // setCharAt indexOf lastIndexOf
        // capacity ensureCapacity trimToSize setLength equals isEmpty

//      append(): 将指定字符串、字符、布尔值或其他数据类型的表示追加到字符串缓冲区的末尾。
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // sb 变为 "Hello World"
        sb.append(true); // 将布尔值追加到字符串缓冲区
        sb.append(123); // 将整数追加到字符串缓冲区
        System.out.println(sb);

//      insert():在指定位置插入指定字符串、字符、布尔值或其他数据类型的表示。
        StringBuilder sb3 = new StringBuilder("Hello");
        sb3.insert(5, " World"); // sb 变为 "Hello World"
        sb3.insert(0, true); // 在指定位置插入布尔值
        sb3.insert(6, 123); // 在指定位置插入整数
        System.out.println(sb3.toString());

//      replace():用新的字符串替换指定范围内的字符序列。不包含结束位置下标。
        StringBuilder sb4 = new StringBuilder("Hello World");
        String a = "Java";
        sb4.replace(6, 11, a); // sb 变为 "Hello Java"
        System.out.println(sb4.toString());

//      delete():删除指定范围内的字符序列。不包含结束位置下标。
        StringBuilder sb5 = new StringBuilder("Hello World");
        sb5.delete(5, 11); // sb 变为 "Hello"
        System.out.println(sb5.toString());

//      deleteCharAt():删除指定索引处的字符。
        StringBuilder sb6 = new StringBuilder("Hello");
        sb6.deleteCharAt(1); // sb 变为 "Hllo"
        System.out.println(sb6.toString());

//      reverse(): 反转字符串缓冲区中的字符序列。
        StringBuilder sb7 = new StringBuilder("Hello");
        sb7.reverse(); // sb 变为 "olleH"
        System.out.println(sb7.toString());

//      charAt():获取指定索引处的字符。
        StringBuilder sb8 = new StringBuilder("Hello");
        char c = sb8.charAt(1); // c 的值为 'e'

//      setCharAt():将指定索引处的字符替换为新的字符。
        StringBuilder sb9 = new StringBuilder("Hello");
        sb9.setCharAt(1, 'a'); // sb 变为 "Hallo"
        System.out.println(sb9.toString());

//      String substring():返回一个新的字符串，其中包含字符串缓冲区中指定范围内的字符。不包含结束位置下标。
        StringBuilder sb10 = new StringBuilder("Hello World");
        String sub = sb10.substring(6, 11); // sub 的值为 "World"


//      indexOf():返回指定子字符串第一次出现的索引。
        StringBuilder sb11 = new StringBuilder("Hello Worworld World");
        int index = sb11.indexOf("World"); // index 的值为 25
        System.out.println(index);

//      lastIndexOf():返回指定子字符串最后一次出现的索引。
        StringBuilder sb12 = new StringBuilder("Hello World Hello");
        int lastIndex = sb12.lastIndexOf("Hello"); // lastIndex 的值为 12
        System.out.println(lastIndex);

//      length():返回字符串缓冲区中的字符数。
        int len = sb.length(); // len 的值为 5

//      capacity():返回当前容量，即可以存储的字符数。
        StringBuilder sb13 = new StringBuilder(20);
        int cap = sb13.capacity(); // cap 的值为 20
        System.out.println(cap);

//      ensureCapacity(): 确保容量至少等于指定的最小值。
        StringBuilder sb14 = new StringBuilder();
        sb14.ensureCapacity(20); // 确保容量至少为 20

//      trimToSize():调整容量以适应字符串的当前大小。
        StringBuilder sb15 = new StringBuilder("Hello");
        sb15.trimToSize(); // 调整容量以适应字符串的当前大小

//      setLength():用于设置当前串的长度。
//如果新长度小于当前长度，那么超出部分的字符将会被丢弃；如果新长度大于当前长度，那么超出部分的字符将会以 null 字符填充。
        StringBuilder sb16 = new StringBuilder("Hello World");
        sb16.setLength(5); // sb16 变为 "Hello"
        System.out.println(sb16.toString());

//      equals():用于比较两个 StringBuilder 对象的内容是否相等。实际上比较的是对象的引用是否相等，而不是对象内容是否相等！
        StringBuilder sb17 = new StringBuilder("Hello");
        StringBuilder sb18 = new StringBuilder("Hello");
        boolean result = sb17.equals(sb18); // result 的值为 false
        System.out.println(result);
//      判断内容是否相等
        boolean result2=sb17.toString().equals(sb18.toString());
        System.out.println(result2);
//      这里需要注意的是，StringBuilder 类中的 equals() 方法并没有重写 Object 类中的 equals() 方法，而是沿用了 Object 类中的 equals() 方法。
//      它实际上比较的是对象的引用是否相等，而不是对象内容是否相等。
//      如果需要比较两个 StringBuilder 对象的内容是否相等，可以先将其转换为 String 类型，然后使用 String 类的 equals() 方法进行比较，或者直接使用 toString() 方法将其转换为 String 类型再进行比较。


//        19.isEmpty():用于检查 StringBuilder 对象是否为空。
        boolean isEmpty = sb.isEmpty(); // 判断 StringBuilder 对象是否为空
        if (isEmpty) {
            System.out.println("StringBuilder 对象为空");
        } else {
            System.out.println("StringBuilder 对象不为空");
        }

    }
}


