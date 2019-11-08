package io.turntabl.tcms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataStore {
    private static final String filePath = "clients.csv";

    public void getAllClients(){
//        String fileName = "clients.csv";
//        File file = new File(fileName);
        Scanner inputStream = new Scanner(filePath);
        while(inputStream.hasNext()){
            String data = inputStream.nextLine();
            String[] values =data.split(",");
            System.out.println(data);
        }
        inputStream.close();
    }
}
