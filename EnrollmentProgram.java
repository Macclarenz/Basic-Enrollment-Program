import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EnrollmentProgram {
    public EnrollmentProgram() throws FileNotFoundException, IOException, InterruptedException {
        // get the data while user interact
        GetData fd = new GetData();
        Thread thread_get = new Thread(fd);
        thread_get.setName("Enrollment Main - get");
        thread_get.start();

        Scanner main_input = new Scanner(System.in);
        int user_choice;

        // start of interaction
        outerloop: while (true) {
            System.out.print("\nPlease enter one of the following: " + 
                "\n1 - Enroll" + 
                "\n2 - Shift Program / Transfer" + 
                "\n3 - Display Info" + 
                "\n4 - Exit Program" + 
                "\n=====================================" + 
                "\nChoice: ");
            user_choice = main_input.nextInt();

            switch (user_choice) {
                // Enrollment
                case 1:
                    System.out.println("Enroll");
                    Enroll enroll = new Enroll();
                    enroll.initEnroll(main_input);
                    break;
                // Shift Program / Transfer
                case 2:
                    System.out.println("Shift program");
                    // Enroll transfer = new Enroll();
                    // transfer.initEnroll(main_input, true);
                    ShiftProgram shiftProgram = new ShiftProgram();
                    shiftProgram.initShiftProgram(main_input);
                    break;
                // Display Info
                case 3: 
                    System.out.println("Display Info");
                    DisplayInfo.initDisplayInfo(main_input);
                    break;
                // Program Exit
                case 4: 
                    System.out.println("Program Exit.");
                    main_input.close();
                    break outerloop;
                default:
                    System.out.println("Error: Please the following only");
            }
        }
    }
}
