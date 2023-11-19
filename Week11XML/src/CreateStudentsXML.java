/**
 * CreateStudentsXML class provides methods to create an XML document containing
 * information about students and save it to a file or print it to the console.
 *
 * @version 1.0
 * @since 2023-11-18
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreateStudentsXML {

    /**
     * The main method of the CreateStudentsXML class.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Create a new document
            Document doc = dBuilder.newDocument();

            // Create root element
            Element rootStudentsElement = doc.createElement("students");
            doc.appendChild(rootStudentsElement);

            // Example student objects in array list
            List<CStudents> students = new ArrayList<>();
            students.add(new CStudents(1, "John", "Doe", "Computer Science", 'M', "john.doe@example.com"));
            students.add(new CStudents(2, "Jane", "Smith", "Mathematics", 'F', "jane.smith@example.com"));
            students.add(new CStudents(3, "Bob", "Johnson", "Physics", 'M', "bob.johnson@example.com"));
            students.add(new CStudents(4, "Alice", "Williams", "Chemistry", 'F', "alice.williams@example.com"));
            students.add(new CStudents(5, "Charlie", "Brown", "Biology", 'M', "charlie.brown@example.com"));
            students.add(new CStudents(6, "Eva", "Miller", "History", 'F', "eva.miller@example.com"));

            // Iterate over student objects in array list
            for (CStudents student : students) {
                // Create student element
                Element studentElement = doc.createElement("student");

                // Add ID property to each XML element
                studentElement.setAttribute("ID", String.valueOf(student.getID()));

                // Add properties as elements
                Element firstNameElement = doc.createElement("firstName");
                firstNameElement.appendChild(doc.createTextNode(student.getFirstName()));
                studentElement.appendChild(firstNameElement);

                // repeated for every student object ^
                Element lastNameElement = doc.createElement("lastName");
                lastNameElement.appendChild(doc.createTextNode(student.getLastName()));
                studentElement.appendChild(lastNameElement);

                Element idElement = doc.createElement("studentID");
                idElement.appendChild(doc.createTextNode(String.valueOf(student.getID())));
                studentElement.appendChild(idElement);

                Element majorElement = doc.createElement("major");
                majorElement.appendChild(doc.createTextNode(student.getMajor()));
                studentElement.appendChild(majorElement);

                Element genderElement = doc.createElement("gender");
                genderElement.appendChild(doc.createTextNode(String.valueOf(student.getGender())));
                studentElement.appendChild(genderElement);

                Element emailElement = doc.createElement("email");
                emailElement.appendChild(doc.createTextNode(student.getEmail()));
                studentElement.appendChild(emailElement);

                // Append student element to root (<student />)
                rootStudentsElement.appendChild(studentElement);
            }

            // Save the document to a file or print it
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // add indenting to the tags output
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            // Save to a file (optional)
            StreamResult result = new StreamResult(new File("students.xml"));
            transformer.transform(source, result);

            // Print to console
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
