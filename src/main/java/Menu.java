import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    protected ArrayList<MenuItem> menu = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public int printMenu() {
        int index = 1;
        System.out.println("Kies uw optie:");
        for (MenuItem item : menu) {
            System.out.println(index + ": " + item.getName());
            index++;
        }
        return sc.nextInt();
    }
}
class HoofdMenu extends Menu {
    public void createMenu() {
        // add opties in het menu die een eigen extend hebben - zoals offerte aanmaak menu
        // - OfferteMenu - KlantenMenu - ExtrasMenu
        menu.add(new BerenOverzichtItem("Beren Overzicht"));
        menu.add(new ExitItem("Afsluiten"));


    }

    public void execute(int input) {
        menu.get(input -1 ).execute();
    }
}

// alle sub-menu's die items uitvoeren hieronder
// Templates Sub Menu
class LoginMenu extends Menu {
    public void createMenu() {
        menu.add(new TemplateAanmakenItem("Inloggen"));
        menu.add(new TemplatesBekijkenItem("Registreren"));


        menu.add(new TerugItem("Terug"));
    }
    public void execute(int input) {
        // execute de execute van de mnu item, leest input van de scanner
        menu.get(input-1).execute();
    }
}
// Beren Menu
class BerenOverzichtMenu extends Menu {
    public void createMenu(){
        menu.add(new BeerAanmakenItem("Beer Aanmaken"));
        menu.add(new BerenBekijkenItem("Bestaande beertjes Weergeven"));
        menu.add(new BerenBeschrijvenItem("Beschrijving Aanmaken"));

        menu.add(new TerugItem("Terug"));
    }
    public void execute(int input) {
        // execute de execute van de mnu item, leest input van de scanner
        menu.get(input-1).execute();
    }
}
