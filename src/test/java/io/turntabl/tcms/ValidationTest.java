package io.turntabl.tcms;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {
    @Test
    public void testValidateEmail(){

        assertTrue(Validation.isword("James"));
    }

    @Test
    public void testCharactersOnEmail(){

        assertFalse(Validation.isword("&&^%"));
    }

    @Test
    public void testRealEmail(){
        assertTrue(Validation.isword("teebill@gmail.com"));
    }


}