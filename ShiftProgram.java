import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ShiftProgram {
    public void initShiftProgram(Scanner input) throws InterruptedException, IOException {
        char user_choice;
        outerloop: while (true) {
            System.out.print("\nPlease enter one of the following letter: " +
                    "\na - New student" +
                    "\nb - Enrolled student" +
                    "\nc - Cancel" +
                    "\n================================================================" + 
                    "\nChoice: ");
            user_choice = input.next().charAt(0);

            switch (user_choice) {
                case 'a':
                    System.out.println("Transfer / Enroll student");
                    shiftProgramNewStudent(input);
                    break;
                case 'b':
                    System.out.println("Change Program");
                    shiftProgramEnrolledStudent(input);
                    break;
                case 'c':
                    System.out.println("Going back...");
                    break outerloop;
                default:
                    System.out.println("Error: Please enter only one the following letters.\n");
            }
        }
    }

    private void shiftProgramNewStudent(Scanner input) throws InterruptedException, IOException {
        Enroll transfer = new Enroll();
        transfer.initEnroll(input, true);
    }

    private void shiftProgramEnrolledStudent(Scanner input) throws IOException {
        System.out.print("Please enter the last name of the student: ");
        String lastName = input.nextLine(); // flush
        lastName = capitalizeWord(input.nextLine());

        System.out.print("Please enter the first name of the student: ");
        String firstName = capitalizeWord(input.nextLine());

        System.out.print("Please enter the current program of the student: ");
        String currentProgram = input.nextLine().toUpperCase();

        String fullName = lastName + ", " + firstName;
        Student student;

        // to access the static list of students
        ListOfStudents listOfStudents = new ListOfStudents();
               
        if (currentProgram.isBlank()) {
            student = listOfStudents.getStudentFromAllProgram(fullName, true);
        } else {
            switch (currentProgram) {
                case "BSIT":
                    student = listOfStudents.getStudentFromBSIT(fullName, true);
                    break;
                case "BSTM":
                    student = listOfStudents.getStudentFromBSTM(fullName, true);
                    break;
                case "BSHM":
                    student = listOfStudents.getStudentFromBSHM(fullName, true);
                    break;
                case "BSBM":
                    student = listOfStudents.getStudentFromBSBM(fullName, true);
                    break;
                case "BSCS":
                    student = listOfStudents.getStudentFromBSCS(fullName, true);
                    break;
                default:
                    student = listOfStudents.getStudentFromAllProgram(fullName, true);
            }
        }

        if (student == null) {
            System.out.println("Error: Student not found. Please try again.");
        } else {
            System.out.println("Student Information");
            student.displayInfo();

            // enters the new program and school year
            System.out.print("Please enter the student's new program: ");
            String newProgram = input.nextLine().toUpperCase();

            System.out.print("Please enter the new student's year: ");
            int newSchoolYear = input.nextInt();

            // set a new program and school year for the student
            TransferredStudent newStudent = new TransferredStudent(
                student.getLastName(),
                student.getFirstName(),
                student.getSex(),
                student.getAge(),
                student.getContactNum(),
                student.getProgram(),
                newProgram,
                newSchoolYear,
                student.getStudentID()
            );

            // add the changed student to the list
            listOfStudents.addStudent(newStudent);

            // displays the new info of the student
            System.out.println("New Student Information");
            newStudent.displayInfo();

            // rewrites the record file to update and then fetch another data
            saveAndUpdate(listOfStudents);
        }
    }

    private void saveAndUpdate(ListOfStudents listOfStudents) throws IOException {
        PostData postData = new PostData();
        Thread thread_post = new Thread(postData);
        thread_post.setName("Shift Program - post");

        GetData getData = new GetData();
        Thread thread_get = new Thread(getData);
        thread_get.setName("Shift Program - get");

        thread_post.start();

        List<Student> students = listOfStudents.getListOfStudents();
        postData.rewrite(students);

        try {
            thread_post.join();
            thread_get.start();
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }

    private String capitalizeWord(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
