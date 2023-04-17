import java.util.List;
import java.util.Scanner;

abstract class MenuItem {
    // een menu item heeft een naam en een execute functie, deze word overwritten per item
    String name;
    public MenuItem(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    public void execute(){};
}

class TemplateOverzichtItem extends MenuItem {
    public TemplateOverzichtItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        TemplateMenu tmenu = new TemplateMenu();
        tmenu.createMenu();
        tmenu.execute(tmenu.printMenu());
    }
}
class BerenOverzichtItem extends MenuItem {
    public BerenOverzichtItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        BerenOverzichtMenu bmenu = new BerenOverzichtMenu();
        bmenu.createMenu();
        bmenu.execute(bmenu.printMenu());
    }
}

class ExitItem extends MenuItem {
    public ExitItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        // Voert de void uit en stopt de 'loop'
    }
}

class TerugItem extends MenuItem {
    public TerugItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        // Niet netjes

        System.out.println("Terug naar HoofdMenu");
        System.out.println("----------------------");
        System.out.println("");

        HoofdMenu menu = new HoofdMenu();
        menu.createMenu();
        menu.execute(menu.printMenu());
    }
}
// beren menu TerugItem
class TerugItemBeren extends MenuItem {
    public TerugItemBeren(String name) {
        super(name);
    }
    @Override
    public void execute() {
        // Niet netjes

        System.out.println("Terug naar BerenMenu");
        System.out.println("----------------------");
        System.out.println("");

        BerenOverzichtMenu menu = new BerenOverzichtMenu();
        menu.createMenu();
        menu.execute(menu.printMenu());
    }
}

//sub menu Items per SubMenu

// Template Overzicht Menu Items
class TemplateAanmakenItem extends MenuItem{
    public TemplateAanmakenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Dit voert de :Template aanmaken: uit.");
    }
}
class TemplatesBekijkenItem extends MenuItem{
    public TemplatesBekijkenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Dit voert de :Templates Overzicht: uit.");
    }
}


// Beer Overzicht Menu Items
class BeerAanmakenItem extends MenuItem{

    // object saver en loader - output: json file (maven package)
    ObjectSaver<Beer> objectSaver = new ObjectSaver<>("BerenDatabase.json");
    ObjectLoader<Beer> objectLoader = new ObjectLoader<>(Beer.class, "BerenDatabase.json");

    public BeerAanmakenItem(String name) {
        super(name);
    }

    public Beer createBeer(String name){
        Beer beer = new Beer(name);

        return beer;
    }

    @Override
    public void execute() {
        System.out.println("Beer aanmaken");

        Scanner sc = new Scanner(System.in);

        System.out.println("------------");
        System.out.println("Geef het beertje een naam:");

        Beer beertje = createBeer(sc.nextLine());

        // Laad de bestaande beren uit het JSON-bestand
        List<Beer> bestaandeBeren = objectLoader.loadObjects();

        // Voeg beertje toe aan de bestaande lijst
        bestaandeBeren.add(beertje);

        // Sla de bijgewerkte lijst met klantgegevens op in het JSON-bestand
        objectSaver.saveObjects(bestaandeBeren);

        System.out.println("Beer aangemaakt en opgeslagen met de naam: [" + beertje.getID() + "] " + beertje.getName());

        MenuItem terug = new TerugItemBeren("Terug naar beren menu");
        terug.execute();
    }
}
class BerenBekijkenItem extends MenuItem{

    // object saver en loader - output: json file (maven package)
    ObjectSaver<Beer> objectSaver = new ObjectSaver<>("BerenDatabase.json");
    ObjectLoader<Beer> objectLoader = new ObjectLoader<>(Beer.class, "BerenDatabase.json");

    List<Beer> alleBeertjes = objectLoader.loadObjects();

    public BerenBekijkenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Alle bestaande beren worden laten zien: \n");

        // TODO: Figure out how i can set the static id for loaded in beertjes / try to save the existing id's
        for (Beer beer : alleBeertjes){
            System.out.println("[ID: " + beer.getID() + "] Naam: " + beer.getName() + " Beschrijving: [" +beer.getDescription() + "]");
        }

        MenuItem terug = new TerugItemBeren("Terug naar beren menu");
        terug.execute();
    }
}

class BerenBeschrijvenItem extends MenuItem{
    // object saver en loader - output: json file (maven package)
    ObjectSaver<Beer> objectSaver = new ObjectSaver<>("BerenDatabase.json");
    ObjectLoader<Beer> objectLoader = new ObjectLoader<>(Beer.class, "BerenDatabase.json");

    List<Beer> alleBeertjes = objectLoader.loadObjects();

    public BerenBeschrijvenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        Beer gekozenBeertje = null;
        boolean beerGevonden = false;
        MenuItem terug = new TerugItemBeren("Terug naar beren menu");

        System.out.println("Dit voert de :Beeren Overzicht: uit.");

        // TODO: Figure out how i can set the static id for loaded in beertjes / try to save the existing id's
        for (Beer beer : alleBeertjes){
            System.out.println("[ID: " + beer.getID() + "] Naam: " + beer.getName() + " Beschrijving: [" +beer.getDescription() + "]");
        }


        System.out.println("\nWelk beertje wil je een beschrijving geven? [vul naam in] ");

        String ingevuldeNaam = sc.nextLine();
        //sc.nextLine(); // Add this line to consume the newline character

        // Search for the Klant object with the entered ID and print its details
        for (Beer objSearch : alleBeertjes) {
            if (objSearch.getName().equals(ingevuldeNaam)) {
                System.out.println("--Beertje gevonden--");
                gekozenBeertje = objSearch;
                beerGevonden = true;
                break;
            }
        }

        if (beerGevonden == false) {
            System.out.println("Er is geen beertje met deze naam - terug naar beren menu");
            terug.execute();
        }

        // vraag om beschrijving
        System.out.println("Geef een beschrijving voor het beertje: " + gekozenBeertje.getName());
        String beschrijving = sc.nextLine();

        gekozenBeertje.setDescription(beschrijving);

        System.out.println("Beschrijving toegevoegd!\n");

        // Save ALLE beertje opnieuw
        for (Beer obj : alleBeertjes) {
            objectSaver.addObject(obj);
        }
        objectSaver.saveObjects();

        terug.execute();
    }
}
