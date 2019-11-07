package io.turntabl.tcms;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {
    @Test
    public void testDistance(){
        assertEquals(3, Utils.lavenstine("Flomax", "Volmax"));
    }

    @Test
    public void testDistance2(){
        assertEquals(4, Utils.lavenstine("Dennis", "Bernice"));
    }

}