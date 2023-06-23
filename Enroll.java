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

        enrollees.displayInfo();

        // after filling, the data will be save to a file and update both the file and program
        PostData post = new PostData();
        GetData fetch = new GetData();

        Thread thread_post = new Thread(post);
        Thread thread_get = new Thread(fetch);

        thread_post.start();
        post.post(enrollees);
        thread_post.join();

        System.out.println("Enrollment successful.");

        thread_get.start();
    }

    // to capitalize first letter
    private String capitalizeWord(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}