package user.query.date;

import java.util.Random;

/**
 * Created on 09-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class FutureDate {
    private long currentTimeMillis= System.currentTimeMillis();
    private final Long RIGHT_LIMITH;

    public FutureDate(Long right_limith) {
        RIGHT_LIMITH = right_limith;
    }

    public long generateDate(){
        Random random = new Random();
        return currentTimeMillis  + ((long) (random.nextDouble() * (RIGHT_LIMITH - currentTimeMillis)));
    }

}
