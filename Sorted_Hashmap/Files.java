import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * a class used to read and parse through files
 */
public class Files {
    // attributes
    private File myFile;                                        // a file object

    /**
     * create an object representing a File
     *
     * @param fileName the name of the file
     */
    public Files(String fileName) {
        this.myFile = new File(fileName);
    }

    /**
     * will verify if a file exists
     *
     * @return boolean if it exists or not
     */
    public boolean verifyFile() {
        return myFile.exists();
    }

    /**
     * read the information in the file and return it as a string
     *
     * @return a string from the file contents
     * @throws IOException an exception if there are any errors
     */
    public String readFile() throws IOException {
        if (!verifyFile()) {                                // verify file exists
            throw new IOException("File does not exist");   // error message
        }

        StringBuilder fileContent = new StringBuilder();    // set up string builder

        // read through file with buffered reader
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");      // append each line to the file content
            }
        }                                                   // BufferedReader closes automatically

        return fileContent.toString();                      // return the content as a string
    }

    /**
     * read the information in the file and return it as a string
     *
     * @return an array from the file contents
     * @throws IOException an exception if there are any errors
     */
    public List<String[]> readFileAsArray() throws IOException {
        if (!verifyFile()) {                                // verify file exists
            throw new IOException("File does not exist");   // error message
        }

        List<String[]> array = new ArrayList<>();
        String content = readFile();
        String[] lines = content.split("\n");

        for (String line : lines) {
            String[] tuple = line.split(",\\s*");      // split each line by comma and any spaces
            array.add(tuple);                                // add tuple to the array
        }

        return array;
    }

}