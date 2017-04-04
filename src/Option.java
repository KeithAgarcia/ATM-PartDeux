
public class Option {
    String choice;
    String choiceTwo;

    public void chooseOption() {
        System.out.println("Please choose one of the following options");
        System.out.println("Press 1 to view account balance");
        System.out.println("Press 2 to make a deposit");
        System.out.println("Press 3 to withdraw");
        System.out.println("Press 4 to cancel");

        choice = ATM.scanner.nextLine();

        if (choice.equalsIgnoreCase("1")) {
            System.out.println("You have $100");
        }
        else if (choice.equalsIgnoreCase("2")){
            System.out.println("How much would you like to deposit?");
            String deposit = ATM.scanner.nextLine();
            Integer newDeposit = Integer.valueOf(deposit);
            System.out.println(("You have added $") + deposit + (" to your account. Your new balance is $") + (100 + newDeposit));
        }
        else if (choice.equalsIgnoreCase("3")) {
            System.out.println("How much would you like to withdraw?");
            String withdraw = ATM.scanner.nextLine();
            Integer newWithdraw = Integer.valueOf(withdraw);
            {
                if (newWithdraw > 100) {
                    System.out.println("You don't have enough money bro! Go Home!");
                }
                else if (newWithdraw < 100) {
                    System.out.println("You withdrew $" + newWithdraw + ". You're current balance is $" + (100 - newWithdraw));
                }
            }
        }
        else if (choice.equalsIgnoreCase("4")) {
            System.out.println("Thank you and have a great day!");
        }
    }

    public void answer(){
        System.out.println("Would you like to make another transaction? [y/n]");
        choiceTwo = ATM.scanner.nextLine();

        if (choiceTwo.equalsIgnoreCase("y")){
            chooseOption();
        }
        if (choiceTwo.equalsIgnoreCase("n")){
            System.out.println("Thank you! Have a nice day!");
        }
    }
}
