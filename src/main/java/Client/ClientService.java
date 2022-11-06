package Client;
import Database.Database;

import java.sql.*;
import java.util.List;

public class ClientService {
    private String createClient = "INSERT INTO client (name) VALUES (?)";
    private String readMaxId = "SELECT MAX (id) AS maxId FROM client";
    private String getById = "SELECT id, name FROM client WHERE id =?";
    private   String updateName = "UPDATE CLIENT SET NAME=? WHERE ID=?";
    private String deleteById = "DELETE FROM CLIENT WHERE ID = ?";
    private   String listAll = "SELECT id, name FROM client GROUP BY id";

    long create(String name) throws SQLException {
        PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(createClient);
        statement.setString(1, name);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
        long id;
        try (PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(readMaxId);

             ResultSet rs = ps.executeQuery()) {
            rs.next();
            id = rs.getLong("maxId");
        }
        System.out.println("id = " + id);
        return id;
    }

    String getById(long id) throws SQLException {
        Client client = new Client();
        PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(getById);
        ps.setLong(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) {
                return null;
            }
            client.setId(id);
            client.setName(rs.getString("name"));
            System.out.println(client.toString());
            return (client.toString());
        }
    }

    void setName(long id, String name) throws SQLException {
        PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(updateName);
        ps.setString(1, name);
        ps.setLong(2, id);
        ps.executeUpdate();
    }

    void deleteById(long id) throws SQLException {
        PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(deleteById);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    List<Client> listAll() throws SQLException {

        PreparedStatement ps = Database.getInstance().getConnection().prepareStatement(listAll);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Client result = new Client();
                result.setId(rs.getLong("id"));
                result.setName(rs.getString("name"));
                System.out.println(result);
            }
        }
        return null;
    }
}



























