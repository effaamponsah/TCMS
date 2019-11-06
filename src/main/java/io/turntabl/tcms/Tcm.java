package io.turntabl.tcms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Tcm {



        public static void main(String[] args) {
                final Formatter x;


        writeToFile g = new writeToFile();
        g.openFile();
        g.addDetails();
        g.closeFile();


        Scanner myObj = new Scanner(System.in);
        String clientName;

        System.out.println("Enter username");
        clientName = myObj.nextLine();

        System.out.println("Username is " + clientName);

        }


}
