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

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Mijhail Villarroel on 9/6/2016.
 */
public final class ReadFileXML {
    private static final Logger LOGGER = Logger.getLogger(ReadFileXML.class.getName());

    private ReadFileXML() {
    }

    public static List<String> getListDimensions(String pathFileXML) {
        String attributeXML = "title";
        String xPathExpression = "//Application//Dimension[@" + attributeXML + "]";
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
            LOGGER.warn("The expression not found", e);
        } catch (SAXException e) {
            LOGGER.warn("The expression not found", e);
        } catch (IOException e) {
            LOGGER.error("The file not found", e);
        } catch (ParserConfigurationException e) {
            LOGGER.warn("The expression not found", e);
        }
        return listDimensions;
    }
}
