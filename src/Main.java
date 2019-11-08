import java.util.*;

public class Main {

    public static void main(String[] args) {
        StudentGrades myClass = new StudentGrades();
        Scanner userInput = new Scanner(System.in);
        char userChoice;
        String inputFirstName;
        String inputLastName;
        int inputID;
        String inputGrade;

        System.out.println("Welcome to my program that stores students and their grades and outputs them all in alphabetical order");

        do {
            System.out.println("Please enter 1 of the following chars: 'a' to add a student, 'r' to remove a student, 'm' to modify a students grades, 'p' to print all students grades, 'x' to end program");
            userChoice = userInput.nextLine().charAt(0);

            switch (userChoice) {
                case 'a':
                    System.out.println("Please enter the last name of student to add: ");
                    inputLastName = userInput.nextLine();
                    System.out.println("Please enter the first name of student to add: ");
                    inputFirstName = userInput.nextLine();
                    System.out.println("Please enter the ID of student to add: ");
                    inputID = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println("Please enter grade of our specified student: ");
                    inputGrade = userInput.nextLine();
                    if(!myClass.addStudent(inputLastName, inputFirstName, inputID, inputGrade)) {
                        System.out.println("Student with same ID already exists! Adding unsuccessful");
                    }
                    break;
                case 'r':
                    System.out.println("Please enter the ID of student to remove: ");
                    inputID = userInput.nextInt();
                    userInput.nextLine();
                    if(!myClass.removeStudent(inputID)) {
                        System.out.println("Student not found! Remove unsuccessful.");
                    }
                    break;
                case 'm':
                    System.out.println("Please enter the ID of student to modify grade: ");
                    inputID = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println("Please enter the new grade for student: ");
                    inputGrade = userInput.nextLine();
                    if(!myClass.changeGrade(inputID, inputGrade)) {
                        System.out.println("Student not found! Modify unsuccessful");
                    }
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


