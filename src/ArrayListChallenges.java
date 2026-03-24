import JmbUtils.InputValidator;

import java.util.ArrayList;

public final class ArrayListChallenges {

    private static ArrayList<Integer> gameScores = new ArrayList<>();
    private static ArrayList<String> toDoList = new ArrayList<>();
    private static ArrayList<Integer> studentScores = new ArrayList<>();

    public static void Challenge1() {
        gameScores.add(145);
        gameScores.add(89);
        gameScores.add(270);

        PrintAllGameScores();

        int numToEnter = InputValidator.GetCustomInteger(
                "How many scores would you like to enter?",
                (v) -> v >= 0,
                "Must be positive");

        for (int i = 0; i < numToEnter; i++) {
            int newScore = InputValidator.GetInt("Enter a score: ");
            gameScores.add(newScore);
        }

        PrintAllGameScores();
    }

    private static void PrintAllGameScores() {
        System.out.println("Here are the latest scores: ");
        for (var score : gameScores) {
            System.out.println(score);
        }
    }

    private static void PrintAllStudentScores() {
        System.out.println("The students' scores are: ");
        for (var score : studentScores) {
            System.out.println(score);
        }
    }

    private static void PrintAllStudentScoresIndexed() {
        System.out.println("The students' scores are: ");
        for (int i = 0; i < studentScores.size(); i++) {
            System.out.println((i+1) + ": " + studentScores.get(i));
        }
    }

    public static void Challenge2() {
        int numToEnter = InputValidator.GetCustomInteger(
                "How many items would you like to add to your to do list?",
                (v) -> v >= 0,
                "Must be positive");

        for (int i = 0; i < numToEnter; i++) {
            String newTask = InputValidator.GetString("Enter a task: ");
            toDoList.add(newTask);
        }

        PrintAllTodos();
    }

    private static void PrintAllTodos() {
        System.out.println("Here is your todo list: ");
        for (var toDo : toDoList) {
            System.out.println(toDo);
        }
    }

    private static void PrintAllTodosIndexed() {
        System.out.println("Here is your todo list: ");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i+1) + ": " + toDoList.get(i));
        }
    }

    public static void Challenge3() {
        int numToEnter = InputValidator.GetCustomInteger(
                "How many scores would you like to enter?",
                (v) -> v >= 0,
                "Must be positive");

        for (int i = 0; i < numToEnter; i++) {
            int newScore = InputValidator.GetInt("Enter a score: ");
            studentScores.add(newScore);
        }

        if (!studentScores.isEmpty()) {
            studentScores.set(0, 75);
        }

        PrintAllStudentScores();
    }

    public static void Challenge2Extended() {
        int numToEnter = InputValidator.GetCustomInteger(
                "How many items would you like to add to your to do list?",
                (v) -> v >= 0,
                "Must be positive");

        for (int i = 0; i < numToEnter; i++) {
            String newTask = InputValidator.GetString("Enter a task: ");
            toDoList.add(newTask);
        }

        boolean exiting = false;
        do {
            int userChoice = InputValidator.GetCustomInteger(
                    "Please enter a choice from the following\n 1: Display list\n 2: Add new item to list\n 3: Remove task from list\n 4: Exit",
                    (v) -> v == 1 || v == 2 || v == 3 || v == 4,
                    "Must be a valid choice (1, 2, 3 or 4)");

            switch (userChoice) {
                case 1 -> PrintAllTodos();
                case 2 -> PromptUserAddNewTask();
                case 3 -> PromptUserHowRemoveTasks();
                case 4 -> exiting = true;
            }
        } while (!exiting);
    }

    private static void PromptUserHowRemoveTasks() {
        int userChoice = InputValidator.GetCustomInteger(
                "Please enter a choice from the following\n 1: Clear all items from list\n 2: Remove specific item",
                (v) -> v == 1 || v == 2,
                "Must be a valid choice (1 or 2)");

        switch (userChoice) {
            case 1 -> ClearToDoList();
            case 2 -> PromptUserRemoveSpecificTask();
        }
    }

    private static void PromptUserAddNewTask() {
        String newTask = InputValidator.GetString("Enter your new task");
        toDoList.add(newTask);
    }

    private static void ClearToDoList() {
        toDoList.clear();
        System.out.println("Your todo list has been cleared");
    }

    private static void PromptUserRemoveSpecificTask() {
        PrintAllTodosIndexed();
        var userChoice = InputValidator.GetCustomInteger(
                "Which index would you like to remove?",
                (v) -> v >= 1 && v < toDoList.size()+1,
                "Must be between 1 and " + toDoList.size());
        userChoice-=1;
        RemoveTaskFromList(userChoice);
    }

    private static void RemoveTaskFromList(int taskToRemove) {
        System.out.println("Removing from list: " + toDoList.get(taskToRemove));
        toDoList.remove(taskToRemove);
    }

    public static void Challenge3Extended() {
        int numToEnter = InputValidator.GetCustomInteger(
                "How many scores would you like to enter?",
                (v) -> v > 0,
                "Must be positive");

        for (int i = 0; i < numToEnter; i++) {
            int newScore = InputValidator.GetInt("Enter a score: ");
            studentScores.add(newScore);
        }

        PrintAllStudentScoresIndexed();

        int userChoice = InputValidator.GetCustomInteger(
                "What number would you like to change?",
                (v) -> v >= 1 && v < studentScores.size(),
                "Must be between 1 and " + studentScores.size());
        userChoice -= 1;

        int newScore = InputValidator.GetInt("What is the new score?");

        studentScores.set(userChoice, newScore);

        PrintAllStudentScoresIndexed();
    }
}
