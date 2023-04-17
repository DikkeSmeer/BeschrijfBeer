import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BeerAanmakenItemTest {
    @Test
    public void beerAanmaken() {
        // voeg een beertje toe met een random naam, voor gemak gebruik ik een math random en zet dit om naar een string
        double random = Math.random();
        String name = String.valueOf(random);

        Beer beertje = new Beer(name);

        System.out.println(beertje.getName());

        assertEquals(beertje.getName(), name);
    }

}