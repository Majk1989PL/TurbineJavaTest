
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class LogParser {
    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        InputSource inputSource = new InputSource(new StringReader(xml));
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputSource);

        List ids = new ArrayList<Integer>();
        NodeList message1 = document.getElementsByTagName("message");
        for (int i = 0; i < message1.getLength(); i++) {
            if (message1.item(i).getTextContent().equals(message)) {
                Node messageNode = null;
                messageNode = message1.item(i);
                Element element = (Element) messageNode;
                Node parentNode = element.getParentNode();
                Element element2 = (Element) parentNode;
                ids.add(Integer.valueOf(element2.getAttribute("id")));
            }
        }

        return ids;
    }

    public static void main(String[] args) throws Exception {

        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"2\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for (int id : ids)
            System.out.println(id);
    }
}