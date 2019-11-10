package io.turntabl.tcms;

public class ClientNotFoundError extends Exception {
    public ClientNotFoundError(final String message) {
        super(message);
    }
}
