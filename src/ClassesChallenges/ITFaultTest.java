package ClassesChallenges;

import JmbUtils.InputValidator;

public class ITFaultTest {
    public static void RunTest() {
        var sourceBuilding = InputValidator.GetString("In what building did the issue originate?");
        var sourceRoom = InputValidator.GetString("In what room did the issue originate?");
        var issueType = InputValidator.GetString("What type of issue occured?");
        var issueDescription = InputValidator.GetString("Describe the issue: ");

        var studentNumber = InputValidator.GetCustomInteger("absdfansigd",
                v -> v >= 1111 && v <= 9999,
                "oiajsdgjd");

        ITFault fault = new ITFault(sourceBuilding, sourceRoom, issueType, issueDescription);

        System.out.println("The issue has been logged: ");
        fault.printDetails();
    }
}
