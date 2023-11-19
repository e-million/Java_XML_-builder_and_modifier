/**
 * ModifyStudentsXML class provides methods to load, modify, and save an XML document
 * containing student information.
 * 
 * @version 1.0
 * @since 2023-11-18
 */
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModifyStudentsXML {

    /**
     * The main method of the ModifyStudentsXML class.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        try {
            // Load the existing XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("students.xml"));

            // Modify the XML content
            modifyStudents(doc);

            // Save the modified document to students_updated.xml
            saveDocument(doc, "students_updated.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Modifies the content of the given XML document.
     * 
     * @param doc The XML document to be modified.
     */
    private static void modifyStudents(Document doc) {
        // Get the root element
        Element rootElement = doc.getDocumentElement();

        // Get a list of all "student" elements
        NodeList studentList = rootElement.getElementsByTagName("student");

        // Iterate over each student element
        for (int i = 0; i < studentList.getLength(); i++) {
            Node studentNode = studentList.item(i);

            if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element studentElement = (Element) studentNode;

                // Create a list to store child nodes in ArrayList (firstName, lastName, major, etc)
                List<Node> studentChildNodeList = new ArrayList<>();

                // Get child nodes of the student and store them in a nodeList
                NodeList childNodes = studentNode.getChildNodes();

                // Iterate over child nodes of each student element
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);

                    // if node is a student object then change text content to all uppercase
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        // Convert text content to uppercase
                        childNode.setTextContent(childNode.getTextContent().toUpperCase());
                        studentChildNodeList.add(childNode); // add child node back to parent
                    }
                }

                // Add a new attribute "graduationYear" with a value of 2025
                studentElement.setAttribute("graduationYear", "2025");
                studentElement.getTextContent();
            }
        }
    }
    
    // changes that were made to the document were the graduationYear attribute was added to each student element to have the value of 2025
    // and all the text within each node and child node were set to upper case

    /**
     * Saves the modified XML document to a new file.
     * 
     * @param doc      The modified XML document.
     * @param fileName The name of the file to save the document to.
     * @throws TransformerException If an error occurs during the transformation and saving process.
     */
    private static void saveDocument(Document doc, String fileName) throws TransformerException {
        // Save the document to a new XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(source, result);

        System.out.println("Modified XML saved to " + fileName + "\n");

        // Print to console
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
    }
}
