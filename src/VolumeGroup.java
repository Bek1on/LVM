import java.util.UUID;
import java.util.ArrayList;
public class VolumeGroup extends PrePV {
    private int stored;
    private ArrayList<PhysicalVolume> physicalVolumes;
    private ArrayList<LogVolume> logicalVolumes;

    public VolumeGroup(String name, PhysicalVolume p)
    {
        super(name,p.getStorage());
        logicalVolumes = new ArrayList<>();
        physicalVolumes = new ArrayList<>();
        stored = 0;
        physicalVolumes.add(p);
    }

    public int getStored()
    {
        return stored;
    }

    public void addToVolume(PhysicalVolume peevee)
    {
        physicalVolumes.add(peevee);
        setStorage(getStorage() + peevee.getStorage());
    }

    public boolean addToLog(LogVolume lovo)
    {
        int check = lovo.getStorage();
        if(stored + check > getStorage())
        {
            return false;
        }
            logicalVolumes.add(lovo);
            return true;
    }

    public ArrayList<PhysicalVolume> getPhysicalVolumes()
    {
        return physicalVolumes;
    }

    public ArrayList<LogVolume> getLogicalVolumes()
    {
        return logicalVolumes;
    }

}
