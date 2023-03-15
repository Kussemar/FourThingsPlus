package dat.backend.model.persistence;

import dat.backend.model.entities.Item;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemMapper {
    static List<Item> getAllItems(ConnectionPool connectionPool) throws DatabaseException {

        String sql = "select * from item";

        List<Item> itemList = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int itemId = rs.getInt("item_id");
                    String name = rs.getString("name");
                    boolean done = rs.getBoolean("done");
                    String userName = rs.getString("username");
                    Timestamp created = rs.getTimestamp("created");

                    Item newItem = new Item(itemId, name, done, userName, created);
                    itemList.add(newItem);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Fejl i tilgangen til databasen");
        }
        return itemList;
    }

    public static void addItem(String newItem, String username, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Item item;
        String sql = "insert into item (name,username) values (?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, newItem);
                ps.setString(2, username);
                int rowsAffected = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert item into database");
        }
    }

}