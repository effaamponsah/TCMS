package io.turntabl.tcms;


import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TcmTest {


    @Test
    public void testClient() throws IOException {
        Client c = new Client("glo","54422","gaga@gmail","fafd3444");
        assertEquals("glo", c.getName());
    }

    @Test
    public void testWriteToFile() throws IOException {
        Client c = new Client("Dennis", "3332", "kamponsah","This");
        c.writeToFile();

    }
}