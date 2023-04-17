import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BerenBeschrijvenItemTest {
    @Test
    public void beschrijvingToevoegen() {
        Beer beertje = new Beer("Een test Beertje");

        String beschrijving = "Een test Beschrijving";

        beertje.setDescription(beschrijving);

        assertEquals(beertje.getDescription(), beschrijving);
    }
}