package org.example.ClassesChallenges;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.JmbUtils.InputValidator;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ITFaultCRUD {

    ArrayList<ITFault> faults = new ArrayList<>();

    public void Run() {
        int userChoice;
        Load();
        do {
            userChoice = InputValidator.GetCustomInteger("What would you like to do? (Enter a number)\n" +
                            "1 - View faults\n" +
                            "2 - Record fault\n" +
                            "3 - Update fault\n" +
                            "4 - Delete fault\n" +
                            "5 - Exit",
                    (v) -> v >= 1 && v <= 5);

            switch (userChoice) {
                case 1 -> ViewAllFaults();
                case 2 -> RecordFault();
                case 3 -> UpdateFault();
                case 4 -> DeleteFault();
            }

            Save();
        } while (userChoice != 5);
        System.out.println("Thank you, goodbye");
    }

    public void ViewAllFaults() {
        PrintAllVaultsNumbered();
    }

    private void PrintAllVaultsNumbered() {
        for (int i = 0; i < faults.size(); i++) {
            System.out.println((i+1) + ".");
            faults.get(i).printDetails();
        }
    }

    public void RecordFault() {
        ITFault fault = new ITFault();
        InputValidator.GetValidated(
                () -> InputValidator.GetString("In what building did the problem originate?"),
                fault::setSourceBuilding);

        InputValidator.GetValidated(
                () -> InputValidator.GetString("In what room did the problem originate?"),
                fault::setSourceRoom);

        InputValidator.GetValidated(
                () -> InputValidator.GetString("What is the type of issue? Must be one of the following: " + ITFault.GetAllEnumTypesString()),
                fault::setType);

        InputValidator.GetValidated(
                () -> InputValidator.GetString("Enter fault description"),
                fault::setDescription);

        faults.add(fault);
    }

    public void UpdateFault() {
        System.out.println("Which fault do you wish to update?");
        PrintAllVaultsNumbered();
        var faultIndex = InputValidator.GetCustomInteger("Enter your choice: ",
                (v) -> v >= 1 && v <= faults.size());
        faultIndex--;
        ITFault selectedFault = faults.get(faultIndex);

        var fieldToUpdate = InputValidator.GetCustomInteger("What do you want to update?\n" +
                        "1 - Fault source building\n" +
                        "2 - Fault source room\n" +
                        "3 - Fault type\n" +
                        "4 - Fault description\n" +
                        "5 - Set fault resolved",
                (v) -> v >= 1 && v <= 5);


        switch (fieldToUpdate) {
            case 1 -> InputValidator.GetValidated(() -> InputValidator.GetString("Enter new value"),
                    selectedFault::setSourceBuilding);
            case 2 -> InputValidator.GetValidated(() -> InputValidator.GetString("Enter new value"),
                    selectedFault::setSourceRoom);
            case 3 -> InputValidator.GetValidated(() -> InputValidator.GetString("Enter new value"),
                    selectedFault::setType);
            case 4 -> InputValidator.GetValidated(() -> InputValidator.GetString("Enter new value"),
                    selectedFault::setDescription);
            case 5 -> selectedFault.setResolved(true);
        }
    }

    public void DeleteFault() {
        System.out.println("Which fault do you wish to delete?");
        PrintAllVaultsNumbered();
        var faultIndex = InputValidator.GetCustomInteger("Enter your choice: ",
                (v) -> v >= 1 && v <= faults.size());
        faultIndex--;
        faults.remove(faultIndex);
    }

    public void Load() {
        File appDataDirectory = new File(System.getenv("APPDATA"));
        File appRoot = new File(appDataDirectory, "JmbITFaultsApp");
        File dataDirectory = new File(appRoot, "Data");
        var dataPath = Paths.get(dataDirectory.getPath());

        if (Files.notExists(dataPath)) {
            return;
        }

        var saveFile = dataPath.resolve("save.txt");
        if (Files.notExists(saveFile)) {
            return;
        }

        FileReader reader;
        try {
            reader = new FileReader(saveFile.toAbsolutePath().toString());
            String contents = reader.readAllAsString();
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<ITFault>>(){}.getType();
            faults = gson.fromJson(contents, listType);
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Save() {
        File appDataDirectory = new File(System.getenv("APPDATA"));
        File appRoot = new File(appDataDirectory, "JmbITFaultsApp");
        File dataDirectory = new File(appRoot, "Data");
        var dataPath = Paths.get(dataDirectory.getPath());

        if (Files.notExists(dataPath)) {
            try {
                Files.createDirectories(dataPath);
            } catch (Exception e) {

            }
        }

        var saveFile = dataPath.resolve("save.txt");
        if (Files.notExists(saveFile)) {
            try {
                Files.createFile(saveFile);
            } catch (Exception e) {

            }
        }

        FileWriter writer;
        try {
            writer = new FileWriter(saveFile.toAbsolutePath().toString(), false);
            PrintWriter printer = new PrintWriter(writer);
            Gson gson = new Gson();
            String contents = gson.toJson(faults);
            printer.append(contents);
            printer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
