package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args)
    {
        ArrayList<String> lines = fileOpener("Day2/input.txt");
        int sumPowers = 0;
        for (String line : lines)
        {
            sumPowers += getPower(line);
        }
        System.out.println(sumPowers);
    }

    private static int getPower(String line)
    {
        int max_red = 0;
        int max_green = 0;
        int max_blue = 0;

        String[] pulls = line.split(": ")[1].split("; ");
        for (String pull : pulls)
        {
            String[] parts = pull.split(", ");
            for (String part : parts)
            {
                String[] numColor = part.split(" ");
                if (numColor[1].charAt(0) == 'r' && Integer.parseInt(numColor[0]) > max_red)
                {
                    max_red = Integer.parseInt(numColor[0]);
                }
                else if (numColor[1].charAt(0) == 'g' && Integer.parseInt(numColor[0]) > max_green)
                {
                    max_green = Integer.parseInt(numColor[0]);
                }
                else if (numColor[1].charAt(0) == 'b' && Integer.parseInt(numColor[0]) > max_blue)
                {
                    max_blue = Integer.parseInt(numColor[0]);
                }
            }
        }
        return max_red * max_green * max_blue;
    }

    private static ArrayList<String> fileOpener(String fileName)
    {
        ArrayList<String> lines = new ArrayList<String>();

        try
        {
            File myObj = new File("bin/" + fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
            return lines;
    }
}
