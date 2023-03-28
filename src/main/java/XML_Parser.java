import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class XML_Parser {

    public static void main(String argv[]) {

        try {
            File inputFile = new File("Laptops.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("laptop");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Laptop id : " + eElement.getAttribute("id"));
                    System.out.println("Brand : " + eElement.getElementsByTagName("brand").item(0).getTextContent());
                    System.out.println("Model : " + eElement.getElementsByTagName("model").item(0).getTextContent());
                    System.out.println("Screen size : " + eElement.getElementsByTagName("screen_size").item(0).getTextContent());
                    System.out.println("Resolution : " + eElement.getElementsByTagName("resolution").item(0).getTextContent());
                    System.out.println("Processor name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Processor clock speed : " + eElement.getElementsByTagName("clock_speed").item(0).getTextContent());
                    System.out.println("Processor cores : " + eElement.getElementsByTagName("cores").item(0).getTextContent());
                    System.out.println("Memory size : " + eElement.getElementsByTagName("size").item(0).getTextContent());
                    System.out.println("Memory type : " + eElement.getElementsByTagName("type").item(0).getTextContent());
                    System.out.println("Storage type : " + eElement.getElementsByTagName("type").item(1).getTextContent());
                    System.out.println("Storage size : " + eElement.getElementsByTagName("size").item(1).getTextContent());
                    System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
