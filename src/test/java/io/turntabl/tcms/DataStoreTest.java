package io.turntabl.tcms;

import org.h2.util.ScriptReader;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import static org.junit.Assert.*;

public class DataStoreTest {
    private static final String dbUrl = "jdbc:h2:tcms";
    private static final String testScriptPath = "testscript.sql";

    @Before
    public void testInMemoryDb() throws ClassNotFoundException {
        BufferedReader reader = null;
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(dbUrl, "", "")) {

            Statement s = db.createStatement();
            reader = new BufferedReader(new FileReader(testScriptPath));
//
//<<<<<<< HEAD
                String line = null;
                while ((line = reader.readLine()) != null) {
                    s.execute(line);
                }
            } catch (SQLException | FileNotFoundException e) {
                System.err.println("Error "+e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();}
//=======
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                s.execute(line);
//            }
////                ResultSet rs = s.executeQuery("select * from customers limit 3;");
////                System.out.println("---------------------------------------------------------------------------------------------");
////                System.out.printf("%5s %15s %15s %10s %10s", "CUST_ID", "CONTACT_NAME",  "CITY", "COUNTRY", "PHONE");
////                System.out.println();
////                System.out.println("---------------------------------------------------------------------------------------------");
////                while(rs.next()){
////                    System.out.format("%5s %17s %15s %10s %15s", rs.getString("customer_id"), rs.getString("contact_name"), rs.getString("city"), rs.getString("country"), rs.getString("phone"));
////                    System.out.println();
////                }
//        } catch (SQLException | FileNotFoundException e) {
//            System.err.println("Error " + e.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testUpdateQuery() throws ClassNotFoundException {
            Class.forName("org.h2.Driver");
            try (Connection db = DriverManager.getConnection(dbUrl, "", "")) {
                Statement s = db.createStatement();
                boolean rs = s.execute("update client set name = 'Francis' where ID =1");


            } catch (SQLException e) {
                System.err.println("Connection error " + e);
            }
        }
    @Test
    public void clientTableRows() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"","")) {
            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select count(*) as count from client;");
            while(rs.next()){
                assertEquals(2, rs.getInt("count"));
            }
        } catch (SQLException e) {
            System.err.println("Connection error "+e);
        } ;

    }

    @Test
    public void testSelectQuery() throws ClassNotFoundException {
    Class.forName("org.h2.Driver");
    try(Connection db = DriverManager.getConnection(dbUrl,"","")) {
                    Statement s = db.createStatement();
                    ResultSet rs = s.executeQuery("select * from client;");
                    while(rs.next()){
                        System.out.format("%5s %17s %10s %15s", rs.getString("ID"), rs.getString("name"), rs.getString("address"), rs.getString("email"));
                        System.out.println();
                    }
                } catch (SQLException e) {
                    System.err.println("Connection error "+e);
                } ;
            }

    @Test
    public void testFirstClientsName() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try(Connection db = DriverManager.getConnection(dbUrl,"","")) {
            Statement s = db.createStatement();
            ResultSet rs = s.executeQuery("select name from client where ID='1';");
            while(rs.next()){
                assertEquals("Dennis Christy", rs.getString("name"));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        } ;
    }


    @Test
    public void testInsertQuery() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        try (Connection db = DriverManager.getConnection(dbUrl, "", "")) {
            Statement s = db.createStatement();
            boolean rs = s.execute("insert into client(name,address,telephone,email) values('yes', 'Burkina','0275876542', 'francis@gmail.com')");
            System.out.println(rs);

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

                System.out.println(rs);

            } catch (SQLException e) {
                System.err.println("Connection error "+e);
            }


        }


}