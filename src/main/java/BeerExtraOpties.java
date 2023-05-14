public class BeerExtraOpties {
    private String optionName;
    private int optionPrice;

    public BeerExtraOpties(String name, int prijs) {
        this.optionName = name;
        this.optionPrice = prijs;
    }

    public int getOptionPrice() {
        return optionPrice;
    }
}
