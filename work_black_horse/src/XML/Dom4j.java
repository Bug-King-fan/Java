package XML;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Frank
 * @date 2024/11/11/12:44
 */

/*
利用Dom4j提供的核心类SaxReader，将XML文件加载到Document对象中
利用document对象获取根，再从根获取其下子元素、文本

方法：
    1、SAXReader
        SAXReader sr = new SAXReader();
        Document document = sr.read(url); 获取document对象
    2、Document
        Element root = document.getRootElement(); 获取根元素
    3、Element
        List<Element> list = root.elements("name"); 获取指定名称的所有子元素，可以不指定名称
        Element e = root.element("name"); 获取第一个指定名称的子元素
        String nowName = root.getName(); 获取根元素的名称
        String value = root.attributeValue("name"); 获取指定属性名的属性值
        String text = root.getText(); 获取当前元素的文本
        String value = 父元素对象.elementText("子元素名"); 获取指定名称的子元素的文本

 */

public class Dom4j {
    @Test
    public void test() throws Exception {
        SAXReader sa = new SAXReader();
        Document d = sa.read("src/XML/book.xml");
        ArrayList<Element> bookList = (ArrayList<Element>) d.getRootElement().elements("book");
        ArrayList<Book> books = new ArrayList<>();
        //指向两个book元素
        for (Element e : bookList) {
            //两中方法
            if (false) {
                System.out.println(e.getName() + " " + e.attributeValue("id"));
                //获取书的name元素
                Element bookName = e.element("name");
                System.out.println(bookName.getText());
                //获取书的author元素
                Element bookAuthor = e.element("author");
                System.out.println(bookAuthor.getText());
                //获取书的price元素
                Element bookPrice = e.element("sale");
                System.out.println(bookPrice.getText());
                System.out.println("==============================");
            } else {
                System.out.println(e.elementText("name"));
                System.out.println(e.elementText("author"));
                System.out.println(e.elementText("sale"));
                System.out.println("==============================");
                Book temp = new Book(e.elementText("name"), e.elementText("author"), e.elementText("sale"));
                books.add(temp);
            }
        }
        System.out.println("BookList：");
        books.forEach((s) -> {
            System.out.println(s.name + " " + s.author + " " + s.sale);
        });
    }
}

class Book {
    public String name;
    public String author;
    public String sale;

    public Book(String name, String author, String sale) {
        this.name = name;
        this.author = author;
        this.sale = sale;
    }
}