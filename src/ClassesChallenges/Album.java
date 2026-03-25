package ClassesChallenges;

public class Album {
    private String artist;
    private String name;
    private double price;
    private int stockQuantity;

    public Album() {

    };

    public Album(String artist, String name, double price, int stockQuantity) {
        setArtist(artist);
        setName(name);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist == null) {
            throw new IllegalArgumentException("Artist name must not be null");
        }
        if (artist.isEmpty()) {
            throw new IllegalArgumentException("Artist name must not be empty");
        }
        if (artist.matches("\\s+")) {
            throw new IllegalArgumentException("Artists name must contain text");
        }
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

    public void printDetails() {
        System.out.println("Album name: " + name);
        System.out.println("Artist: " + artist);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stockQuantity);
    }
}
