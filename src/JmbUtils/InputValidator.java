package JmbUtils;

import java.util.Scanner;

/*public class JmbUtils.InputValidator<T> {
    public T Get(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if ()
    }
}*/

public final class InputValidator {
    private static Scanner scanner;

    public InputValidator() {
        scanner = new Scanner(System.in);
    }

    public static void Validate() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static int GetInt(String message) {
        Validate();
        System.out.println(message);
//        String userInput;
//        int cleanUserInput;
        while (true) {
//            userInput = scanner.nextLine();
            try {
                return Integer.parseInt(scanner.nextLine());
//                break;
            } catch (Exception e) {
                System.out.println("Must be int");
            }
        }
//        return cleanUserInput;
    }

    public static double GetDouble(String message) {
        Validate();

        System.out.println(message);
        String userInput;
        double cleanUserInput;
        while (true) {
            userInput = scanner.nextLine();
            try {
                cleanUserInput = Double.parseDouble(userInput);
                break;
            } catch (Exception e) {
                System.out.println("Must be double");
            }
        }
        return cleanUserInput;
    }

    public static char GetChar(String message) {
        Validate();

        System.out.println(message);
        String userInput;
        char cleanUserInput;
        while (true) {
            userInput = scanner.nextLine();
            try {
                if (userInput.length() > 1) {
                    throw new Exception();
                }
                cleanUserInput = userInput.charAt(0);
                break;
            } catch (Exception e) {
                System.out.println("Must be a single character");
            }
        }
        return cleanUserInput;
    }

    public static boolean GetBool(String message) {
        Validate();

        System.out.println(message);
        String userInput;
        boolean cleanUserInput;
        while (true) {
            userInput = scanner.nextLine();
            try {
                cleanUserInput = Boolean.parseBoolean(userInput);
                break;
            } catch (Exception e) {
                System.out.println("Must be int");
            }
        }
        return cleanUserInput;
    }

    public static String GetString(String message) {
        Validate();

        System.out.println(message);
        String userInput = scanner.nextLine();;
        return userInput;
    }

    public static int GetCustomInteger(String message, CheckInt validationFunc) {
        Validate();
        System.out.println(message);
        String userInput;
        int cleanUserInput;
        while (true) {
            userInput = scanner.nextLine();
            try {
                cleanUserInput = Integer.parseInt(userInput);
                if (!validationFunc.Check(cleanUserInput)) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Must be int");
            }
        }
        return cleanUserInput;
    }

    public static int GetCustomInteger(String message, CheckInt validationFunc, String validationFailedMessage) {
        Validate();
        System.out.println(message);
        String userInput;
        int cleanUserInput;
        while (true) {
            userInput = scanner.nextLine();
            try {
                cleanUserInput = Integer.parseInt(userInput);
                if (!validationFunc.Check(cleanUserInput)) {
                    System.out.println(validationFailedMessage);
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Must be int");
            }
        }
        return cleanUserInput;
    }

    @FunctionalInterface
    public interface CheckInt {
        boolean Check(int value);
    }
}