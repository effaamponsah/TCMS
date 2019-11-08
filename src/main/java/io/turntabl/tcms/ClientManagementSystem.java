package io.turntabl.tcms;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;


public class ClientManagementSystem {

    public static void main (String[] args) {
        // declare a variable that will store the client details
        String userInput;

        String clientId;
        String clientName;
        String clientAddress;
        String clientTelephoneNumber;
        String clientEmailAddress;



        //declare a scanner object to read the command line input by user
        Scanner sn = new Scanner(System.in);

        //loop the utility in loop until the user makes the choice to exit
        while(true){
            //Print the options for the user to choose from
            System.out.println("*****Welcome, Sam Moorhouse.*****");

            System.out.println("*****Available Options*****");
            System.out.println("*. Press 1 to Enter User Details.");
            System.out.println("*. Press 2 to View List of Clients.");
            System.out.println("*. Press 3 to Search for a Client");
            System.out.println("*. Press 4 to Delete a User.");
            System.out.println("*. Press 5 to Exit from the application.");
            // Prompt the user to make a choice
            System.out.println("Enter your choice:");

            //Capture the user input in scanner object and store it in a pre declared variable
            userInput = sn.nextLine();

            //Check the user input
            switch(userInput){
                case "1":
                    //Enter Client Details
                    System.out.println("*.Enter Client ID. *");
                    String id = sn.nextLine();

                    System.out.println("*.Enter Client Name. *");
                    String userName = sn.nextLine();

                    System.out.println("*.Enter Client Telephone. *");
                    String phone = sn.nextLine();

                    System.out.println("*.Enter Email Address. *");
                    String email = sn.nextLine();

                    System.out.println("*.Enter Address. *");
                    String address = sn.nextLine();

                    Client newClient = new Client(id, userName, phone, email, address);
                    System.out.println(" Matched clients ");
                    newClient.writeToFile();
                    System.out.println("\n");

                    boolean proceed = Validation.isword(clientEmailAddress=email);
                    while(proceed == false){
                       System.out.println("*.Enter Email Address. *");
                       clientEmailAddress = sn.nextLine();
                       proceed = Validation.isword(clientEmailAddress);
                   }

                   System.out.println("Details saved successfully.");
                    break;
                case "2":
                    DataStore.getAllClients();
                    break;
                case "3":
                    System.out.println("*.Please Enter your clients name*");
                    String searchName = sn.nextLine();
                    try {
                        System.out.println(Utils.searchByName(searchName));
                    } catch (Exception clientNotFound) {
                        System.out.println(clientNotFound.getMessage());
                    }
                    break;
                case "4":
                    //List of Clients
                    String fileName = "clients.csv";
                    File file = new File(fileName);
                    DataStore.getAllClients();

                    //Delete a Client

                    System.out.println("Enter Client by ID to delete");
                    String idToDelete = sn.nextLine();
                    DataStore.deleteClients(idToDelete);
                    System.out.println("Client has been Deleted Successfully");
                    break;
                case "5":
                    //Exit from the application
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    //Inform user in case of invalid choice.
                    System.out.println("Invalid choice. Read the options carefully...");
            }
        }
    }
}