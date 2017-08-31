package author;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created on 09-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This class generates a text based on given information.
 * */
public class ArticleAuthor extends RandomTextGenerator {
    private final HashMap<WordSet, ArrayList<String>> wordMap;

    public ArticleAuthor(String text) {
        super(text);
        wordMap = new HashMap<>();
        makeWordMap();
    }

    /**
     * Generates text of an article.
     * @param amountOfWord how many words will be used to generate article.
     * @return string of generated article.
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