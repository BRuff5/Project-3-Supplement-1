import java.io.*;

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

   
// Example usage
public static void main(String[] args) {
    String filePath = "file.txt";
    String content = "Hello, World!\nDo You Want To Play A Game?? Y/N\nHAHA so that in a movie one time\nThought it would be funny:)\nHAPPY HOLIDAYYSS TO ALL AND ALL A GOOD NIGHT!!!\n##### program TERMINATED ######";

    try {
        // Write content to file
        writeToFile(filePath, content);
        System.out.println("Content written to file.");


    } catch (IOException e) {
        System.err.println("An error occurred: " + e.getMessage());
    }
}
}