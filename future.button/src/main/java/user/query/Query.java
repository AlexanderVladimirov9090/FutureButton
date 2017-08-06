package user.query;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import user.query.author.ArticleAuthor;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import static java.nio.charset.Charset.*;

/**
 * Created on 06-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class Query extends HttpServlet{
    private final String headOfArticle = "h3";
    private final String paragraph = "p";
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            String query = request.getParameter("query");
            ArticleAuthor articleAuthor = new ArticleAuthor(query);
            PrintWriter out = response.getWriter();
            Document doc = Jsoup.parse(new File("E:\\Projects\\ai\\futurebutton\\future.button\\src\\main\\resources\\executedquery.html"),"UTF8");
            Elements titles = doc.select(headOfArticle);
            Elements articles = doc.select(paragraph);
            for(int i= 0; i < titles.size(); i++ ){
                Element head = titles.select(headOfArticle).get(i);
                head.text(query+articleAuthor.writeTitle());
                Element article = articles.select(paragraph).get(i+1);
                article.text(query+ articleAuthor.writeArticle(50));
            }

        out.println(doc.head());
        out.println(doc.body());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
