import java.util.HashMap;

public class Option {
    String choice;
    String name;
    Double x;
    Double a;
    public static Option option = new Option();
    public static ATM aTM = new ATM();
    HashMap<String, Double> account = new HashMap<>();

    public void chooseOption() {
        account.put("Keith", 100.50);
        account.put("Ben", 15.75);
        account.put("Daniel", 30.10);
        System.out.println("Hello, what is your name?");
        name = ATM.scanner.nextLine();
        x = account.get(name);
    }
        public void chooseName() {
            System.out.println("Please choose one of the following options");
            System.out.println("----------------------------");
            System.out.println("| [1] view account balance |");
            System.out.println("| [2] to make a deposit    |");
            System.out.println("| [3] to withdraw          |");
            System.out.println("| [4] to cancel            |");
            System.out.println("--------------------------- ");
            choice = ATM.scanner.nextLine();

            if (choice.equalsIgnoreCase("1")) {
                System.out.println("Hello you have $" + a);
                aTM.answer();
            } if (choice.equalsIgnoreCase("2")) {
                System.out.println("How much would you like to deposit?");
                String deposit = ATM.scanner.nextLine();
                Integer newDeposit = Integer.valueOf(deposit);
                a = (x + newDeposit);
                account.put(name, a);
                System.out.println(("You have added $") + deposit + (" to your account. Your new balance is $") + (a));
                aTM.answer();
            } if (choice.equalsIgnoreCase("3")) {
                System.out.println("How much would you like to withdraw?");
                String withdraw = ATM.scanner.nextLine();
                Integer newWithdraw = Integer.valueOf(withdraw);
                {
                    if (newWithdraw > x) {
                        System.out.println("You don't have enough money bro! Go Home!");
                        aTM.answer();
                    } else if (newWithdraw < x) {
                        a = (x - newWithdraw);
                        account.put(name, a);
                        System.out.println("You withdrew $" + newWithdraw + ". You're current balance is $" + (a));
                        aTM.answer();
                    }
                }
            } if (choice.equalsIgnoreCase("4")) {
                option.end();
                System.exit(0);
            }
    }
    public void end() {
        System.out.println("Goodbye, sweetheart");
    }
}
