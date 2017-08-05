package entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created on 05-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class EntryLevel extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response){
        File input = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\ROOT\\index.html");

        try {
           PrintWriter out = response.getWriter();
           BufferedReader reader =new BufferedReader(new FileReader(input));
            String current = null;
            StringBuffer buf = new StringBuffer();
            while ((current = reader.readLine())!=null){
                buf.append(current);
            }
            out.println(buf.toString());
        } catch (IOException e) {
                        e.printStackTrace();
        }

    }
}
