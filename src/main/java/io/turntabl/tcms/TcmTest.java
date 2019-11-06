package io.turntabl.tcms;

import com.sun.security.ntlm.Client;
import com.sun.security.ntlm.NTLMException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TcmTest {


    @Test
    public void testClient() throws IOException, NTLMException {
        Client c = new Client("Jim", "3332", "kamponsah","This");
        assertEquals("Jim", c.nameToWriteToFile());
    }

    @Test
    public void testWriteToFile() throws IOException {
        Client c = new Client("Dennis", "3332", "kamponsah","This");
        c.writeToFile();

    }
}