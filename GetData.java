import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GetData implements Runnable {
    public List<Student> get() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("./Record.txt"));
        List<Student> students = new ArrayList<Student>();

        while (reader.hasNextLine()) {
            // dividing the retrieved string
            String[] arr_data = reader.nextLine().split("-");
            
            // destructuring the divided string 
            String lastName = arr_data[0].split(", ")[0];
            String firstName = arr_data[0].split(", ")[1];
            char sex = arr_data[1].charAt(0);
            int age = Integer.parseInt(arr_data[2]);
            long contactNum = Long.valueOf(arr_data[3]);
            String program = arr_data[4];
            int schoolYear = Integer.parseInt(arr_data[5]);
            int studentID = Integer.parseInt(arr_data[6]);
            
            // instantiating the destructured data and add it to local List
            Student student = new Student(lastName, firstName, sex, age, contactNum, program, schoolYear, studentID);
            students.add(student);
        }

        reader.close();
        return students;
    }

    public void run() {
        try {
            // passing the returned List of student to a List from ListOfStudent
            new ListOfStudents(get());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
