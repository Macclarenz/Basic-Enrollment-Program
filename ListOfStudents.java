import java.util.List;
import java.util.ArrayList;

public class ListOfStudents {
    private static List<Student> list_students;
    private static List<Student> list_students_BSIT;
    private static List<Student> list_students_BSTM;
    private static List<Student> list_students_BSHM;
    private static List<Student> list_students_BSBM;
    private static List<Student> list_students_BSCS;

    public ListOfStudents() {
    }

    public ListOfStudents(List<Student> list_students) {
        ListOfStudents.list_students = list_students;
        list_students_BSIT = new ArrayList<Student>();
        list_students_BSTM = new ArrayList<Student>();
        list_students_BSHM = new ArrayList<Student>();
        list_students_BSBM = new ArrayList<Student>();
        list_students_BSCS = new ArrayList<Student>();
        distribute_students_per_department();
    }

    private void distribute_students_per_department() {
        for (Student student : list_students) {
            switch (student.getProgram()) {
                case "BSIT":
                    list_students_BSIT.add(student);
                    break;
                case "BSTM":
                    list_students_BSTM.add(student);
                    break;
                case "BSHM":
                    list_students_BSHM.add(student);
                    break;
                case "BSBM":
                    list_students_BSBM.add(student);
                    break;
                case "BSCS":
                    list_students_BSCS.add(student);
                    break;
                default:
            }

        }
    }

    // GENERAL LIST
    public List<Student> getListOfStudents() {
        return ListOfStudents.list_students;
    }

    public void displayAllStudents() {
        for (Student student : list_students) {
            student.displayInfo();
        }
    }

    public Student getStudentFromAllProgram(String name) {
        Student foundStudent = null;
        for (Student student : list_students) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                foundStudent = student;
                break;
            }
        }

        return foundStudent;
    }

    // BSIT LIST
    public void displayBSITStudents() {
        for (Student student : list_students_BSIT) {
            student.displayInfo();
        }
    }

    public Student getStudentFromBSIT(String name) {
        Student foundStudent = null;
        for (Student student : list_students_BSIT) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                foundStudent = student;
                break;
            }
        }

        return foundStudent;
    }

    // BSTM LIST
    public void displayBSTMStudents() {
        for (Student student : list_students_BSTM) {
            student.displayInfo();
        }
    }

    public Student getStudentFromBSTM(String name) {
        Student foundStudent = null;
        for (Student student : list_students_BSTM) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                foundStudent = student;
                break;
            }
        }

        return foundStudent;
    }

    // BSHM LIST
    public void displayBSHMStudents() {
        for (Student student : list_students_BSHM) {
            student.displayInfo();
        }
    }

    public Student getStudentFromBSHM(String name) {
        Student foundStudent = null;
        for (Student student : list_students_BSHM) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                foundStudent = student;
                break;
            }
        }

        return foundStudent;
    }

    // BSBM LIST
    public void displayBSBMStudents() {
        for (Student student : list_students_BSBM) {
            student.displayInfo();
        }
    }

    public Student getStudentFromBSBM(String name) {
        Student foundStudent = null;
        for (Student student : list_students_BSBM) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                foundStudent = student;
                break;
            }
        }

        return foundStudent;
    }

    // BSCS LIST
    public void displayBSCSStudents() {
        for (Student student : list_students_BSCS) {
            student.displayInfo();
        }
    }

    public Student getStudentFromBSCS(String name) {
        Student foundStudent = null;
        for (Student student : list_students_BSCS) {
            if (student.getFullName().equalsIgnoreCase(name)) {
                foundStudent = student;
                break;
            }
        }

        return foundStudent;
    }
}
