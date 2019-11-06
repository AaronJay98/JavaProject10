import java.util.Map;
import java.util.TreeMap;

public class StudentGrades {
    private Map<String, String> studentGrades;

    public StudentGrades () {
         studentGrades = new TreeMap<String, String>();
    }

    public boolean addStudent(String name, String grade) {
        if(!studentGrades.containsKey(name)) {
            studentGrades.put(name, grade);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String name) {
        if(!studentGrades.containsKey(name)) {
            studentGrades.remove(name);
            return true;
        }
        return false;
    }

    public boolean changeGrade(String name, String grade) {
        if(!studentGrades.containsKey(name)) {
            studentGrades.put(name, grade);
            return true;
        }
        return false;
    }

    public void printAllGrades() {
        studentGrades.forEach((name, grade) -> printAllGradesHelper(name, grade));
    }

    private void printAllGradesHelper(String name, String grade) {
        System.out.println(name + ": " + grade);
    }
}
