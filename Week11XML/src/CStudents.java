/**
 * CStudents class represents a student with various attributes such as ID, first name,
 * last name, major, gender, and email. It provides constructors, getters, and setters
 * for these attributes.
 * 
 * @version 1.0
 * @since 2023-11-18
 */
public class CStudents {
    private int intID;
    private String strFirstName;
    private String strLastName;
    private String strMajor;
    private char chrGender;
    private String strEmail;

    /**
     * Default constructor that initializes the attributes to default values.
     */
    public CStudents() {
        this.intID = 0;
        this.strFirstName = "";
        this.strLastName = "";
        this.strMajor = "";
        this.chrGender = ' ';
        this.strEmail = "";
    }

    /**
     * Parameterized constructor that sets the attributes based on provided values.
     * 
     * @param intId    The ID of the student.
     * @param strFirst The first name of the student.
     * @param strLast  The last name of the student.
     * @param strMjr   The major of the student.
     * @param chrGen   The gender of the student.
     * @param strMail  The email of the student.
     */
    public CStudents(int intId, String strFirst, String strLast, String strMjr, char chrGen, String strMail) {
        this.intID = intId;
        this.strFirstName = strFirst;
        this.strLastName = strLast;
        this.strMajor = strMjr;
        this.chrGender = chrGen;
        this.strEmail = strMail;
    }

    // Getter and setter for ID
    public int getID() {
        return intID;
    }

    public void setID(int intId) {
        intID = intId;
    }

    // Getter and setter for firstName
    public String getFirstName() {
        return strFirstName;
    }

    public void setFirstName(String strFirst) {
        strFirstName = strFirst;
    }

    // Getter and setter for lastName
    public String getLastName() {
        return strLastName;
    }

    public void setLastName(String strLast) {
        strLastName = strLast;
    }

    // Getter and setter for major
    public String getMajor() {
        return strMajor;
    }

    public void setMajor(String strMjr) {
        strMajor = strMjr;
    }

    // Getter and setter for gender
    public char getGender() {
        return chrGender;
    }

    public void setGender(char chrGen) {
        chrGender = chrGen;
    }

    // Getter and setter for email
    public String getEmail() {
        return strEmail;
    }

    public void setEmail(String strMail) {
        strEmail = strMail;
    }


}
