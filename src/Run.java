import java.util.Scanner;
public class Run {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Commands pleasework = new Commands();
        String input = "scan.nextLine()";
        while(input.equals("exit") == false) {
            System.out.println("Input a command please!");
            input = scan.nextLine();
            String[] seperate = input.split(" ");
            if (seperate[0].equals("install-drive")) {
                if (!pleasework.installDrive(seperate[1], Integer.parseInt(seperate[2].substring(0,seperate[2].length()-1)))) {
                    System.out.println("NOPE! Can't do that!");
                } else {
                    System.out.println("Drive Installation Successful");
                }
            }
            if(seperate[0].equals("list-drives"))
            {
                pleasework.driveList();
            }
            if(seperate[0].equals("pvcreate"))
            {
                if(!pleasework.pvolumeCreate(seperate[1], seperate[2]))
                {
                    System.out.println("NOPE! Can't do that!");
                }
                else
                {
                    System.out.println("Physical Volume Creation Successful");
                }
            }
            if(seperate[0].equals("pvlist"))
            {
                pleasework.pvList();
            }
            if(seperate[0].equals("vgcreate"))
            {
                if(!pleasework.veegeeCreate(seperate[1], seperate[2]))
                {
                    System.out.println("NOPE! Can't do that!");
                }
                else
                {
                    System.out.println("Volume Group Creation Successful");
                }
            }
            if(seperate[0].equals("vgextend"))
            {
                if(!pleasework.vgAdd(seperate[1], seperate[2]))
                {
                    System.out.println("NOPE! Can't do that!");
                }
                else
                {
                    System.out.println("Volume Group Addition Successful");
                }
            }
            if(seperate[0].equals("vgList"))
            {
                pleasework.vgList();
            }
            if(seperate[0].equals("lvcreate"))
            {
                if (!pleasework.lvCreate(seperate[1],Integer.parseInt(seperate[2]),seperate[3])) {
                    System.out.println("NOPE! Can't do that!");
                }
                else
                {
                    System.out.println("Logical Volume Created");
                }
            }
            if(seperate[0].equals("lvlist"))
            {
                pleasework.logList();
            }



        }
    }
}
