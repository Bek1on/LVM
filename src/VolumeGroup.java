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

    public String getPhysicalVolumes()
    {
        String ret = "";
        for(int i = 0; i < physicalVolumes.size();i++)
        {
            ret += physicalVolumes.get(i).getName();
            if(physicalVolumes.size() > 1 && i != physicalVolumes.size()-1)
            {
                ret += ", ";
            }
        }
        return ret;
    }

    public ArrayList<LogVolume> getLogicalVolumes()
    {
        return logicalVolumes;
    }

}
