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
        if (artist == null) {
            throw new IllegalArgumentException("Artist name must not be null");
        }
        if (artist.isEmpty()) {
            throw new IllegalArgumentException("Artist name must not be empty");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to zero");
        }
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (price < 0) {
            throw new IllegalArgumentException("Stock must be greater than or equal to zero");
        }
        this.stockQuantity = stockQuantity;
    }

    public void printDetails() {
        System.out.println("Album name: " + name);
        System.out.println("Artist: " + artist);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stockQuantity);
    }
}
