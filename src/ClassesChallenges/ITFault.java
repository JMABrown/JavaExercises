package ClassesChallenges;

public class ITFault {
    private String sourceBuilding;
    private String sourceRoom;
    private EnumType type;
    private String description;
    private boolean resolved = false;

    public ITFault() {

    };

    public ITFault(String sourceBuilding, String sourceRoom, String type, String description) {
        setSourceBuilding(sourceBuilding);
        setSourceRoom(sourceRoom);
        setType(type);
        setDescription(description);
    }

    public String getSourceBuilding() {
        return sourceBuilding;
    }

    public void setSourceBuilding(String sourceBuilding) {
        if (sourceBuilding == null) {
            throw new IllegalArgumentException("sourceBuilding must not be null");
        }
        if (sourceBuilding.isEmpty()) {
            throw new IllegalArgumentException("sourceBuilding must not be empty");
        }
        if (sourceBuilding.matches("\\s+")) {
            throw new IllegalArgumentException("sourceBuilding must contain text");
        }
        this.sourceBuilding = sourceBuilding;
    }

    public String getSourceRoom() {
        return sourceRoom;
    }

    public void setSourceRoom(String sourceRoom) {
        if (sourceRoom == null) {
            throw new IllegalArgumentException("Source room must not be null");
        }
        if (sourceRoom.isEmpty()) {
            throw new IllegalArgumentException("Source room must not be empty");
        }
        if (sourceRoom.matches("\\s+")) {
            throw new IllegalArgumentException("Source room must contain text");
        }
        this.sourceRoom = sourceRoom;
    }

    public EnumType getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type must not be null");
        }
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Type must not be empty");
        }
        try {
            this.type = EnumType.valueOf(type.toLowerCase());
        } catch (IllegalArgumentException e) {
            String message = "Must enter one of the following: \n";
            message = message.concat(ITFault.GetAllEnumTypesString());
            throw new IllegalArgumentException(message);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 300) {
            throw new IllegalArgumentException("Description must not exceed 300 characters in length");
        }
        this.description = description;
    }

    public void printDetails() {
        System.out.println("Source building: " + sourceBuilding);
        System.out.println("Source room: " + sourceRoom);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
    }

    public static String GetAllEnumTypesString() {
        String message = "";
        for (var value : EnumType.values()) {
            message = message.concat(value + "\n");
        }
        return message;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public enum EnumType {
        hardware,
        software,
        network,
        pebcak;
    }
}
