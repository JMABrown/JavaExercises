import JmbUtils.InputValidator;

public final class ArrayChallenges {
    public static void Challenge1() {
        String[] playerNames = new String[2];
        playerNames[0] = InputValidator.GetString("Please enter the name of Player 1: ");
        playerNames[1] = InputValidator.GetString("Please enter the name of Player 2: ");
        System.out.println("Player 1's name is: " + playerNames[0]);
        System.out.println("Player 2's name is: " + playerNames[1]);
    }

    private static final int NUM_SCORES = 5;

    public static void Challenge2() {
        int[] studentScores = new int[NUM_SCORES];
        for (int i = 0; i < NUM_SCORES; i++) {
             studentScores[i] = InputValidator.GetInt("Enter a score for student " + (i+1) + ":");
        }

        for (int i = 0; i < NUM_SCORES; i++) {
            System.out.println("Student " + (i+1) + "'s score is: " + studentScores[i]);
        }
    }
}
