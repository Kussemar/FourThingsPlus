package dat.backend.model.entities;

import java.sql.Timestamp;

public class Item
{
    private int itemId;
    private String name;
    private boolean done;
    private String userName;
    private Timestamp created;

    public Item(int itemId, String name, boolean done, String userName, Timestamp created)
    {
        this.itemId = itemId;
        this.name = name;
        this.done = done;
        this.userName = userName;
        this.created = created;
    }

    public int getItemId()
    {
        return itemId;
    }

    public String getName()
    {
        return name;
    }

    public boolean isDone()
    {
        return done;
    }

    public String getUserName()
    {
        return userName;
    }

    public Timestamp getCreated()
    {
        return created;
    }
}
