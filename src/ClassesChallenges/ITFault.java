package ClassesChallenges;

public class ITFault {
    private String sourceBuilding;
    private String sourceRoom;
    private String type;
    private String description;

    public ITFault(String sourceBuilding, String sourceRoom, String type, String description) {
        this.sourceBuilding = sourceBuilding;
        this.sourceRoom = sourceRoom;
        this.type = type;

        if (description.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.description = description;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Artist name must not be null");
        }
        if (type.isEmpty()) {
            throw new IllegalArgumentException("Artist name must not be empty");
        }
        if (type.matches("\\s+")) {
            throw new IllegalArgumentException("Artists name must contain text");
        }
        this.type = type;
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
}
