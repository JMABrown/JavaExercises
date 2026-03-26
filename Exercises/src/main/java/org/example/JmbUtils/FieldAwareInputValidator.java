package org.example.JmbUtils;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FieldAwareInputValidator {

    private static Scanner scanner;

    public FieldAwareInputValidator() {
        scanner = new Scanner(System.in);
    }

    public static void ValidateSelf() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static <T> T GetValidated(Supplier<T> getter, Consumer<T> validator) {
        while (true) {
            try {
                T value = getter.get();
                validator.accept(value);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
    }

    public static String GetNonEmptyString() throws InputValidationException {
        ValidateSelf();

        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            throw new InputValidationException("Must not be empty");
        }
        return userInput;
    }

    public static class InputValidationException extends RuntimeException {
        public InputValidationException(String message) { super(message); }
    }
}
