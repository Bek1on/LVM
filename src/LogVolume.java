public class LogVolume extends PrePV{
    private VolumeGroup veegee;

    public LogVolume(String name, int space, VolumeGroup vg)
    {
        super(name, space);
        veegee = vg;
    }

    public VolumeGroup getVG()
    {
        return veegee;
    }
}
