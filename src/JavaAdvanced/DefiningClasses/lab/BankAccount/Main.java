package JavaAdvanced.DefiningClasses.lab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Map<Integer,Integer> accounts = new HashMap<>();
        while (!input[0].equals("End")) {
            switch (input[0]) {
                case "Create" :

                    break;
                case "Deposit" :
                    break;
                case "SetInterest" :
                    break;
                case "GetInterest" :
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }

    }
}
