import java.util.Scanner;

public class DisplayInfo {
    public static void initDisplayInfo(Scanner input) {
        char user_choice;

        outerloop: while (true) {
            System.out.print("\nPlease enter one of the following character on what to display" + 
            "\na - Display all students" + 
            "\nb - Display students of a department" + 
            "\nc - Display info of a student" +
            "\nd - Cancel" +
            "\n=====================================" + 
            "\nChoice: ");

            user_choice = input.next().charAt(0);
            switch (user_choice) {
                // displays all students in all department
                case 'a':
                    System.out.println("display all info");
                    new ListOfStudents().displayAllStudents();
                    break;
                case 'b':
                // per department
                    System.out.println("display students of a department");
                    initDisplayStudentPerDepartment(input);
                    break;
                case 'c':
                // for specific student
                    System.out.println("display student");
                    initDisplayStudent(input);
                    break;
                case 'd':
                // to go back to the main input
                    System.out.println("\nGoing back...\n");
                    break outerloop;
                default: 
                    System.out.println("Error: Please enter only the following character.\n");
            }
        }
    }

    // displays all students of a department
    public static void initDisplayStudentPerDepartment(Scanner input) {
        String user_choice_department;
        outerloop:while (true) {
            System.out.print("Please one of the following department: " + 
                "\n- BSIT" +  
                "\n- BSTM" + 
                "\n- BSHM" + 
                "\n- BSBM" + 
                "\n- BSCS" + 
                "\n================================" +
                "\nChoice: ");
            user_choice_department = input.nextLine().toUpperCase();

            switch (user_choice_department) {
                case "BSIT":
                    new ListOfStudents().displayBSITStudents();
                    break outerloop;
                case "BSTM": 
                    new ListOfStudents().displayBSTMStudents();
                    break outerloop;
                case "BSHM":
                    new ListOfStudents().displayBSHMStudents();
                    break outerloop;
                case "BSBM":
                    new ListOfStudents().displayBSBMStudents();
                    break outerloop;
                case "BSCS": 
                    new ListOfStudents().displayBSCSStudents();
                    break outerloop;
                default: 
                    System.out.println("Error. Please enter only the following departmet.\n");
            }
        }
    }

    // displays info of a specific student
    public static void initDisplayStudent(Scanner input) {
        String lastName, firstName, program;
        Student student = null;
        
        outerloop:while (true) {
            System.out.print("\nPlease enter the last name of the student: ");
            lastName = input.nextLine(); // to flush
            lastName = input.nextLine();

            System.out.print("Please enter the first name of the student: ");
            firstName = input.nextLine();
            
            System.out.print("Please enter the program name of the student: ");
            program = input.nextLine().toUpperCase();

            String fullName = lastName + ", " + firstName;

            // checks if input in `program` is not empty
            if (!program.isBlank()) {
                student = findStudent(fullName, program);
            } else {
                student = findStudent(fullName);
            }

            // checks if the return object is empty or not
            if (student != null) {
                System.out.println("\nFound it:" +
                    "\n================================================");
                student.displayInfo();
            } else {
                System.out.println("\nError: Student not found.");
            }

            // exits the loop for this method
            break outerloop;
        }
    }

    public static Student findStudent(String fullName) {
        return new ListOfStudents().getStudentFromAllProgram(fullName);
    }

    public static Student findStudent(String fullname, String program) {
        Student student = null;
        switch (program) {
            case "BSIT":
                student = new ListOfStudents().getStudentFromBSIT(fullname); 
                break;
            case "BSTM":
                student = new ListOfStudents().getStudentFromBSTM(fullname);
                break;
            case "BSHM":
                student = new ListOfStudents().getStudentFromBSHM(fullname);
                break;
            case "BSBM":
                student = new ListOfStudents().getStudentFromBSBM(fullname);
                break;
            case "BSCS":
                student = new ListOfStudents().getStudentFromBSCS(fullname);
                break;
            default: 
                student = findStudent(fullname);
        }

        return student;
    }
}
