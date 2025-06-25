import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SplitFile {

    public static void main(String[] args) {
        // Check if the filename is provided as command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java SplitFile <filename>");
            return;
        }

        String inputFilename = args[0];
        String evenFilename = "even.txt";
        String oddFilename = "odd.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter evenWriter = new BufferedWriter(new FileWriter(evenFilename));
             BufferedWriter oddWriter = new BufferedWriter(new FileWriter(oddFilename))) {

            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (lineNumber % 2 == 0) {
                    evenWriter.write(line);
                    evenWriter.newLine();
                } else {
                    oddWriter.write(line);
                    oddWriter.newLine();
                }
            }

            System.out.println("Text at even line numbers written to " + evenFilename);
            System.out.println("Text at odd line numbers written to " + oddFilename);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
