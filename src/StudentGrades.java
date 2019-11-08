import java.util.*;

public class StudentGrades {
    private Map<Student, String> studentGrades;

    public StudentGrades () {
         studentGrades = new TreeMap<Student, String>(new IDComp());
    }

    public boolean addStudent(String lastName, String firstName, int id, String grade) {
        //This is one way to compare the id attribute (v1)
        Student curStudent;
        Set<Student> setKeys = studentGrades.keySet();
        Iterator<Student> setKeysIterator = setKeys.iterator();

        while(setKeysIterator.hasNext()) {
            curStudent = setKeysIterator.next();
            if(curStudent.id == id) {
                return false;
            }
        }

        //if a student with the indicated user input ID doesnt exist, the indicated student will be added to the map
        Student inputStudent = new Student();
        inputStudent.lastName = lastName;
        inputStudent.firstName = firstName;
        inputStudent.id = id;

        studentGrades.put(inputStudent, grade);
        return true;
    }

    public boolean removeStudent(int id) {
        //This is a much simpler version (v2) to compare keys compared to the addStudent method version
        for(Student key : studentGrades.keySet()) {
            if(key.id == id) {
                studentGrades.remove(key);
                return true;
            }
        }
        return false;
    }

    public boolean changeGrade(int id, String grade) {
        //This is same v2 method as the removeStudent method except it changes the grade
        for(Student key : studentGrades.keySet()) {
            if(key.id == id) {
                studentGrades.replace(key, grade);
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

    //This is the helper method for printAllGrades public method
    private void printAllGradesHelper(Student name, String grade) {
        System.out.println(name.lastName + ", " + name.firstName + " (" + name.id + "): " + grade);
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

