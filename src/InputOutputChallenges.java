import JmbUtils.InputValidator;

import java.util.Scanner;

public class InputOutputChallenges {
    public static void FirstExercise() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");

        var myName = scanner.nextLine();

        System.out.println("Enter your age:");
        var myAge = scanner.nextLine();

        System.out.println("Enter your favourite hobby:");
        var myFavHobby = scanner.nextLine();

        System.out.println(String.format("My name is %s. I am %s years old and my favourite hobby is %s", myName, myAge, myFavHobby));
    }

    public static void DocExercise_First() {
        var studentNumber = InputValidator.GetInt("Enter your student number:");
        var studentName = InputValidator.GetString("Enter your name:");
        var studentAge = InputValidator.GetCustomInteger("Enter your age:", (a) -> a > 0 && a <= 150);
        var percentage = InputValidator.GetDouble("Enter what percentage you got?");
        var grade = InputValidator.GetChar("Enter what grade you got?");

        System.out.println("Student ID: " + studentNumber);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age: " + studentAge);
        System.out.println("Overall percentage: " + percentage);
        System.out.println("Awarded grade: " + grade);
        System.out.println("Verified: true");
    }
}
