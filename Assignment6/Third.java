import java.io.*;
// import java.io.File;

public class Third
{
    public static void main(String[] args)
    {
        // String str = new String(args[0]);
        // File f1 = new File(str);

        String f1 = args[0];
        String f2 = "even.txt";
        String f3 = "odd.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(f1));
            BufferedWriter evenWriter = new BufferedWriter(new FileWriter(f2));
            BufferedWriter oddWriter = new BufferedWriter(new FileWriter(f3)))
        {
            String line;
            int lineCount = 0;
            while((line = br.readLine()) != null)
            {
                lineCount++;
                if(lineCount % 2 == 0)
                {
                    evenWriter.write(line);
                    evenWriter.newLine();
                }
                else
                {
                    oddWriter.write(line);
                    oddWriter.newLine();
                }
            }

            System.out.println("Text at even line numbers written to " +evenWriter);
            System.out.println("Text at odd line numbers written to " +oddWriter);
        }catch(Exception e)
        {
            System.out.println("An error occurred " +e.getMessage());
        }
    }
}
