package author;

import java.io.*;

/**
 * Created on 09-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This class reads content from file.
 */
public class FileContent {
    /**
     * This method reads content of file and returns it as a string.
     * @param pathOfFile path of file.
     * @return content of the file as a string.
     * @throws IOException
     */
    public String contentToString(String pathOfFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathOfFile)));
        StringBuilder currentText = new StringBuilder();
        String eachLine = " ";

        while((eachLine = bufferedReader.readLine()) != null) {
            currentText.append(" " + eachLine);
        }
        return currentText.toString();
    }
}
