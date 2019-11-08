import java.util.*;

public class StudentGrades {
    private Map<Student, String> studentGrades;

    public StudentGrades () {
         studentGrades = new TreeMap<Student, String>(new IDComp());
    }

    public boolean addStudent(String lastName, String firstName, int id, String grade) {
        Student curStudent;
        Set<Student> setKeys = studentGrades.keySet();
        Iterator<Student> setKeysIterator = setKeys.iterator();

        while(setKeysIterator.hasNext()) {
            curStudent = setKeysIterator.next();
            if(curStudent.id == id) {
                return false;
            }
        }


        Student inputStudent = new Student();
        inputStudent.lastName = lastName;
        inputStudent.firstName = firstName;
        inputStudent.id = id;

        studentGrades.put(inputStudent, grade);
        return true;
    }

    public boolean removeStudent(int id) {
        Student curStudent;
        Set<Student> setKeys = studentGrades.keySet();
        Iterator<Student> setKeysIterator = setKeys.iterator();

        while(setKeysIterator.hasNext()) {
            curStudent = setKeysIterator.next();
            if(curStudent.id == id) {
                studentGrades.remove(curStudent);
                return true;
            }
        }

        return false;
    }

    public boolean changeGrade(int id, String grade) {
        Student curStudent;
        Set<Student> setKeys = studentGrades.keySet();
        Iterator<Student> setKeysIterator = setKeys.iterator();

        while(setKeysIterator.hasNext()) {
            curStudent = setKeysIterator.next();
            if(curStudent.id == id) {
                studentGrades.replace(curStudent, grade);
                return true;
            }
        }

        return false;
    }

    public void printAllGrades() {
        if(studentGrades.isEmpty()) {
            System.out.println("Student list is empty");
        }
        studentGrades.forEach((name, grade) -> printAllGradesHelper(name, grade));
    }

    private void printAllGradesHelper(Student name, String grade) {
        System.out.println(name.lastName + ", " + name.firstName + ": " + grade);
    }


}

class IDComp implements Comparator<Student> {
    @Override
    public int compare(Student e1, Student e2) {
        if(!e1.lastName.toLowerCase().equals(e2.lastName.toLowerCase())) {
            return e1.lastName.toLowerCase().compareTo(e2.lastName.toLowerCase());
        }
        else if(!e1.firstName.toLowerCase().equals(e2.firstName.toLowerCase())) {
            return e1.firstName.toLowerCase().compareTo(e2.firstName.toLowerCase());
        }
        else if(e1.id > e2.id){
            return 1;
        }
        else if(e1.id < e2.id){
            return -1;
        }
        else {
            return 0;
        }
    }
}

