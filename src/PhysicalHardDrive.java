public class PhysicalHardDrive {
    private String name;
    private int size;
    private PhysicalVolume peevee;

    public PhysicalHardDrive(String n, int s)
    {
        name = n;
        size = s;
    }

    public int getSize()
    {
        return size;
    }

    public String getName()
    {
        return name;
    }

    public void setPV(PhysicalVolume pain)
    {
        peevee = pain;
    }

    public boolean hasPhysical()
    {
        if(peevee == null)
        {
            return false;
        }
        return true;
    }

}
