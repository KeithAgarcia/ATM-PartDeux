import java.util.HashMap;

public class BankAccount {
    String selection;
    String accountName;
    Double currentMoney;
    String addAccount;
    String addMoney;

    public static BankAccount bankAccount = new BankAccount();
    public static ATM aTM = new ATM();
    HashMap<String, Double> customers = new HashMap<>();

    public void account() {
        customers.put("Keith", 100.50);//string is key in hashmap
        customers.put("Ben", 15.75);
        customers.put("Daniel", 30.10);
        System.out.println("Hello, what is your name");
        accountName = ATM.scanner.nextLine();
        currentMoney = (customers.get(accountName));

        if (customers.containsKey(accountName)) {
        }
        else if (!customers.containsKey(accountName)){
            System.out.println("Would you like to add an account? [y/n]");
            addAccount = ATM.scanner.nextLine();
            if (addAccount.equalsIgnoreCase("y")){
                System.out.println("How much money would you like to deposit?");
                addMoney =ATM.scanner.nextLine();
                Double currentMoney = Double.valueOf(addMoney);
                addAccount = accountName;
                customers.put(accountName, currentMoney);
            }
            if(addAccount.equalsIgnoreCase("n")) {
                bankAccount.end();
                System.exit(0);
            }
        }
    }
        public void selectedOption() {
            currentMoney = (customers.get(accountName));
            System.out.println("Please choose one of the following options");
            System.out.println("[1] view balance");
            System.out.println("[2] to make a deposit");
            System.out.println("[3] to withdraw");
            System.out.println("[4] to cancel");
            selection = ATM.scanner.nextLine();

            if (selection.equalsIgnoreCase("1")) {
                System.out.println("Hello you have $" + currentMoney);
                aTM.askToExit();

            } if (selection.equalsIgnoreCase("2")) {
                System.out.println("How much would you like to deposit?");
                String deposit = ATM.scanner.nextLine();
                Integer depositAmount = Integer.valueOf(deposit);
                currentMoney = (customers.get(accountName) + depositAmount);
                customers.put(accountName, currentMoney);
                System.out.println(("You have added $") + deposit + (" to your customerList. Your new balance is $") + (currentMoney));
                aTM.askToExit();

            } if (selection.equalsIgnoreCase("3")) {
                currentMoney = customers.get(accountName);
                System.out.println("How much would you like to withdraw?");
                String withdraw = ATM.scanner.nextLine();
                Integer withdrawAmount = Integer.valueOf(withdraw);
                {
                    if (withdrawAmount > currentMoney) {
                        System.out.println("You don't have enough money bro! Go Home!");
                        aTM.askToExit();
                    } else if (withdrawAmount < currentMoney) {
                        currentMoney = (currentMoney - withdrawAmount);
                        customers.put(accountName, currentMoney);
                        System.out.println("You withdrew $" + withdrawAmount + ". You're current balance is $" + (currentMoney));
                        aTM.askToExit();
                    }
                }
            } if (selection.equalsIgnoreCase("4")) {
                bankAccount.end();
                System.exit(0);
            }
    }
    public void end() {
        System.out.println("Goodbye, sweetheart");
    }
}
