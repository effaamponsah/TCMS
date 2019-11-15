package io.turntabl.tcms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements ClientDAO {
    private List<ClientTO> clients = new ArrayList<>();
    String databaseURL = "";


    @Override
    public void addClient(ClientTO client) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection database = DriverManager.getConnection(databaseURL, "", "")) {
            PreparedStatement preparedStatement = database.prepareStatement("Insert into client(client_id, client_name, client_phone,client_email,client_address) values(?,?,?,?,?)");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getPhone());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getAddress());

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %15s %20s %20s", "CLIENT_ID", "CLIENT_NAMES", "PHONE", "EMAIL", "ADDRESS");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                clients.add(new ClientTO(resultSet.getString("client_id"),resultSet.getString("client_name"),resultSet.getString("client_phone"),resultSet.getString("client_email"),resultSet.getString("client_address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClientTO> getAllClients() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection database = DriverManager.getConnection(databaseURL, "", "")) {
            PreparedStatement preparedStatement = database.prepareStatement("Select * from clients");
            preparedStatement.clearParameters();

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %15s %20s %20s", "CLIENT_ID", "CLIENT_NAMES", "PHONE", "EMAIL", "ADDRESS");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                clients.add(rowMapper(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void deleteClient(String clientID) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection database = DriverManager.getConnection(databaseURL, "", "")) {
            PreparedStatement preparedStatement = database.prepareStatement("Delete from clients where client_id like ?");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, clientID);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %15s %20s %20s", "CLIENT_ID", "CLIENT_NAMES", "PHONE", "EMAIL", "ADDRESS");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
//
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClientTO> getClientByName(String clientName) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection database = DriverManager.getConnection(databaseURL, "", "")) {
            PreparedStatement preparedStatement = database.prepareStatement("Select client_name from clients where client_name like '?'");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, clientName);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %15s %20s %20s", "CLIENT_ID", "CLIENT_NAMES", "PHONE", "EMAIL", "ADDRESS");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                clients.add(rowMapper(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    ClientTO rowMapper(ResultSet resultSet) throws SQLException {
        return new ClientTO(
                resultSet.getString("client_id"), resultSet.getString("client_name"), resultSet.getString("client_phone"), resultSet.getString("client_email"), resultSet.getString("client_address")
        );
    }


}



