package io.turntabl.tcms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

public class writeToFile extends Tcm {

    private Formatter x;

    public void openFile(){
        try{
        x = new Formatter("clientFile.txt");
    }
        catch (Exception e){
            System.out.println("error");
        }
    }

    public void addDetails() {
        x.format("%s %s%s","DAN", " See"," file" );
    }

    public void closeFile() {
        x.close();
    }






}
