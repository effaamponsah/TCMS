package io.turntabl.tcms;

import org.h2.util.ScriptReader;
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

    @Test
    public void testInMemoryDb() throws ClassNotFoundException {
        BufferedReader reader = null;
            Class.forName("org.h2.Driver");
            try(Connection db = DriverManager.getConnection(dbUrl,"","")) {

                Statement s = db.createStatement();
                reader = new BufferedReader(new FileReader(testScriptPath));

                String line = null;
                while ((line = reader.readLine()) != null) {
                    s.execute(line);
                }
            } catch (SQLException | FileNotFoundException e) {
                System.err.println("Error "+e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
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
                    ResultSet rs = s.executeQuery("select * from client limit 3;");
                    while(rs.next()){
                        System.out.format("%5s %17s %15s %10s %15s", rs.getString("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("address"), rs.getString("email"));
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
            ResultSet rs = s.executeQuery("select fName from client where ID='1';");
            while(rs.next()){
                assertEquals("Dennis", rs.getString("fName"));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        } ;
    }

}