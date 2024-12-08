package XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author Frank
 * @date 2024/11/11/13:23
 */

/*
XPath对dom4j进行了二次封装
1、导入dmo4j和jaxen包
2、通过SAXReader创建Document对象
3、利用XPathAPI进行解析
方法：  [Node 是 Document，Element的父接口]
    1、Node selectSingleNode(path) 获取符合表达的唯一元素
    2、List<Node> selectNodes(path) 获取符合表达的所有元素

XPath表达方式：
    1、绝对路径：/根元素/子元素/子子元素/....  /books/book/author
    2、相对路径：./子元素/子子元素/....       ./book/name
    3、全文搜索路径: //子元素//子子元素  //name
    4、谓语路径: //元素[@属性]  //book[@id[(可选)="0001"]]
 */

public class XPath {
    //绝对路径
    @Test
    public void test() throws DocumentException {
        SAXReader sa = new SAXReader();
        Document d = sa.read("src/XML/book.xml");
        String path = "/books/book/author";
        List<Node> list = d.selectNodes(path);
        for (Node node : list) {
            System.out.println(node.getText());
        }
    }

    //相对路径
    @Test
    public void test2() throws DocumentException {
        SAXReader sa = new SAXReader();
        Document d = sa.read("src/XML/book.xml");
        String path = "/books/book";
        List<Node> list = d.selectNodes(path);
        for (Node node : list) {
            path = "./name";
            Node name = node.selectSingleNode(path);
            System.out.println(name.getText());

        }
    }

    //全文搜索
    @Test
    public void test3() throws DocumentException {
        SAXReader sa = new SAXReader();
        Document d = sa.read("src/XML/book.xml");
        String path = "//sale";
        List<Node> list = d.selectNodes(path);
        for (Node node : list) {
            System.out.println(node.getText());
        }
    }

    //谓语路径
    @Test
    public void test4() throws DocumentException {
        SAXReader sa = new SAXReader();
        Document d = sa.read("src/XML/book.xml");
        String path = "//book[@id]";
        List<Node> list = d.selectNodes(path);
        for (Node node : list) {
            Element e = (Element) node;
            System.out.println(e.attribute("id").getValue());
            System.out.println(e.elementText("name"));
        }
    }

}