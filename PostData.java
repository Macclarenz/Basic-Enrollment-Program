import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PostData implements Runnable {
    private final File record = new File("./Record.txt");

    public PostData() {}
    
    public PostData(Student student) throws IOException {
        post(student);
    }

    // post the new data 
    public void post(Student student) throws IOException {
        FileWriter writer = new FileWriter(record, true);
        writer.write(student.toString() + "\n");
        writer.close();
        System.out.println("Saved.");
    }

    public void run(Student student) {
        try {
            post(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        
    }
}
