package user.query;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import user.query.parser.HTMLParser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 06-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 * This is the main servlet for the future button application.
 * It gets query parameter from request, then calls ArticaleAuthor where it generates articles.
 * Jsoup is used for parser of html document that is send to client.
 */
public class Query extends HttpServlet {

    /**
     * This method is used to respond to the client.
     *
     * @param request  is from the client.
     * @param response is to the client/
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String query = request.getParameter("query");
            PrintWriter out = response.getWriter();
            Document doc = Jsoup.parse(new File("E:\\Projects\\ai\\futurebutton\\future.button\\src\\main\\resources\\executedquery.html"), response.getCharacterEncoding());
            HTMLParser htmlParser = new HTMLParser();
            String headOfArticle = "h3";
            String paragraph = "p";

            htmlParser.constructDocument(doc, headOfArticle, paragraph, query);
            out.println(doc.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}