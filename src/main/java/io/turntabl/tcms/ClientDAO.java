package io.turntabl.tcms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
    void addClient(ClientTO client) throws ClassNotFoundException;
    List<ClientTO> getAllClients() throws ClassNotFoundException;
    void deleteClient(String clientID) throws ClassNotFoundException;
    List<ClientTO> getClientByName(String clientName) throws ClassNotFoundException;

    }

