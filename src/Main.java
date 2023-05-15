import Exceptions.DataException;
import Exceptions.LoginException;
import Models.*;

import javax.xml.crypto.Data;
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
                        user = new Agent(firstName,lastName, email, 2300);
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
                System.out.println("7. List all contracts");
                System.out.println("8. Publish a new residence");
            }
            else{
                System.out.println("6. Buy a residence");
                System.out.println("7. Add money to wallet");
            }
            System.out.println("0. Exit");

            Integer op = Integer.valueOf(scanner.next());

            if(user instanceof Client) op += 3;

            switch (op) {
                case 0 -> exit = true;
                case 1 -> System.out.println(service.getResidenceMap());
                case 2 -> {
                    System.out.println("Which type of residence do you want to list?");
                    System.out.println("1.Houses");
                    System.out.println("2.Apartments");
                    System.out.println("3.Penthouses");

                    Integer type = Integer.valueOf(scanner.next());
                    switch (type) {
                        case 1 -> {
                            try {
                                System.out.println(service.getHouses());
                            }
                            catch(DataException e){
                                System.out.println(e.getMessage());
                            }
                        }
                        case 2 -> {
                            try{
                                System.out.println(service.getApartments());
                            }
                            catch(DataException e){
                                System.out.println(e.getMessage());
                            }
                        }
                        case 3 -> {
                            try {
                                System.out.println(service.getPenthouses());
                            }
                            catch(DataException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                 }
                 case 3 -> {
                    try{
                        System.out.println(service.getAgentsList());
                    }
                    catch (DataException e){
                        System.out.println(e.getMessage());
                    }
                 }
                 case 4 -> System.out.println(user);
                 case 5 -> {
                     System.out.println("Type your new email address");
                     String email = scanner.nextLine();
                     user.setEmail(email);
                     System.out.println("Email updated succesfully");
                 }
                 case 6 ->{
                     try{
                         System.out.println(service.getClientsList());
                     }
                     catch (DataException e){
                         System.out.println(e.getMessage());
                     }
                 }
                 case 7 ->{
                     try{
                         System.out.println(service.getContractsList());
                     }
                     catch (DataException e){
                         System.out.println(e.getMessage());
                     }
                 }
                 case 8 ->{
                     System.out.println("Please fill the next form.");
                     Residence newResidence = null;
                     System.out.println("Type of residence.");
                     System.out.println("\t1.House\t2.Apartment\t3.Penthouse");
                     Integer type = Integer.valueOf(scanner.nextLine());
                     System.out.println("Residence Address:");
                     String address = scanner.nextLine();
                     System.out.println("Area:");
                     Integer area = Integer.valueOf(scanner.nextLine());
                     System.out.println("Price");
                     Integer price = Integer.valueOf(scanner.nextLine());
                     switch (type) {
                         case 1 ->{
                             System.out.println("Garden area:");
                             Integer gardenArea = Integer.valueOf(scanner.nextLine());
                             newResidence = new House(address,area,price,gardenArea);
                         }
                     }

                 }
                 case 9 ->{

                 }
                 case 10 ->{

                 }
            }
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }
}