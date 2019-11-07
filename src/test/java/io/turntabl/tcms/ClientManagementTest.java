package io.turntabl.tcms;


import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ClientManagementTest {


    @Test
    public void testClient() throws IOException {
        Client c = new Client("5454","francis","045355599","junior@gmail.com","fdsadda");
        assertEquals("francis", c.getName());
    }

    @Test
    public void testWriteToFile() throws IOException {
        Client c = new Client("4643","chris","02340001111","tee@ymail.com","madina");
        c.writeToFile();

    }
}