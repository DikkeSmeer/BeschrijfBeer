import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TotaalPrijsBeerTest {
    @Test
    public void GetBeerPrijs2Opties(){
        Beer beertje = new Beer("Test beertje");

        ArrayList<BeerExtraOpties> opties = new ArrayList<>();
        // voor de test kost elke optie 1 euro
        opties.add(new BeerExtraOpties("optie 1", 1));
        opties.add(new BeerExtraOpties("optie 2", 1));

        beertje.setOptions(opties);

        assertEquals (2, beertje.getPriceTotalBeer(), 0.001);

    }

    @Test
    public void GetBeerPrijs3Opties(){
        Beer beertje = new Beer("Test beertje");

        ArrayList<BeerExtraOpties> opties = new ArrayList<>();
        // voor de test kost elke optie 1 euro
        opties.add(new BeerExtraOpties("optie 1", 1));
        opties.add(new BeerExtraOpties("optie 2", 1));
        opties.add(new BeerExtraOpties("optie 3", 1));

        beertje.setOptions(opties);

        assertEquals (3, beertje.getPriceTotalBeer(), 0.001);

    }

    @Test
    public void GetBeerPrijs4Opties(){
        Beer beertje = new Beer("Test beertje");

        ArrayList<BeerExtraOpties> opties = new ArrayList<>();
        // voor de test kost elke optie 1 euro
        opties.add(new BeerExtraOpties("optie 1", 1));
        opties.add(new BeerExtraOpties("optie 2", 1));
        opties.add(new BeerExtraOpties("optie 3", 1));
        opties.add(new BeerExtraOpties("optie 4", 1));

        beertje.setOptions(opties);

        assertEquals (8, beertje.getPriceTotalBeer(), 0.001);

    }

    @Test
    public void GetBeerPrijs6Opties(){
        Beer beertje = new Beer("Test beertje");

        ArrayList<BeerExtraOpties> opties = new ArrayList<>();
        // voor de test kost elke optie 1 euro
        opties.add(new BeerExtraOpties("optie 1", 1));
        opties.add(new BeerExtraOpties("optie 2", 1));
        opties.add(new BeerExtraOpties("optie 3", 1));
        opties.add(new BeerExtraOpties("optie 4", 1));
        opties.add(new BeerExtraOpties("optie 5", 1));
        opties.add(new BeerExtraOpties("optie 6", 1));

        beertje.setOptions(opties);

        assertEquals (12, beertje.getPriceTotalBeer(), 0.001);
    }
    @Test
    public void GetBeerPrijs7Opties(){
        Beer beertje = new Beer("Test beertje");

        ArrayList<BeerExtraOpties> opties = new ArrayList<>();
        // voor de test kost elke optie 1 euro
        opties.add(new BeerExtraOpties("optie 1", 1));
        opties.add(new BeerExtraOpties("optie 2", 1));
        opties.add(new BeerExtraOpties("optie 3", 1));
        opties.add(new BeerExtraOpties("optie 4", 1));
        opties.add(new BeerExtraOpties("optie 5", 1));
        opties.add(new BeerExtraOpties("optie 6", 1));
        opties.add(new BeerExtraOpties("optie 7", 1));

        beertje.setOptions(opties);

        assertEquals (21, beertje.getPriceTotalBeer(), 0.001);
    }

    @Test
    public void GetBeerPrijs9Opties(){
        Beer beertje = new Beer("Test beertje");

        ArrayList<BeerExtraOpties> opties = new ArrayList<>();
        // voor de test kost elke optie 1 euro
        opties.add(new BeerExtraOpties("optie 1", 1));
        opties.add(new BeerExtraOpties("optie 2", 1));
        opties.add(new BeerExtraOpties("optie 3", 1));
        opties.add(new BeerExtraOpties("optie 4", 1));
        opties.add(new BeerExtraOpties("optie 5", 1));
        opties.add(new BeerExtraOpties("optie 6", 1));
        opties.add(new BeerExtraOpties("optie 7", 1));
        opties.add(new BeerExtraOpties("optie 8", 1));
        opties.add(new BeerExtraOpties("optie 9", 1));

        beertje.setOptions(opties);

        assertEquals (27, beertje.getPriceTotalBeer(), 0.001);
    }

    @Test
    public void GetBeerPrijs20Opties(){
        Beer beertje = new Beer("Test beertje");

        ArrayList<BeerExtraOpties> opties = new ArrayList<>();
        // voor de test kost elke optie 1 euro
        opties.add(new BeerExtraOpties("optie 1", 1));
        opties.add(new BeerExtraOpties("optie 2", 1));
        opties.add(new BeerExtraOpties("optie 3", 1));
        opties.add(new BeerExtraOpties("optie 4", 1));
        opties.add(new BeerExtraOpties("optie 5", 1));
        opties.add(new BeerExtraOpties("optie 6", 1));
        opties.add(new BeerExtraOpties("optie 7", 1));
        opties.add(new BeerExtraOpties("optie 8", 1));
        opties.add(new BeerExtraOpties("optie 9", 1));
        opties.add(new BeerExtraOpties("optie 10", 1));
        opties.add(new BeerExtraOpties("optie 11", 1));
        opties.add(new BeerExtraOpties("optie 12", 1));
        opties.add(new BeerExtraOpties("optie 13", 1));
        opties.add(new BeerExtraOpties("optie 14", 1));
        opties.add(new BeerExtraOpties("optie 15", 1));
        opties.add(new BeerExtraOpties("optie 16", 1));
        opties.add(new BeerExtraOpties("optie 17", 1));
        opties.add(new BeerExtraOpties("optie 18", 1));
        opties.add(new BeerExtraOpties("optie 19", 1));
        opties.add(new BeerExtraOpties("optie 20", 1));

        beertje.setOptions(opties);

        assertEquals (60, beertje.getPriceTotalBeer(), 0.001);
    }
}
