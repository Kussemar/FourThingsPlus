package dat.backend.model.persistence;

import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class ItemFacade
{
    public static List<Item> getAllItems(ConnectionPool connectionPool) throws DatabaseException
    {
        return ItemMapper.getAllItems(connectionPool);
    }

    public static void addItem(String newItem, String username, ConnectionPool connectionPool) throws DatabaseException {
        ItemMapper.addItem(newItem, username, connectionPool);
    }

    public static void toggleItem(int item_id, ConnectionPool connectionPool) {
        ItemMapper.toggleItem(item_id, connectionPool);

    }

    public static void deleteItem(int item_id, ConnectionPool connectionPool) {
        ItemMapper.deleteItem(item_id, connectionPool);
    }

    public static Item getItemById(int item_id, ConnectionPool connectionPool) throws DatabaseException {

        return ItemMapper.getItemById(item_id, connectionPool);
    }

    public static void updateItemName(int item_id, String name, ConnectionPool connectionPool) {

        ItemMapper.updateItemName(item_id, name, connectionPool);
    }
}
