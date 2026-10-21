
import java.util.List;
import java.util.Map;

public class Student {

    private int id;
    private int age;
    private String studentName;
    private List<String> skills;
    private Map<String, Double> courses;



    private boolean bonusApplied = false;
    private double originalAverage = -1;

    public Student(int id, int age, String studentName, List<String> skills,Map<String, Double> courses) {
        this.id = id;
        this.age = age;
        this.studentName = studentName;
        this.skills = skills;
        this.courses = courses;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public void SetAge(int age) {
        this.age = age;
    }

    public void SetStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void SetSkills(List<String> skills) {
        this.skills = skills;
    }

    public void SetCourses(Map<String, Double> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Map<String, Double> getCourses() {
        return courses;
    }

     public boolean isBonusApplied() {
         return bonusApplied; 
        }
    public void setBonusApplied(boolean bonusApplied) {
         this.bonusApplied = bonusApplied;
         }

    public void setOriginalAverage(double originalAverage) { 
        this.originalAverage = originalAverage;
     }


    public double getAverage() {
        return courses.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    
    public double getOriginalAverage() {
        return bonusApplied ? originalAverage : getAverage();
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", studentName='" + studentName + '\'' +
                ", skills=" + skills +
                ", courses and marks=" + courses +
                ", average=" + 
                '}';
    }
}
