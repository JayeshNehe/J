// import java.util.*;
import java.io.*;
import java.io.File;

public class Second
{
    public static void main(String[] args)
    {
        String str = new String(args[0]);
        File f1 = new File(str);

        if(f1.exists() && f1.isFile())
        {
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try(BufferedReader br = new BufferedReader(new FileReader(f1)))
            {
                String line;
                
                while((line = br.readLine()) != null)
                {
                    lineCount++;

                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;

                    charCount += line.length();
                }
            }catch(Exception e)
            {
                System.out.println("An error occurred while reading the file" +e.getMessage());
            }
            
            System.out.println("Number of lines: " +lineCount);
            System.out.println("Number of words: " +wordCount);
            System.out.println("Number of characters: " +charCount);
        }
        else
        {
            System.out.println("Given file does not exists or is not a file");
        }
    }
}
