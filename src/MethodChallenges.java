import java.io.Console;
import java.util.ArrayList;

public class MethodChallenges {
    public static void PrintMyName() {
        System.out.println("James");
    }

    public static void AskAndPrintName() {
        var name = InputValidator.GetString("What is your name?");
        System.out.println("Your name is " + name);
    }

    public static void MultiplyNumbers(int num1, int num2) {
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
    }

    public static void TestResult(String nameOfStudent, int testScore) {
        String grade = "";
        if (testScore <= 100 && testScore >= 90) {
            grade = "A*";
        } else if (testScore <= 89 && testScore >= 80) {
            grade = "A";
        } else if (testScore <= 79 && testScore >= 70) {
            grade = "B";
        } else if (testScore <= 69 && testScore >= 60) {
            grade = "C";
        } else if (testScore <= 59 && testScore >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }
        System.out.println(nameOfStudent + " got result: " + grade);
    }

    public static void DoubleNumberTest() {
        var result = MethodChallenges.DoubleNumber(25);
        System.out.println(result);
    }

    public static int DoubleNumber(int x) {
        return x * 2;
    }

    public static boolean IsNumberEven(int x) {
        if (x % 2 == 0) {
            System.out.println("The number " + x + " is even");
            return true;
        } else {
            System.out.println("The number " + x + " is odd");
            return false;
        }
    }

    public static void TestIsNumberEven() {
        int x = 2;
        if (IsNumberEven(x)) {
            System.out.println("The number " + x + " is even");
        } else {
            System.out.println("The number " + x + " is odd");
        }
    }

    static String[] testSentence = new String[]{
            "This",
            "is",
            "an",
            "array"
    };

    public static boolean IsWordInSentence(String wordToFind) {
        for (String word : testSentence) {
            if (word.equalsIgnoreCase(wordToFind)) {
                return true;
            }
        }
        return false;
    }

    public void TestIsWordInSentence() {
        assert !MethodChallenges.IsWordInSentence("Hello");
        assert MethodChallenges.IsWordInSentence("is");
        assert MethodChallenges.IsWordInSentence("IS");
    }

    public static int calcSum() {
        String input = "1,2,3,4";

        String[] numbers = input.split(",");

        int sum = 0;

        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }

        System.out.println("The sum of the digits of the number " + input + " is: " + sum);

        return sum;
    }

    public static ArrayList<Integer> GetOdds(int[] intArray) {
        ArrayList<Integer> odds = new ArrayList<>();
        for (var number : intArray) {
            if (number % 2 != 0) {
                odds.add(number);
            }
        }
        return odds;
    }

    public static void TestGetOdds() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var result = GetOdds(intArray);
        System.out.println("Result: ");
        for (int i = 0; i < result.size(); i++) {
            if (i < result.size() - 1) {
                System.out.print(result.get(i) + ",");
            } else {
                System.out.print(result.get(i));
            }
        }
    }


    public static void runCalculator() {
        int userChoice;
        do {
            System.out.println("\n--- James and Roche's Calcumalator ---");
            System.out.println("1. Add");
            System.out.println("2. subtract");
            System.out.println("3. Divide");
            System.out.println("4. Multiply");
            System.out.println("5. Exit");
            userChoice = InputValidator.GetCustomInteger("Choose an option: ",
                    (v) -> v >= 1 && v <= 5,
                    "Must be between 1 and 5");

            if (userChoice >= 1 && userChoice <= 4) {
                int num1 = InputValidator.GetInt("Enter First number: ");
                int num2 = InputValidator.GetInt("Enter second number: ");

                switch (userChoice) {
                    case 1:
                        System.out.println("Result: " + (num1 + num2));
                        break;
                    case 2:
                        System.out.print("Result: " + (num1 - num2));
                        break;
                    case 3:
                        if (num2 != 0) {
                            System.out.println("Result: " + (num1 / num2));
                        } else {
                            System.out.println("Error: cannot divide by zero </3");
                        }
                        break;
                    case 4:
                        System.out.println("Result: " + (num1 * num2));
                        break;
                }
            } else if (userChoice != 5) {
                System.out.println("Invalid option. Try again.");
            }
        } while (userChoice != 5);

        System.out.println("Goodbye. Please come again :)");

    }
}