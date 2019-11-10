package io.turntabl.tcms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class ClientManagementSystem {

    public static void main (String[] args) {

        // declare a variable that will store the client details
        String userInput;
        String clientEmailAddress;

        //declare a scanner object to read the command line input by user
        Scanner sn = new Scanner(System.in);

        while(true){
            //Print the options for the user to choose from
            System.out.println("*****Welcome, Sam Moorhouse.*****");

            System.out.println("*****Available Options*****");
            System.out.println("*. Press 1 to Enter User Details");
            System.out.println("*. Press 2 to Search for a Client");
            System.out.println("*. Press 3 to Delete a User");
            System.out.println("*. Press 4 to Exit from the application");

            // Prompt the user to make a choice
            System.out.println("Enter your choice:");

            //Capture the user input in scanner object and store it in a pre declared variable
            userInput = sn.nextLine();

            //Check the user input
            switch(userInput) {
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

                    boolean proceed = Validation.isword(clientEmailAddress = email);
                    while (!proceed) {
                        System.out.println("*.Enter Email Address. *");
                        clientEmailAddress = sn.nextLine();
                        proceed = Validation.isword(clientEmailAddress);
                    }

                    System.out.println("Details saved successfully.");
                    break;
                case "2":
                    System.out.println("*.Please Enter your clients name*");
                    String searchName = sn.nextLine();
                    System.out.println(Utils.searchByName(searchName));
//                   Client searchClient = searchClient.searchClient(1,"Jude");

                    //Search for a Client
//                    System.out.println("Client found or not ...");
                    break;
                case "3":
                    //List of Clients
                    String fileName = "clients.csv";
                    File file = new File(fileName);
                    try {
                        Scanner inputStream = new Scanner(file);
                        while (inputStream.hasNext()) {
                            String data = inputStream.nextLine();
                            System.out.println(data);
                        }
                        inputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    //Delete a Client
                    //Code goes here

                    File tempFile = new File("temp.csv");

                    System.out.println("Enter Client by ID to delete");
                    String idToDelete = sn.nextLine();

                    if( idToDelete != null && idToDelete.length() != 0) {

                        try {

                            PrintWriter out = new PrintWriter(new FileWriter(tempFile));
                            Files.lines(file.toPath())
                                    .filter(line -> !line.contains(idToDelete))
                                    .forEach(out::println);
                            out.flush();
                            out.close();
                            tempFile.renameTo(file);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println("Client has been Deleted Successfully");
                    }else {
                        System.out.println("Empty");
                    }
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