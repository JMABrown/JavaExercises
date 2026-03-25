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
        this.sourceBuilding = sourceBuilding;
    }

    public String getSourceRoom() {
        return sourceRoom;
    }

    public void setSourceRoom(String sourceRoom) {
        this.sourceRoom = sourceRoom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void printDetails() {
        System.out.println("Source building: " + sourceBuilding);
        System.out.println("Source room: " + sourceRoom);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
    }
}
