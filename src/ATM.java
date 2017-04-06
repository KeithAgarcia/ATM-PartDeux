import java.util.Scanner;


public class ATM {
    public static Scanner scanner = new Scanner(System.in);
    public static Option option = new Option();
    String choiceTwo;


    public static void main(String[] args) throws Exception {
        option.chooseOption();
        option.chooseName();

    }

    public void answer(){
        System.out.println("Would you like to make another transaction? [y/n]");
        choiceTwo = ATM.scanner.nextLine();

        if (choiceTwo.equalsIgnoreCase("y")){
            option.chooseName();
        }
        if (choiceTwo.equalsIgnoreCase("n")){
            option.end();
            System.exit(0);
        }
    }

}
