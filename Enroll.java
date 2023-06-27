import java.util.Scanner;
import java.io.IOException;

public class Enroll extends Student {
    public void initEnroll(Scanner input) throws IOException, InterruptedException {
        System.out.print("Please enter the last name: ");
        lastName = input.nextLine(); // flush
        lastName = capitalizeWord(input.nextLine());

        System.out.print("Please enter the first name: ");
        firstName = capitalizeWord(input.nextLine());
        
        System.out.print("Please enter the age: ");
        age = input.nextInt();

        System.out.print("Please enter the sex (m/f): ");
        sex = input.next().charAt(0);

        System.out.print("Please enter the contact number (enter 0 if none): ");
        contactNum = input.nextLong();

        System.out.print("Please enter the chosen program: ");
        program = input.nextLine().toUpperCase(); // flush
        program = input.nextLine().toUpperCase();

        System.out.print("Please enter the school year: ");
        schoolYear = input.nextInt();

        System.out.print("Please enter the school ID (enter 0 if none): ");
        studentID = input.nextInt();

        Student enrollees;

        if (studentID == 0) {
            enrollees = new Student(lastName, firstName, sex, age, contactNum, program, schoolYear);
        } else {
            enrollees = new Student(lastName, firstName, sex, age, contactNum, program, schoolYear, studentID);
        }

        // invokes the method to start a new thread to save and update the program and record file
        saveAndUpdate(enrollees);

        // display a successful message
        displaySuccessMessage();

        // display the enrolled student
        enrollees.displayInfo();

    }

    // overloaded method to check if whether the student wants to shift program or will enroll as
    public void initEnroll(Scanner input, boolean willShift) throws InterruptedException, IOException {
        System.out.print("Please enter the last name: ");
        lastName = input.nextLine(); // flush
        lastName = capitalizeWord(input.nextLine());

        System.out.print("Please enter the first name: ");
        firstName = capitalizeWord(input.nextLine());
        
        System.out.print("Please enter the age: ");
        age = input.nextInt();

        System.out.print("Please enter the sex (m/f): ");
        sex = input.next().charAt(0);

        System.out.print("Please enter the contact number (enter 0 if none): ");
        contactNum = input.nextLong();

        System.out.print("Please enter the former program: ");
        String formerProgram = input.nextLine().toUpperCase();
        formerProgram = input.nextLine().toUpperCase(); // flush

        System.out.print("Please enter the new program: ");
        // program = input.nextLine().toUpperCase(); // flush
        program = input.nextLine().toUpperCase();

        System.out.print("Please enter the school year: ");
        schoolYear = input.nextInt();

        System.out.print("Please enter the school ID (enter 0 if none): ");
        studentID = input.nextInt();

        TransferredStudent transferredStudent;
        System.out.println(formerProgram);
        if (studentID == 0) {
            transferredStudent = new TransferredStudent(lastName, firstName, sex, age, contactNum, program, formerProgram, schoolYear);
        } else {
            transferredStudent = new TransferredStudent(lastName, firstName, sex, age, contactNum, program, formerProgram, schoolYear, studentID);
        }

        // invokes the method to start a new thread to save and update the program and record file
        saveAndUpdate(transferredStudent);

        // display a successful message
        displaySuccessMessage(true);

        // display the enrolled student
        transferredStudent.displayInfo();
    }

    // save and update the record file
    private void saveAndUpdate(Student enrollees) throws InterruptedException, IOException {
         // after filling, the data will be save to a file and update both the file and program
        PostData post = new PostData();
        GetData fetch = new GetData();

        Thread thread_post = new Thread(post);
        Thread thread_get = new Thread(fetch);

        thread_post.start();
        post.post(enrollees);
        thread_post.join();

        thread_get.start();
    }
    
    private void saveAndUpdate(TransferredStudent transferredStudent) throws InterruptedException, IOException {
         // after filling, the data will be save to a file and update both the file and program
        PostData post = new PostData();
        GetData fetch = new GetData();

        Thread thread_post = new Thread(post);
        Thread thread_get = new Thread(fetch);

        thread_post.setName("Enroll - post");
        thread_get.setName("Enroll - get");

        thread_post.start();
        post.post(transferredStudent);
        thread_post.join();

        thread_get.start();

        // System.out.println("post - " + thread_post.isAlive());
        // System.out.println("get - " + thread_get.isAlive());        
    }

    // to capitalize first letter
    private String capitalizeWord(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private void displaySuccessMessage() {
        System.out.println("Enrollment successful.");
    }

    private void displaySuccessMessage(boolean isShift) {
        if (isShift) {
            System.out.println("Enrolled and Shift program successful.");
        } else {
            displaySuccessMessage();
        }
    }
}