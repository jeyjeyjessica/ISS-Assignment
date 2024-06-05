package package_example2;

public class FantasyNovel implements Fiction {
    private String name;
    private double rating;

    public FantasyNovel(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getRating() {
        return rating;
    }
}

