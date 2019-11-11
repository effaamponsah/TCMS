package io.turntabl.tcms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class DataStore {
    private static final String filePath = "clients.csv";


    public static void getAllClients() {
        File file = new File(filePath);
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
    }

    public static void deleteClients(String id) {

        File file = new File(filePath);
/*
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
*/
        //Delete a Client
        //Code goes here

        File tempFile = new File("temp.csv");

       String idToDelete = id;



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
    }
}

