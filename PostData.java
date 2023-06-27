import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PostData implements Runnable {
    private final File record = new File("./Record.txt");

    public PostData() {}
    
    public PostData(Student student) throws IOException {
        post(student);
    }

    // post the new data 
    public void post(Student student) throws IOException {
        post(student.toString());
    }

    public void post(TransferredStudent transferredStudent) throws IOException {
        post(transferredStudent.toString());
    }

    public void post(String statement) throws IOException {
        FileWriter writer = new FileWriter(record, true);
        writer.write(statement + "\n");
        writer.close();
        System.out.println("Saved.");
    }
    
    public void rewrite(List<Student> students) throws IOException {
        FileWriter writer = new FileWriter(record);
        for (Student student : students) {
            writer.write(student.toString() + "\n");
        }

        writer.close();
        System.out.println("Saved.");
    }

    @Override
    public void run() {
        
    }
}
