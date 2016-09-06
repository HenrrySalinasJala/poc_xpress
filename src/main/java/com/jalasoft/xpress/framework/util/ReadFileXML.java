package com.jalasoft.xpress.framework.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Mijhail Villarroel on 9/6/2016.
 */
public final class ReadFileXML {

    private ReadFileXML() {
    }

    public static List<String> getListDimensions(String pathFileXML) {
        String attributeXML = "title";
        String xPathExpression = "//Application//Dimension[@"+attributeXML+"]";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<String> listDimensions = new ArrayList<>();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File(pathFileXML));
            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
            for (int i = 0; i < nodos.getLength(); i++) {
                listDimensions.add(nodos.item(i).getAttributes().getNamedItem(attributeXML).toString());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return listDimensions;
    }
}
