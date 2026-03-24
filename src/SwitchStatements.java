import JmbUtils.InputValidator;

public class SwitchStatements {
    public static void Task2() {
        var monthInput = InputValidator.GetCustomInteger(
                "Enter 1-12 to represent a month",
                (m)-> m >= 1 && m <= 12,
                "Value must be between 1 and 12");

        var numberOfDays = GetDaysInMonth(monthInput);
        System.out.println("The " + monthInput + " month of the year has " + numberOfDays + " days");
    }

    public static int GetDaysInMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
    }
}
