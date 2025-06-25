// import java.util.*;
import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

public class First
{
    public static void main(String[] args)
    {
        String str = new String(args[0]);
        File f1 = new File(str);

        if(f1.isDirectory())
        {
            System.out.println(str+ " is a Directory");
            
            //Get all files in the directory
            File[] files = f1.listFiles();

            //Count the number of files
            int fileCount = files.length;
            System.out.println("\nNumber of Files: " +fileCount);

            //Display Names of Files having extension .txt
            File[] files2 = f1.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name)
                {
                    return name.toLowerCase().endsWith(".txt");
                }
            });

            System.out.println("\nFile names having extension .txt:");
            for(File file: files2)
            {
                System.out.println(file.getName());
            }
        }
        else if(f1.isFile())
        {
            System.out.println(str+ " is a File");

            System.out.println("File Name: " +f1.getName());
            System.out.println("File Path: " +f1.getAbsolutePath());

            long size = f1.length();
            System.out.println("File Size: " +size+ " bytes");

            try
            {
                BasicFileAttributes attributes = Files.readAttributes(f1.toPath(), BasicFileAttributes.class);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("Creation Time: " +sdf.format(attributes.creationTime().toMillis()));
                System.out.println("Last Access Time: " +sdf.format(attributes.lastAccessTime().toMillis()));
                System.out.println("Last Modified Time: " +sdf.format(attributes.lastModifiedTime().toMillis()));
            }catch(Exception e)
            {
                System.out.println("Error reading the file attributes: " +e.getMessage());
            }
        }
        else
        {
            System.out.println(str+ " is neither a Directory nor a File");
        }
    }
}