import java.util.Scanner;

public class ATM {
    public static Scanner scanner = new Scanner(System.in);
    public static Option option = new Option();
    public static Customer customer = new Customer();

    public static void main(String[] args) throws Exception {
        customer.chooseName();
        option.chooseOption();
        option.answer();
    }
}
