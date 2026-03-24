package ClassesChallenges;

public class Album {
    private String artist;
    private String name;
    private double price;
    private int stockQuantity;

    public Album(String artist, String name, double price, int stockQuantity) {
        this.artist = artist;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
