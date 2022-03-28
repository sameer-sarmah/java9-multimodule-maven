package modular.xml.search;

import modular.core.ContentType;
import modular.core.IContentSearch;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

public class XmlValueSearch implements IContentSearch {
    @Override
    public Optional<String> search(String document, String xpath, ContentType contentType) {
        if(contentType.equals(ContentType.XML) && !StringUtils.isEmpty(xpath) && !StringUtils.isEmpty(document)){
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            try {
                builder = builderFactory.newDocumentBuilder();
                Document xmlDocument = builder.parse(new InputSource(new StringReader(document)));
                XPath xPath = XPathFactory.newInstance().newXPath();
                NodeList nodeList = (NodeList)xPath.compile(xpath).evaluate(xmlDocument, XPathConstants.NODESET);
                if(nodeList != null && nodeList.getLength() > 0){
                    Node node = nodeList.item(0);
                    return Optional.of(node.getFirstChild().getNodeValue());
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }
}
