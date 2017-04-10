import java.util.HashMap;

public class BankAccount {
    String selection;
    String customerName;
    Double currentMoney;
    String addAccount;
    String addMoney;
    String customerB;
    Double bCurrentMoney;
    Double bMoney;

    public static BankAccount bankAccount = new BankAccount();
    public static ATM aTM = new ATM();
    HashMap<String, Double> customers = new HashMap<>();

    public void account() {
        customers.put("Keith", 100.50);//string is key in hashmap
        customers.put("Ben", 15.75);
        customers.put("Daniel", 30.10);
        System.out.println("Hello, what is your name?");
        customerName = ATM.scanner.nextLine();
        currentMoney = (customers.get(customerName));

        if (customers.containsKey((customerName))) {
        }
        else if (!customers.containsKey(customerName)){
            System.out.println("Would you like to add an account? [y/n]");
            addAccount = ATM.scanner.nextLine();
            if (addAccount.equalsIgnoreCase("y")){
                System.out.println("How much money would you like to deposit?");
                addMoney =ATM.scanner.nextLine();
                Double currentMoney = Double.valueOf(addMoney);
                addAccount = customerName;
                customers.put(customerName, currentMoney);
                selectedOption();
            }
            if(addAccount.equalsIgnoreCase("n")) {
                bankAccount.end();
                System.exit(0);
            }
        }
        selectedOption();
    }
        public void selectedOption() {
            currentMoney = (customers.get(customerName)); //move this up to avoid the redundant options()
            System.out.println("Please choose one of the following options");
            System.out.println("[1] view balance");
            System.out.println("[2] to make a deposit");
            System.out.println("[3] to withdraw");
            System.out.println("[4] to transfer funds" );
            System.out.println("[5] to remove account");
            System.out.println("[6] to cancel");
            selection = ATM.scanner.nextLine();

            if (selection.equalsIgnoreCase("1")) {
                System.out.println("Hello you have $" + currentMoney);
                aTM.askToExit();

            } if (selection.equalsIgnoreCase("2")) {
                System.out.println("How much would you like to deposit?");
                String deposit = ATM.scanner.nextLine();
                Integer depositAmount = Integer.valueOf(deposit);
                if (depositAmount < 0){
                    depositAmount = 0;
                    System.out.println("Incorrect amount entered");
                    System.out.println("");
                    selectedOption();
                }
                currentMoney = (customers.get(customerName) + depositAmount);
                customers.put(customerName, currentMoney);
                System.out.println(("You have added $") + deposit + (" to your account. Your new balance is $") + (currentMoney));
                aTM.askToExit();

            } if (selection.equalsIgnoreCase("3")) {
                currentMoney = customers.get(customerName);
                System.out.println("How much would you like to withdraw?");
                String withdraw = ATM.scanner.nextLine();
                Integer withdrawAmount = Integer.valueOf(withdraw);
                {
                    if (withdrawAmount > currentMoney) {
                        System.out.println("You don't have enough money bro! Go Home!");
                        aTM.askToExit();
                    }
                    if(withdrawAmount < 0){
                        withdrawAmount = 0;
                        System.out.println("Incorrect amount");
                        selectedOption();
                    }
                    else if (withdrawAmount < currentMoney) {
                        currentMoney = (currentMoney - withdrawAmount);
                        customers.put(customerName, currentMoney);
                        System.out.println("You withdrew $" + withdrawAmount + ". You're current balance is $" + (currentMoney));
                        aTM.askToExit();
                    }
                }
            }
            if(selection.equalsIgnoreCase("4")){
                currentMoney = customers.get(customerName);
                System.out.println("Who would you like to transfer funds to?");
                customerB = ATM.scanner.nextLine();
                System.out.println("How much money would you like to transfer?");
                String transfer = ATM.scanner.nextLine();
                Integer transferAmount = Integer.valueOf(transfer);
                if (transferAmount > currentMoney){
                    transferAmount = 0;
                    System.out.println("Incorrect Amount");
                    selectedOption();
                }
                if (transferAmount < 0){
                    transferAmount = 0;
                    System.out.println("Incorrect Amount");
                    selectedOption();
                }
                bMoney= customers.get(customerB);
                bCurrentMoney = bMoney + transferAmount;
                customers.put(customerB, bCurrentMoney);
                System.out.println(customerB + "'s new amount is " + bCurrentMoney);
                currentMoney = (currentMoney - transferAmount);
                customers.put(customerName, currentMoney);
                System.out.println("Your remaining balance is " + currentMoney);
                aTM.askToExit();
            }
            if (selection.equalsIgnoreCase("5")){
                    System.out.println("Adios Amigo!");
                    customers.remove(customerName);
                    account();
                }
                if (selection.equalsIgnoreCase("6")) {
                bankAccount.end();
                account();
            }
    }
    public void end() {
        System.out.println("Goodbye, sweetheart");
        System.out.println("");
        account();
    }
}
