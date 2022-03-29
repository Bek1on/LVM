public class PhysicalVolume extends PrePV {
    private PhysicalHardDrive hardDrive;
    private VolumeGroup vogo;

    public PhysicalVolume(String name, PhysicalHardDrive drive)
    {
        super(name,drive.getSize());
        hardDrive = drive;
    }

    public PhysicalHardDrive getHDrive()
    {
        return hardDrive;
    }

    public VolumeGroup getVG()
    {
        return vogo;
    }

    public boolean inVG()
    {
        if(vogo == null)
        {
            return false;
        }
        return true;
    }



}
