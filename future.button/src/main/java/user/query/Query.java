package user.query;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 06-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class Query extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body><p>Hello</p></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
