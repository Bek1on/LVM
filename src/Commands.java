import java.util.ArrayList;
public class Commands {
    private ArrayList<PhysicalHardDrive> existingHards;
    private ArrayList<PhysicalVolume> existingVolumes;
    private ArrayList<VolumeGroup> existingVG;
    private ArrayList<LogVolume> existingLogs;

    public Commands()
    {
        existingHards = new ArrayList<>();
        existingVolumes = new ArrayList<>();
        existingVG = new ArrayList<>();
        existingLogs = new ArrayList<>();
    }

    public boolean installDrive(String name, int size)
    {
        for(int i = 0; i < existingHards.size();i++)
        {
            if(existingHards.get(i).getName().equals(name))
            {
                return false;
            }
        }
        existingHards.add(new PhysicalHardDrive(name,size));
        return true;
    }

    public void driveList()
    {
        for(int i = 0; i < existingHards.size();i++)
        {
            System.out.println(existingHards.get(i).getName() + "[" + existingHards.get(i).getSize() + "G]");
        }
    }

    public boolean pvolumeCreate(String name, String drive)
    {
        PhysicalHardDrive check = null;
        for(int i = 0; i < existingHards.size();i++)
        {
            if(existingHards.get(i).getName().equals(drive))
            {
                check = existingHards.get(i);
            }
        }
        if(check == null)
        {
            return false;
        }
        if(check.hasPhysical())
        {
            return false;
        }
        PhysicalVolume input = new PhysicalVolume(name, check);
        existingVolumes.add(input);
        return true;
    }

    public boolean veegeeCreate(String name, String pv)
    {
        PhysicalVolume check = null;
        for(int i = 0; i < existingVolumes.size();i++)
        {
            if(existingVolumes.get(i).getName().equals(pv))
            {
                check = existingVolumes.get(i);
            }
        }
        if(check == null)
        {
            return false;
        }
        if(check.inVG())
        {
            return false;
        }
        VolumeGroup pain = new VolumeGroup(name, check);
        existingVG.add(pain);
        return true;
    }

    public boolean vgAdd(String name, String pv)
    {
        PhysicalVolume check = null;
        for(int i = 0; i < existingVolumes.size();i++)
        {
            if(existingVolumes.get(i).getName().equals(pv))
            {
                check = existingVolumes.get(i);
            }
        }
        if(check == null)
        {
            return false;
        }
        VolumeGroup check2 = null;
        for(int d = 0; d < existingVG.size();d++)
        {
            if(existingVG.get(d).getName().equals(name))
            {
                check2 = existingVG.get(d);
            }
        }
        if(check2 == null)
        {
            return false;
        }
        check2.addToVolume(check);
        return true;
    }

    public void vgList()
    {
        for(int i = 0; i < existingVG.size();i++)
        {
            System.out.println(existingVG.get(i).getName() + ": Total: [" + existingVG.get(i).getStorage() + "G] availible :[" + (existingVG.get(i).getStorage()-existingVG.get(i).getStored()) + "G] " + existingVG.get(i).getPhysicalVolumes().toString() + " [" + existingVG.get(i).getID() + "]");
        }
    }

    public boolean lvCreate(String name, int size, String vg)
    {
        VolumeGroup check2 = null;
        for(int d = 0; d < existingVG.size();d++)
        {
            if(existingVG.get(d).getName().equals(vg))
            {
                check2 = existingVG.get(d);
            }
        }
        if(check2 == null)
        {
            return false;
        }
        LogVolume lvozo = new LogVolume(name,size,check2);
        if(!check2.addToLog(lvozo))
        {
            return  false;
        }
        existingLogs.add(lvozo);
        return true;
    }

    public void logList()
    {
        for(int i = 0; i < existingLogs.size();i++)
        {
            System.out.println(existingLogs.get(i).getName() + ": [" + existingLogs.get(i).getStorage() + "] [" + existingLogs.get(i).getVG().getName() + "] [" + existingLogs.get(i) + "]");
        }
    }

    public void pvList()
    {
        for(int i = 0; i < existingVolumes.size();i++)
        {
            if(existingVolumes.get(i).inVG()) {
                System.out.println(existingVolumes.get(i).getName() + "[" + existingVolumes.get(i).getStorage() + "G] [" + existingVolumes.get(i).getVG().getName() + "] [" + existingVolumes.get(i).getID());
            }
            else
            {
                System.out.println(existingVolumes.get(i).getName() + "[" + existingVolumes.get(i).getStorage() + "G] [" + existingVolumes.get(i).getID());
            }
        }
    }

}
