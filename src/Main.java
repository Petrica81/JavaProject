import Exceptions.LoginException;
import Models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var service = Agency.getInstance();
        service.init();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have an account?: (Y/N)");
        var rasp =scanner.next();
        String firstName = "", lastName = "";
        User user = null;

        switch (rasp){
            case "Y","y" -> {
                System.out.println("Enter your first name:");
                firstName = scanner.next();
                System.out.println("Enter your last name:");
                lastName = scanner.next();
                System.out.println("You are logging in as:\n1.Client\n2.Agent");
                Integer tip = Integer.valueOf(scanner.next());
                switch (tip){
                    case 1 -> {
                        try{
                            user = service.clientLogin(firstName,lastName);
                            System.out.println("Succesful login as client!");
                        }
                        catch (LoginException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 2 -> {
                        try{
                            user = service.agentLogin(firstName,lastName);
                            System.out.println("Succesful login as agent!");
                        }
                        catch (LoginException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    default -> {
                        System.out.println("Invalid selection1");
                        System.exit(0);
                    }
                }
            }
            case "N","n" -> {
                System.out.println("Enter your first name:");
                firstName = scanner.next();
                System.out.println("Enter your last name:");
                lastName = scanner.next();
                System.out.println("Enter your email:");
                String email = scanner.next();
                System.out.println("You are registering in as:\n1.Client\n2.Agent");
                Integer tip = Integer.valueOf(scanner.next());
                switch (tip) {
                    case 1 -> {
                        user = new Client(firstName,lastName, email, 0);
                        service.addUser(user);
                    }
                    case 2 -> {
                        user = new Agent(firstName,lastName, email, 0);
                        service.addUser(user);
                    }
                    default -> {
                        System.out.println("Invalid selection!");
                        System.exit(0);
                    }
                }
                System.out.println("Succesful register!\n");
            }
            default -> {
                System.out.println("Invalid selection!");
                System.exit(0);
            }
        }

        if(user instanceof Client) System.out.println("Welcome to your helper to get a new house!\nn");
        else System.out.println("Today is your day to sell a house!\n");

        boolean exit = false;

        while(!exit){
            System.out.println("Select your operation:\n");
            System.out.println("1. List all residences");
            System.out.println("2. List specific residences");
            System.out.println("3. List all agents");
            System.out.println("4. View your data");
            System.out.println("5. Change my account email");

            if(user instanceof Agent){
                System.out.println("6. List all clients");
                System.out.println("7. Publish a new residence");
            }
            else{
                System.out.println("6. Buy a residence");
                System.out.println("7. Add money to wallet");
            }
            var op = scanner.next();
        }
    }
}