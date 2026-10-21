import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManagement management = new StudentManagement();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ", -1, Integer.MAX_VALUE);
            handleChoice(choice);
        } while (choice != 0);
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n==========================================");
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        System.out.println("1. Register New Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Filter Passing Students");
        System.out.println("5. Filter Failing Students");
        System.out.println("6. Search Students by Name");
        System.out.println("7. Sort Students by Name");
        System.out.println("8. Sort Students by Average Marks");
        System.out.println("9. Display All Courses");
        System.out.println("10. Display Unique Courses");
        System.out.println("11. Search Students by Course");
        System.out.println("12. Display Unique Skills");
        System.out.println("13. Group Students by Course");
        System.out.println("14. View Student Performance Statistics");
        System.out.println("15. View Best Performing Student");
        System.out.println("16. View Top 3 Students");
        System.out.println("17. Apply Bonus Marks");
        System.out.println("18. View Final Student Ranking");
        System.out.println();
        System.out.println("0. Exit");
        System.out.println("\n==========================================");
    }

    private static void handleChoice(int choice) {
        if (choice < 0 || choice > 18) {
            System.out.println("Invalid option. Please choose between 0 and 18.");
            return;
        }
        
        if (choice > 1 && management.isEmpty()) {
            System.out.println("No students registered yet. Please register a student first (option 1).");
            return;
        }
        switch (choice) {
            case 1 -> registerStudent();
            case 2 -> management.displayAllStudents();
            case 3 -> management.searchById(readInt("Enter student ID to search: ", 1, Integer.MAX_VALUE));
            case 4 -> management.filterPassing();
            case 5 -> management.filterFailing();
            case 6 -> management.searchByName(readNonEmpty("Enter name (or part of it): "));
            case 7 -> management.sortByName();
            case 8 -> management.sortByAverage();
            case 9 -> management.displayAllCourses();
            case 10 -> management.displayUniqueCourses();
            case 11 -> management.searchByCourse(readNonEmpty("Enter course name: "));
            case 12 -> management.displayUniqueSkills();
            case 13 -> management.groupByCourse();
            case 14 -> management.performanceStatistics();
            case 15 -> management.bestStudent();
            case 16 -> management.topThree();
            case 17 -> management.applyBonus();
            case 18 -> management.finalRanking();
            case 0 -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid option.");
        }
    }

    private static void registerStudent() {
        int id = readInt("Enter student ID: ", 1, Integer.MAX_VALUE);
        if (management.idExists(id)) {
            System.out.println("A student with ID " + id + " already exists. Registration cancelled.");
            return;
        }

        String name = readNonEmpty("Enter student name: ");
        int age = readInt("Enter age: ", 1, 120);
        int numCourses = readInt("Enter number of courses: ", 1, 50);

        Map<String, Double> courses = new LinkedHashMap<>();
        for (int i = 1; i <= numCourses; i++) {
            String course;
            while (true) {
                course = readNonEmpty("Course " + i + " name: ");
                String finalCourse = course;
                if (courses.keySet().stream().anyMatch(c -> c.equalsIgnoreCase(finalCourse))) {
                    System.out.println("You already entered that course. Try another.");
                } else {
                    break;
                }
            }

            double mark = readDouble("Marks for " + course + " (0-100): ", 0, 100);
            courses.put(course, mark);
        }

        System.out.print("Enter skills (comma separated): ");
        List<String> skills = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        if (management.addStudent(new Student(id, age, name, skills, courses))) {
            System.out.println("Student registered successfully.");
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) return value;
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= min && value <= max) return value;
                System.out.println("Please enter a value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be empty.");
        }
    }
}
