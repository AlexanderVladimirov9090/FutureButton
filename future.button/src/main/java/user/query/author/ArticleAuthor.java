package user.query.author;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This version of the RandomTextGenerator maps all the words following the WordSet
 * into a HashMap to make the text generation faster. It does use more space to
 * do this however.
 * n = size of input text
 * m = number of words to be generated
 * The time complexity of this algorithm is O(n);
 * The space complexity of this algorithm is O(n);
 * */
public class ArticleAuthor extends RandomTextGenerator {

    private final HashMap<WordSet, ArrayList<String>> wordMap;

    public ArticleAuthor(String text) {
        super(text);
        wordMap = new HashMap<>();
        makeWordMap();
    }

    /**
     * Generates title for an article.
     * @return title of article.
     */
    public String writeTitle() {
        return this.writeArticle(5);
    }

    /**
     * Generates text of an article.
     * @param amountOfWord how many words to be the article.
     * @return body of the article.
     */
    public String writeArticle(int amountOfWord) {
            return this.generateText(amountOfWord);
    }

    @Override
    public ArrayList<String> getFollowingWords(WordSet set) {
        return wordMap.get(set);
    }

    private void makeWordMap() {
        for (int i = 0; i < text.length - SETSIZE; i++) {
            WordSet set = new WordSet(text, i);
            String nextWord = text[i + SETSIZE];
            if (wordMap.containsKey(set))
                wordMap.get(set).add(nextWord);
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(nextWord);
                wordMap.put(set, list);
            }
        }
    }

}