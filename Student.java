public class Student extends Person {
    protected int studentID;
    protected String program;
    protected int schoolYear;

    public Student() {
        
    }

    public Student(String lastName, String firstName, char sex, int age, long contactNum, String program, int schoolYear) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex; 
        this.age = age;
        this.contactNum = contactNum;
        this.program = program;
        this.schoolYear = schoolYear;
        this.studentID = (int) Math.floor(Math.random() * 999999);
    }
    
    public Student(String lastName, String firstName, char sex, int age, long contactNum, String program, int schoolYear, int studentID) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex; 
        this.age = age;
        this.contactNum = contactNum;
        this.program = program;
        this.schoolYear = schoolYear;
        this.studentID = studentID;
    }

    public String getProgram() {
        return program;
    }

    public int getSchooYear() {
        return schoolYear;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return super.toString() + "-" + program + "-" + schoolYear + "-" + studentID;
    }

    @Override 
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Program: " + program + 
            "\nStudent ID: " + studentID);
    }
}

abstract class Person {
    protected String firstName;
    protected String lastName;
    protected char sex;
    protected int age;
    protected long contactNum;

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public char getsex() {
        return sex;
    }
    
    public int getAge() {
        return age;
    }

    public long getContactNum() {
        return contactNum;
    }

    public String toString() {
        return getFullName() + "-" + getsex() + "-" + getAge() + "-" + getContactNum();
    }

    public void displayInfo() {
        System.out.println("\nName: " + getFullName() + 
        "\nsex: " + getsex() +
        "\nAge: " + getAge() + 
        "\nContact No: " + getContactNum());
    }
}