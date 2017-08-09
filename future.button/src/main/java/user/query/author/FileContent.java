package user.query.author;

import java.io.*;

/**
 * Created on 09-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class FileContent {

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
