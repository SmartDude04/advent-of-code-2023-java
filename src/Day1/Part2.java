package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Part2 {
    public static void main(String[] args)
    {
        ArrayList<String> lines = fileOpener("Day1/input.txt");
        int sum = 0;
        for (String line : lines)
        {
            // System.out.println(getNumForLine(line));
            sum += getNumForLine(line);
        }

        System.out.println(sum);
    }

    private static int getNumForLine(String line)
    {
        line = line.replaceAll("one", "o1ne");
        line = line.replaceAll("two", "t2wo");
        line = line.replaceAll("three", "t3hree");
        line = line.replaceAll("four", "f4our");
        line = line.replaceAll("five", "f5ive");
        line = line.replaceAll("six", "s6ix");
        line = line.replaceAll("seven", "s7even");
        line = line.replaceAll("eight", "e8ight");
        line = line.replaceAll("nine", "n9ine");
        

        String num = "";
        // Get first digit
        for (int i = 0; i < line.length(); i++)
        {
            if (Character.isDigit(line.charAt(i)))
            {
                num += line.substring(i, i + 1);
                break;
            }
        }

        // Get last digit
        for (int i = line.length() - 1; i >= 0; i--)
        {
            if (Character.isDigit(line.charAt(i)))
            {
                num += line.substring(i, i + 1);
                break;
            }
        }
        return Integer.parseInt(num);
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
