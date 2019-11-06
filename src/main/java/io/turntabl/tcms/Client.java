package io.turntabl.tcms;

import java.io.FileWriter;
import java.io.IOException;

public class Client extends Tcm{

        private String name;
        private  String phone;
        private String email;
        private String address;


        public Client(String name, String phone, String email, String address) throws IOException {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String nameToWriteToFile(){
            return name;
        }

        public void writeToFile() throws IOException {

            FileWriter f = null;

            try {
                f = new FileWriter("db.csv", true);
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

