import java.util.ArrayList;

public class Beer {
    private static int id = 0;
    private String name;
    private String description;
    private ArrayList<BeerExtraInformatie> options;

    // constructor
    public Beer(String name) {
        this.id = id += 1;
        this.name = name;
        this.description = "nog blanko";
    }

    // Getters and Setters

    // ID
    public int getID() {
        return id;
    }

    // Name
    public String getName() {
        return name;
    }

    // Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Template Options
    public ArrayList<BeerExtraInformatie> getOptions() {
        return options;
    }
    public void setOptions(ArrayList<BeerExtraInformatie> options) {
        this.options = options;
    }
}
