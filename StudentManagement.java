import java.util.*;
import java.util.stream.Collectors;


public class StudentManagement {

    private static final double PASS_MARK = 65.0;
    private static final double BONUS_THRESHOLD = 50.0;
    private static final double BONUS_MARKS = 10.0;
    private static final double MAX_MARK = 100.0;

    private final List<Student> students = new ArrayList<>();

    
    public boolean isEmpty() {
        return students.isEmpty();
    }

    public boolean idExists(int id) {
        return students.stream().anyMatch(s -> s.getId() == id);
    }

    public boolean addStudent(Student student) {
        if (idExists(student.getId())) {
            return false;
        }
        students.add(student);
        return true;
    }

    public void displayAllStudents() {
        System.out.println("\n--- All Students ---");
        students.forEach(System.out::println);
    }

    public void searchById(int id) {
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No student found with ID " + id));
    }

}