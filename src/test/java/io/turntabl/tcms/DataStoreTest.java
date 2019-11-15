package io.turntabl.tcms;

import org.h2.util.ScriptReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
//import com.ibatis.common.jdbc.ScriptRunner;
import static org.junit.Assert.*;

public class DataStoreTest {
    private static final String dbUrl = "jdbc:h2:tcms";
    private static final String testScriptPath = "testscript.sql";

    @Test
    public void testInMemoryDb() throws ClassNotFoundException {
        BufferedReader reader = null;
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(dbUrl, "", "")) {

            Statement s = db.createStatement();
            reader = new BufferedReader(new FileReader(testScriptPath));

            String line = null;
            while ((line = reader.readLine()) != null) {
                s.execute(line);
            }
//                ResultSet rs = s.executeQuery("select * from customers limit 3;");
//                System.out.println("---------------------------------------------------------------------------------------------");
//                System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
//                System.out.println();
//                System.out.println("---------------------------------------------------------------------------------------------");
//                while(rs.next()){
//                    System.out.format("%5s %17s %15s %10s %15s", rs.getString("customer_id"), rs.getString("contact_name"), rs.getString("city"), rs.getString("country"), rs.getString("phone"));
//                    System.out.println();
//                }
        } catch (SQLException | FileNotFoundException e) {
            System.err.println("Error " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectQuery() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(dbUrl, "", "")) {
            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select * from client limit 3;");
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                    System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
//                    System.out.println();
//                    System.out.println("---------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %17s %15s %10s %15s", rs.getString("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("address"), rs.getString("email"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Connection error " + e);
        }
        ;
    }

       @Test
    public void testInsertQuery() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(dbUrl, "", "")) {
            Statement s = db.createStatement();
            boolean rs = s.execute("insert into client(fName,lName,address,telephone,email) values('yes', 'no', 'Burkina','0275876542', 'francis@gmail.com')");
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                    System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
//                    System.out.println();
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                while(rs.next()){
//                    System.out.format("%5s %17s %15s %10s %15s", rs.getString("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("address"), rs.getString("email"));
//                    System.out.println();
//                }
            System.out.println(rs);

        } catch (SQLException e) {
            System.err.println("Connection error " + e);
        }
    }
    @Test
    public void testUpdateQuery() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(dbUrl, "", "")) {
            Statement s = db.createStatement();
            boolean rs = s.execute("update client set fName = 'Francis' where ID =1");
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                    System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
//                    System.out.println();
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                while(rs.next()){
//                    System.out.format("%5s %17s %15s %10s %15s", rs.getString("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("address"), rs.getString("email"));
//                    System.out.println();
//                }
 //           System.out.println(rs);

        } catch (SQLException e) {
            System.err.println("Connection error " + e);
        }



    }

    @Test
        public void testDeleteQuery() throws ClassNotFoundException{
            Class.forName("org.h2.Driver");
            try(Connection db = DriverManager.getConnection(dbUrl,"","")) {
                Statement s = db.createStatement();
                boolean rs = s.execute("delete from client where ID = 1");
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                    System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
//                    System.out.println();
//                    System.out.println("---------------------------------------------------------------------------------------------");
//                while(rs.next()){
//                    System.out.format("%5s %17s %15s %10s %15s", rs.getString("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("address"), rs.getString("email"));
//                    System.out.println();
//                }
                System.out.println(rs);

            } catch (SQLException e) {
                System.err.println("Connection error "+e);
            }


        }


}