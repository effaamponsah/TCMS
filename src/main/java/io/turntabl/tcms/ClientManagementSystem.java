package io.turntabl.tcms;

import java.util.Scanner;

public class ClientManagementSystem {

    public static void main (String[] args){

        // declare a variable that will store the client details
        String userInput;
        String clientName;
        String clientAddress;
        String clientTelephoneNumber;
        String clientEmailAddress;


        //declare a scanner object to read the command line input by user
        Scanner sn = new Scanner(System.in);

        //loop the utility in loop until the user makes the choice to exit
        while(true){
            //Print the options for the user to choose from
            System.out.println("*****Welcome, Sam Moorehouse.*****");

            System.out.println("*****Available Options*****");
            System.out.println("*. Press 1 to Enter User Details");
            System.out.println("*. Press 2 to Search for a Client");
            System.out.println("*. Press 3 to Delete a User");
            System.out.println("*. Press 4 to Exit from the application");
            // Prompt the user to make a choice
            System.out.println("Enter your choice:");

            //Capture the user input in scanner object and store it in a pre declared variable
            userInput = sn.next();

            //Check the user input
            switch(userInput){
                case "1":
                    //Enter Client Details
                    System.out.println("*.Enter Client Name. *");
                    clientName = sn.next();
                    System.out.println("*.Enter Client Address. *");
                    clientAddress = sn.next();
                    System.out.println("*.Enter Telephone Number. *");
                    clientTelephoneNumber = sn.next();
                    System.out.println("*.Enter Email Address. *");
                    clientEmailAddress = sn.next();
                    System.out.println("Details saved successfully.");
                    break;
                case "2":
                    //Search for a Client
                    System.out.println("Client found or not ...");
                    break;
                case "3":
                    //Delete a Client
                    System.out.println("Client has been Deleted Successfully");
                    break;
                case "4":
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
