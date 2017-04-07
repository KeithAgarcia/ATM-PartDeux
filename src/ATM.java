import java.util.Scanner;


public class ATM {
    public static Scanner scanner = new Scanner(System.in);
    public static BankAccount bankAccount = new BankAccount();
    String anothTransac;

    public static void main(String[] args) throws Exception {
        bankAccount.name();
        bankAccount.selectedOption();
    }

    public void toExit(){
        System.out.println("Would you like to make another transaction? [y/n]");
        anothTransac = ATM.scanner.nextLine();

        if (anothTransac.equalsIgnoreCase("y")){
            bankAccount.name();
        }
        if (anothTransac.equalsIgnoreCase("n")){
            bankAccount.end();
            System.exit(0);
        }
    }

}
