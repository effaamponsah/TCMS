package io.turntabl.tcms;

import java.io.FileWriter;
import java.io.IOException;

public class Client {

        private String id;
        private String name;
        private  String phone;
        private String email;
        private String address;


        public Client(String id, String name, String phone, String email, String address) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;

    @Override
    public String toString() {
        return "Client Details:  " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                "\n";
    }

    public void writeToFile() {

            FileWriter f = null;

            try {
                f = new FileWriter("clients.csv", true);
                f.append(id);
                f.append(",");
                f.append(name);
                f.append(",");
                f.append(address);
                f.append(",");
                f.append(phone);
                f.append(",");
                f.append(email);
                f.append("\n");

            }
            catch (Exception e ){
                e.printStackTrace();
            }
            finally {
                try{
                    if (f != null){
                        if (f !=null) {
                            f.flush();
                            f.close();
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

