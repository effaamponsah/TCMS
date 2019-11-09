package io.turntabl.tcms;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
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

}
