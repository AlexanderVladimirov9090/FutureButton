package user.query.date;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created on 09-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class FutureDate {
    private long currentTimeMillis= System.currentTimeMillis();
    private final Long rightLimith;

    public FutureDate(Long right_limith) {
        this.rightLimith = right_limith;
    }

    public long generateDate(){
        Random random = new Random();

        return currentTimeMillis  + (long) (random.nextDouble() * (rightLimith+currentTimeMillis));
    }

}
