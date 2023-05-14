import java.util.ArrayList;
import java.util.List;

// java Pattern import - used for regular expressions
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAuth {
    private ArrayList<User> registeredUsers;

    // data loader toepassen om alle gebruikers toe te voegen
    public UserAuth() {
        this.registeredUsers = new ArrayList<User>();
    }

    // simple register
    public boolean register(String username, String password, String confirmPassword, String email) {
        // check 1 - password
        if (!password.equals(confirmPassword)) {
            System.out.println("[" + password + "] and [" + confirmPassword + "] are not the same.");
            return false; // Password is not the same as confirm password
        }

        // check 2 - password
        boolean passwordIsValid = isValidPassword(password);
        if (!passwordIsValid) {
            System.out.println(password + " is an invalid password.");
            return false;
        }
        // check 3 - email
        boolean emailIsValid = isValidEmail(email);
        if (!emailIsValid) {
            System.out.println(email + " is an invalid email address.");
            return false;
        }

        // backend saving - no need for testing the save method
        User newUser = new User(username, password, email);
        this.registeredUsers.add(newUser);

        System.out.println("All checks succeeded - User is added");
        return true; // Successfully registered - User toegevoegd - Object saver toepassen om de gebruiker volledig op te slaan?
    }
    // login functie, geeft een boolean terug die kan worden gebruikt als een 'isLoggedIn' variable - ergens?
    public boolean login(String username, String password) {
        for (User user : this.registeredUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Successfully logged in
            }
        }
        return false; // Username or password is incorrect
    }

    public static boolean isValidEmail(String email) {
        // pattern begins checking between the ^ and $
        // pattern allows a word combination and allows a dot (some emails have an extra dot before the @ (our school email as example)
        // pattern must include an @ with a word after it and must contain a dot folowed by a word after that is between 2 and 4 chars

        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        // look ahead - search for atleast 1 number
        // look ahead - search for atleast one lower case and one uppercase
        // look ahead - search for atleast one special char [@#$%^&+=!]
        // look ahead - contains no whitespaces
        // look ahead - is atleast 8 chars long
        Pattern pattern = Pattern.compile(
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"
        );
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void loadUsers() {
        ObjectLoader<User> loadUsers = new ObjectLoader<>(User.class, "UserDatabase.json");
        List<User> listOfUsers = loadUsers.loadObjects();

        this.registeredUsers = new ArrayList<User>(listOfUsers);
    }

    public void saveUsers() {
        //this.registeredUsers -> save naar de database
        ObjectSaver<User> userSaver = new ObjectSaver<>("UserDatabase.json");
        userSaver.saveObjects(this.registeredUsers);
    }

}
