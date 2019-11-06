package io.turntabl.tcms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    // The name of the file to open.
    static String fileName = "myTextFile.txt";

    public static boolean myHelper(String name, String address, String contactNumber, String emailAddress) {

        // This will reference one line at a time
        String line;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //create a token based on
                String [] token=line.split(";");

                // because you know first and second word of each line in given file is user information.

                if (token[0].equals(name) && token[1].equals(address) && token[1].equals(contactNumber) && token[1].equals(emailAddress)){
                    return true;
                }
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ fileName + "'");

            // Or we could just do this:
            // ex.printStackTrace();
        }
        return false;
    }


    public void logging_in(){

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your login information!");

        String [] log_in_array = new String[2];

        String name, address, contactNumber, emailAddress;

        System.out.print("NAME: ");
        name = in.next();

        System.out.print("ADDRESS: ");
        address = in.next();

        System.out.print("TELEPHONE NUMBER: ");
        contactNumber = in.next();

        System.out.print("EMAIL ADDRESS: ");
        emailAddress = in.next();

        //Stores the ID and PASSWORD to the array. Now we will compare the array to the txt file to find a match
        //Must match FIELD_ONE;FIELD_TWO
        log_in_array [0] = name;
        log_in_array [1] = address;
        log_in_array [2] = contactNumber;
        log_in_array [3] = emailAddress;

        // Here you can call your helper method.
        boolean foundMe =myHelper(log_in_array [0], log_in_array [1], log_in_array[2], log_in_array[3]);
        if (foundMe==true){
            //do whatever u want to do
        }

        in.close();

    }


}
