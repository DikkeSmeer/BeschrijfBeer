import java.util.ArrayList;

public class Beer {
    private static int id = 0;
    private String name;
    private String description;
    private ArrayList<BeerExtraOpties> options;

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

    // Test beertje options

    public void setOptions(ArrayList<BeerExtraOpties> options){
        this.options = options;
    }
    public int getPriceTotalBeer(){
        int total = 0;
        int extraKosten = 0;

        if (options.size() > 0 && options.size() <= 3){
            extraKosten = 0;
        }

        if (options.size() >= 4 && options.size() <= 6){
            extraKosten = 1;
        }

        if (options.size() >= 7){
            extraKosten = 2;
        }

        for (BeerExtraOpties option : options) {
            total += extraKosten;
            total += option.getOptionPrice();
        }
        return total;
    }

    public boolean isKindvriendelijk(int size, boolean containsGlassEyes, boolean containsPlastic, boolean machineWashable) {

        // size in cm
        if (size <= 5 || size >= 40) {
            return false; // Niet kindvriendelijk
        }

        if (containsGlassEyes || containsPlastic) {
            return false; // Niet kindvriendelijk
        }

        if (!machineWashable) {
            return false; // Niet kindvriendelijk
        }

        // Als geen van de bovenstaande voorwaarden is voldaan, dan is de beer kindvriendelijk
        return true;
    }
}
