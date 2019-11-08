package io.turntabl.tcms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataStore {
    private static final String filePath = "clients.csv";

    public static void getAllClients() {
        File file = new File(filePath);
        try{
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String data = inputStream.nextLine();
//                String[] values =data.split(",");
                System.out.println(data);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    }

