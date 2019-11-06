package io.turntabl.tcms;
import javax.swing.*;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isword(String in) {
        return Pattern.matches("[a-zA-Z0-999. @]+", in);
    }
}
