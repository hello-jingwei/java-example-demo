package com.mxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlParse {
//    private static DocumentBuilderFactory builderFactory = DocumentBuilderFactory
//            .newInstance();

    public static void main(String[] args) {
        XmlParse parser = new XmlParse();
        Document document = parser.getDomTree("E:\\wjw-workspace\\personal-project\\javabasic\\src\\main\\resources\\book2.xml");
        /* get root element */
        Element rootElement = document.getDocumentElement();

        /* get all the nodes whose name is book */
        NodeList nodeList = rootElement.getChildNodes();
        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            /* get every node */
            Node node = nodeList.item(i);
            System.out.println("node:" + node);

            /* get the next lever's ChildNodes */
            NodeList nodeList2 = node.getChildNodes();
            for (int j = 0; j < nodeList2.getLength(); j++) {
                Node node2 = nodeList2.item(j);
                System.out.println("node2:" + node2);
                if (node2.hasChildNodes()) {
                    System.out.println(node2.getNodeName() + ":"
                            + node2.getFirstChild().getNodeValue());
                }
            }
        }
    }

    public Document getDomTree(String filePath) {
        Document document = null;
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory
                    .newInstance();
            /* DOM parser instance */
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            /* parse an XML file into a DOM tree */
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
