package date;

import java.util.Random;

/**
 * Created on 09-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 *     This class generates random future date.
 */
public class FutureDate {
    private long currentTimeMillis= System.currentTimeMillis();
    private final Long rightLimit;

    public FutureDate(Long rightLimit) {
        this.rightLimit = rightLimit;
    }

    /**
     * Generates random future date for the article.
     * @return Random future date.
     */
    public long generateAsLong(){
        Random random = new Random();

        return currentTimeMillis  + (long) (random.nextDouble() * (rightLimit +currentTimeMillis));
    }

}
