import java.util.*;

public class Main {

    public static void main(String[] args) {
        StudentGrades myClass = new StudentGrades();
        Scanner userInput = new Scanner(System.in);
        char userChoice;
        String inputName;
        String inputGrade;

        System.out.println("Welcome to my program that stores students and their grades and outputs them all in alphabetical order");

        do {
            System.out.println("Please enter 1 of the following chars: 'a' to add a student, 'r' to remove a student, 'm' to modify a students grades, 'p' to print all students grades, 'x' to end program");
            userChoice = userInput.nextLine().charAt(0);

            switch (userChoice) {
                case 'a':
                    System.out.println("Please enter the name of student to add: ");
                    inputName = userInput.nextLine();
                    System.out.println("Please enter grade of our specified student: ");
                    inputGrade = userInput.nextLine();
                    myClass.addStudent(inputName, inputGrade);
                    break;
                case 'r':
                    System.out.println("Please enter the name of student to remove: ");
                    inputName = userInput.nextLine();
                    myClass.removeStudent(inputName);
                    break;
                case 'm':
                    System.out.println("Please enter the name of student to modify grade: ");
                    inputName = userInput.nextLine();
                    System.out.println("Please enter the new grade for student: ");
                    inputGrade = userInput.nextLine();
                    myClass.changeGrade(inputName, inputGrade);
                    break;
                case 'p':
                    myClass.printAllGrades();
                    break;
                case 'x':
                    System.out.println("Now ending program. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid entry! Please try again.");
            }
        } while(userChoice != 'x');
    }
}
