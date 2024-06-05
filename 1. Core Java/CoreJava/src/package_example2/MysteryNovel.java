package package_example2;

public class MysteryNovel implements Fiction {
    private String name;
    private double rating;

    public MysteryNovel(String name, double rating) {
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

