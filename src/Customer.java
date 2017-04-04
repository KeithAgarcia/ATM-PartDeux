import java.util.HashMap;

/**
 * Created by Keith on 4/4/17.
 */
public class Customer {
    String name;
    HashMap <String, Double> accounts = new HashMap<>();


    public void chooseName() {
        accounts.put("Ben", 100.00);

        System.out.println("What is your name?");
        name = ATM.scanner.nextLine();
        System.out.println("Welcome, " + name + ("!"));
    }

}
