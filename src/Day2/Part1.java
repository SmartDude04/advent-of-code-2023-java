package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args)
    {
        ArrayList<String> lines = fileOpener("Day2/sample.txt");
        int sumThatWorks = 0;
        for (int i = 0; i < lines.size(); i++)
        {
            if (checkIfWorks(lines.get(i)))
            {
                sumThatWorks += i + 1;
            }
        }
        System.out.println(sumThatWorks);
    }

    private static boolean checkIfWorks(String line)
    {
        final int MAX_RED = 12;
        final int MAX_GREEN = 13;
        final int MAX_BLUE = 14;

        String[] pulls = line.split(": ")[1].split("; ");
        for (String pull : pulls)
        {
            String[] parts = pull.split(", ");
            for (String part : parts)
            {
                String[] numColor = part.split(" ");
                if (numColor[1].charAt(0) == 'r' && Integer.parseInt(numColor[0]) > MAX_RED)
                {
                    return false;
                }
                else if (numColor[1].charAt(0) == 'g' && Integer.parseInt(numColor[0]) > MAX_GREEN)
                {
                    return false;
                }
                else if (numColor[1].charAt(0) == 'b' && Integer.parseInt(numColor[0]) > MAX_BLUE)
                {
                    return false;
                }
            }
        }
        return true;
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
