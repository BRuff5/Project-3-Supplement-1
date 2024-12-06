import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Function to write content to a file specified by a file path.
 * Function to return data from a file specified by a file path.
 * Function to count the number of lines in a file
 */
public class main {

    /**
     * Writes the specified content to a file
     *
     * @param filePath the path of the file to write to
     * @param content  the content to write to the file
     */
    public static void writeToFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    /**
     * Reads the content of a file located at the given file path and returns it as a String.
     *
     * @param filePath the path of the file to read from
     * @return the content of the file as a String
     */
    public static String readFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString().trim(); 
    }

    /**
     * Counts the number of lines 
     *
     * @param filePath the path of the file to count lines in
     * @return the number of lines in the file
    
     */
    public static int countLinesInFile(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return (int) lines.count();
        }
    }

   
// Example usage
public static void main(String[] args) {
    String filePath = "file.txt";
    String content = "Hello, World!\nDo You Want To Play A Game?? Y/N\nHAHA so that in a movie one time\nThought it would be funny:)\nHAPPY HOLIDAYYSS TO ALL AND ALL A GOOD NIGHT!!!\n##### program TERMINATED ######";

    try {
        // Write content to file
        writeToFile(filePath, content);
        System.out.println("Content written to file.");


        // Read content from the file
        String fileContent = readFromFile(filePath);
        System.out.println("Content read from the file:");
        System.out.println(fileContent);
        

        // Count lines in the file
        int lineCount = countLinesInFile(filePath);
        System.out.println("Number of lines in the file: " + lineCount);

    } catch (IOException e) {
        System.err.println("An error occurred: " + e.getMessage());
    }
}
}