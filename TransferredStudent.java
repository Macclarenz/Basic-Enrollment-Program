public class TransferredStudent extends Student {
    protected String formerProgram;

    // with student ID
    public TransferredStudent(String lastName, 
        String firstName, 
        char sex, 
        int age,
        long contactNum, 
        String formerProgram, 
        String program,
        int schoolYear,
        int studentID) {

        super(lastName, firstName, sex, age, contactNum, program, schoolYear, studentID);
        this.formerProgram = formerProgram;
    }
    
    // without student ID
    public TransferredStudent(String lastName, 
        String firstName, 
        char sex, 
        int age,
        long contactNum, 
        String formerProgram, 
        String program,
        int schoolYear) {

        super(lastName, firstName, 
            sex, age, 
            contactNum, program, 
            schoolYear);
            
        this.formerProgram = formerProgram;
    }

    public String getFormerProgram() {
        return formerProgram;
    }

    @Override
    public String toString() {
        return getFullName() + "-" +
            getSex() + "-" + 
            getAge() + "-" +
            (convertContactNum(contactNum)) + "-" +
            getProgram() + "_" + getFormerProgram() + "-" + 
            getSchooYear() + "-" +
            getStudentID();
    }

    private String convertContactNum(long contactNum) {
        if (contactNum == 0) return "0";
        else return "0" + contactNum;
    }

    @Override
    public void displayInfo() {
        System.out.println("\nName: " + getFullName() + 
        "\nsex: " + getSex() +
        "\nAge: " + getAge() + 
        "\nContact No: " + (convertContactNum(getContactNum())) +
        "\nProgram: " + getProgram() + " (from, " + getFormerProgram() + ")" + 
        "\nSchool year: " + getSchooYear() +
        "\nStudent ID: " + getStudentID() +
        "\n");
    }
}
