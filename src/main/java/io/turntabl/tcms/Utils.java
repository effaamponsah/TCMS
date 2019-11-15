package io.turntabl.tcms;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final String dbUrl = "jdbc:h2:./tcms";

    public static int lavenstine(String string1, String string2){
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        int [ ] costs = new int [string2.length()+1];
        for (int j = 0; j<costs.length; j++){
            costs[j] = j;
        }
        for (int i =1; i<=string1.length(); i++){
            costs[0] = i;
            int nw = i-1;
            for (int j =1; j<=string2.length(); j++){
                int cj = Math.min(1 + Math.min(costs[j], costs[j -1]), string1.charAt(i-1) == string2.charAt(j-1) ? nw: nw +1);
                nw = costs[j];
                costs[j]=cj;
            }
        }
        return costs[string2.length()];
    }

    public static List<Client> searchByName(String search) throws ClientNotFoundError {
        List<Client> matching =  readFromFile().stream().filter(client -> lavenstine(firstWord(client.getName()), search) <2).collect(Collectors.toList());
        if (matching.size() != 0){
            return matching;
        }
        else {
            throw new ClientNotFoundError("No client found with that name \n \n");
        }
    }

    public static List<Client> search(String name) throws ClientNotFoundError, ClassNotFoundException {
        List<Client> matchedClients = new ArrayList<>();

        Class.forName("org.h2.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"","")) {
//            Statement s = db.createStatement();
//            ResultSet rs = s.executeQuery("select * from client limit 3;");


            PreparedStatement ps = db.prepareStatement("select * from client where fName like ?;");
            ps.clearParameters();
            ps.setString(1, "%"+name+"%");

            ResultSet rs = ps.executeQuery();
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                    System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
//                    System.out.println();
//                    System.out.println("---------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.format("%5s %17s %15s %10s %15s", rs.getString("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("address"), rs.getString("email"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        } ;

        return matchedClients;
    }

    public static List<Client> readFromFile(){
        List<Client> clients = new ArrayList<>();
        Path path = Paths.get("clients.csv");

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            while(line != null){
                String [] attributes = line.split(",");
                Client client = createClient(attributes);
                clients.add(client);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    private static Client createClient(String[] attributes) {
        String ID = attributes[0];
        String name = attributes[1];
        String phone = attributes[3];
        String email = attributes[4];
        String address = attributes[2];
        return new Client(ID, name,phone,email,address);
    }

    public static String firstWord(String input) {
        String result = "";  // Return empty string if no space found
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ') {
                result = input.substring(0, i);
                break; // because we're done
            }
        }
        return result;
    }
    public static int length() {

        File file = new File("clients.csv");
        int lineNumberCount = 0;

        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                LineNumberReader lr = new LineNumberReader(fr);
                try {
                    while (lr.readLine() != null) {
                        lineNumberCount++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lineNumberCount;
    }

    public static boolean duplicateUser(Client client) throws DuplicateClienException{
                for (Client c : Utils.readFromFile()) {
                    if (c.getName().equals(client.getName())){
                        if (c.getEmail().equals(client.getEmail())){
                            if (c.getPhone().equals(client.getPhone())){
                                if (c.getAddress().equals(client.getAddress())){
                                    throw new DuplicateClienException("Client found with same details aborting operation....");
                                }
                                else {
                                    return false;
                                }
                            }
                            else {
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                }
                    else {
                        return false;
                    }
                }
        return true;
    }
}
