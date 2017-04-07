import java.util.HashMap;

/**
 * Created by Keith on 4/4/17.
 */
public class Customer {
    String name;
    String customer;
    Double x;

    HashMap <String, Double> account = new HashMap<>();

    public void chooseName(){
        System.out.println("Hello, what is your accountName?");
        Customer customer = new Customer();
        account.put("Keith", 100.50);
        account.put("Ben", 15.75);
        account.put("Daniel", 30.10);

        name = ATM.scanner.nextLine();
        x = account.get(name);

        System.out.println("You have $" + x);
    }
}
