import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BerenBekijkenItemTest {
    @Test
    public void giveAllBearsTest(){
        // object saver en loader - output: json file (maven package)
        ObjectSaver<Beer> objectSaver = new ObjectSaver<>("BerenDatabase.json");
        ObjectLoader<Beer> objectLoader = new ObjectLoader<>(Beer.class, "BerenDatabase.json");

        List<Beer> alleBeertjes = objectLoader.loadObjects();

        // TODO: Figure out how i can set the static id for loaded in beertjes / try to save the existing id's
        for (Beer beer : alleBeertjes){
            System.out.println("[ID: " + beer.getID() + "] Naam: " + beer.getName() + " Beschrijving: [" +beer.getDescription() + "]");
        }

    }
}