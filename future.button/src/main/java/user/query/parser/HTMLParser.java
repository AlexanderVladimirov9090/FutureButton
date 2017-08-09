package user.query.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import user.query.author.ArticleAuthor;
import user.query.author.FileContent;
import user.query.date.FutureDate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.Math.*;

/**
 * Created on 09-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This class reads html document and applays changes.
 */
public class HTMLParser { private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
    private final Long RIGHT_LIMITH = 31556952000L;

    public void constructDocument(Document doc, String headOfArticle, String paragraph, String query) throws IOException {
        ArticleAuthor articleAuthor = new ArticleAuthor(new FileContent().contentToString("E:\\Projects\\ai\\futurebutton\\future.button\\lib\\Ivan_Vazov_-_Pod_igoto_-1773-b.txt"));
              Elements titles = doc.select(headOfArticle);
        Elements articles = doc.select(paragraph);
        for (int i = 0; i < titles.size(); i++) {
            FutureDate futureDate = new FutureDate(RIGHT_LIMITH);
            String title = " Date: " + dateFormat.format(new Date(futureDate.generateDate()))+ " " + query + " " + articleAuthor.writeTitle();
            String content = query + " " + articleAuthor.writeArticle(10);
            Element head = titles.select(headOfArticle).get(i);
            head.text(title);
            Element article = articles.select(paragraph).get(i + 1);
            article.text(content + ".");
        }
    }
}
