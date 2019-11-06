package io.turntabl.tcms;

import com.sun.security.ntlm.Client;
import com.sun.security.ntlm.NTLMException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Tcm {


        public static void main(String[] args) throws IOException, NTLMException {

                Client c = new Client("ffa","reafa","afafa","afassss",'');
                boolean exists = Files.exists(Paths.get("./db.csv"));
                String fileName = "db.csv";
                String line;
                int b = 0;

                Path s = Paths.get(fileName);


                Scanner scanner = new Scanner(System.in);

                String userName = scanner.next();
                String phone = scanner.next();
                String email = scanner.next();
                String address = scanner.next();
                Client newClient = new Client(userName, phone, email, address);
                newClient.writeToFile();



                Scanner sc = new Scanner(new File("./db.csv"));
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                        System.out.print(sc.next());
                }
                sc.close();



                //System.out.println("Enter a search: ");

                File file = new File("./db.csc");

                boolean found = false;

                try

                {
                        Scanner kb = new Scanner(System.in);
                        Scanner input = new Scanner(file);

                        String name = kb.nextLine();


                        while(input.hasNextLine() && found)

                        {

                                System.out.println(input.next(name));
                        }
                }
                catch (Exception e){;}

        }
}