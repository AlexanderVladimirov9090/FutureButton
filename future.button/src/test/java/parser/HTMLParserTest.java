package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created on 20-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class HTMLParserTest {

    @Test
    public void readFile() throws IOException {
        HTMLParser htmlParser = new HTMLParser();
        Document doc = Jsoup.parse(new File(new File("").getAbsolutePath()+"\\src\\test\\resources\\executedquery.html"), "utf-8");
        htmlParser.constructDocument(doc,"headline","p","hello");
    }

}