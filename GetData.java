import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class GetData implements Runnable {
    public List<Student> get() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("./Record.txt"));
        List<Student> students = new ArrayList<Student>();

        while (reader.hasNextLine()) {
            String[] arr_data = reader.nextLine().split("-");
                        
            // destructuring the divided string 
            String lastName = arr_data[0].split(", ")[0];
            String firstName = arr_data[0].split(", ")[1];
            char sex = arr_data[1].charAt(0);
            int age = Integer.parseInt(arr_data[2]);
            long contactNum = Long.valueOf(arr_data[3]);
            
            String program = null;
            String formerProgram = null;

            if (stringFinder(arr_data[4])) {
                formerProgram = arr_data[4].split("_")[1];
                program = arr_data[4].split("_")[0];
            } else {
                program = arr_data[4];
            }
            
            int schoolYear = Integer.parseInt(arr_data[5]);
            int studentID = Integer.parseInt(arr_data[6]);
            
            // instantiating the destructured data and add it to local List
            if (formerProgram != null) {
                TransferredStudent transferredStudent = new TransferredStudent(lastName, firstName, sex, age, contactNum, formerProgram, program, schoolYear, studentID);
                // this will be accepted since `TransferredStudent` is a subclass of `Student`
                students.add(transferredStudent);
            } else {
                Student student = new Student(lastName, firstName, sex, age, contactNum, program, schoolYear, studentID);
                students.add(student);
            } 
        }

        reader.close();
        return students;
    }

    public boolean stringFinder(String value) {
        Pattern pattern = Pattern.compile("_");
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
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
