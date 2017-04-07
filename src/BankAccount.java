import java.util.HashMap;

public class BankAccount {
    String selection;
    String account;
    Double currentMoney;
    public static BankAccount bankAccount = new BankAccount();
    public static ATM aTM = new ATM();
    HashMap<String, Double> bank = new HashMap<>();

    public void account() {
        bank.put("Keith", 100.50);
        bank.put("Ben", 15.75);
        bank.put("Daniel", 30.10);
        System.out.println("Hello, what is your account?");
        account = ATM.scanner.nextLine();
    }
        public void selectedOption() {
            System.out.println("Please choose one of the following options");
            System.out.println("[1] view bank balance");
            System.out.println("[2] to make a deposit");
            System.out.println("[3] to withdraw");
            System.out.println("[4] to cancel");

            selection = ATM.scanner.nextLine();

            if (selection.equalsIgnoreCase("1")) {
                System.out.println("Hello you have $" + currentMoney);
                aTM.toExit();

            } if (selection.equalsIgnoreCase("2")) {
                System.out.println("How much would you like to deposit?");
                String deposit = ATM.scanner.nextLine();
                Integer depositAmount = Integer.valueOf(deposit);
                currentMoney = (bank.get(account) + depositAmount);
                bank.put(account, currentMoney);
                System.out.println(("You have added $") + deposit + (" to your bank. Your new balance is $") + (currentMoney));
                aTM.toExit();

            } if (selection.equalsIgnoreCase("3")) {
                currentMoney = bank.get(account);
                System.out.println("How much would you like to withdraw?");
                String withdraw = ATM.scanner.nextLine();
                Integer withdrawAmount = Integer.valueOf(withdraw);
                {
                    if (withdrawAmount > currentMoney) {
                        System.out.println("You don't have enough money bro! Go Home!");
                        aTM.toExit();
                    } else if (withdrawAmount < currentMoney) {
                        currentMoney = (currentMoney - withdrawAmount);
                        bank.put(account, currentMoney);
                        System.out.println("You withdrew $" + withdrawAmount + ". You're current balance is $" + (currentMoney));
                        aTM.toExit();
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
