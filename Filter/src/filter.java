 /**
 * Created by root on 28.07.16.
 */

import java.util.Scanner;
import java.io.*;

public class filter {
    public static String read(String filename)
    {
        String input = "";
        try
        {
            FileReader reader = new FileReader(filename);
            int chr;
            while ((chr = reader.read()) != -1)
            {
                input += (char)chr;
            }
            reader.close();
        }
        catch (FileNotFoundException ex) {}
        catch (IOException ie) {}
        System.out.println("Read line:" + input);
        return input;
    }

    public static String filter(String input)
    {
        char[] chrsIn = input.toCharArray(), chrsOut = new char[input.length()];
        int count = -1;
        for(char x: chrsIn)
        {
            if ((x >= 48) && (x <= 57)) chrsOut[++count] = x;
        }
        String output = new String(chrsOut);
        output = output.trim();
        System.out.println("Filtred: " + output);
        return output;
    }

    public static void write(String output, String filename)
    {
        try
        {
            FileWriter writer = new FileWriter(filename);
            writer.write(output);
            writer.close();
        }
        catch (IOException ie) {}
    }

    public static void main(String args[])
    {
        String name_in = "input.txt", name_out = "output.txt";
        String input = read(name_in);
        String output = filter(input);
        write(output, name_out);
        System.out.println("Cmplt");
    }
}
