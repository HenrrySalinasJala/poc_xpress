package com.jalasoft.xpress.framework.util;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Created by Mijhail Villarroel on 9/6/2016.
 */
public final class ReadFileXML {
    
    private static final Logger LOGGER = Logger.getLogger(ReadFileXML.class.getName());
    
    private static final String EXPRESSION_NOT_FOUND = "The expression not found";
    
    private static final String FILE_NOT_FOUND = "The file not found";
    
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
                
                listDimensions.add(nodos.item(i).getAttributes().getNamedItem(attributeXML).getTextContent());
            }
        } catch (XPathExpressionException | SAXException | ParserConfigurationException e) {
            LOGGER.warn(EXPRESSION_NOT_FOUND, e);
        } catch (IOException e) {
            LOGGER.error(FILE_NOT_FOUND, e);
        }
        Collections.sort(listDimensions);
        return listDimensions;
    }
}
