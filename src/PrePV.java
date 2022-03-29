import java.util.UUID;
public class PrePV {
    private String name;
    private String uuid;
    private int storage;
    public PrePV(String name, int store)
    {
        UUID rand = UUID.randomUUID();
        uuid = rand.toString();
        this.name = name;
        storage = store;
    }

    public String getID()
    {
        return uuid;
    }

    public String getName()
    {
        return name;
    }

    public int getStorage()
    {
        return storage;
    }

    public void setStorage(int set)
    {
        storage = set;
    }



}
