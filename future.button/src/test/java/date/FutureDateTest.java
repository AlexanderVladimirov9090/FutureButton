package date;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created on 20-Aug-17
 *
 * @author Alexander Vladimirov
 * <alexandervladimirov1902@gmail.com>
 */
public class FutureDateTest {
    private final Long RIGHT_LIMIT = 31556952000L;

    @Test
    public void dateGreaterThanCurrentTIme() {
        FutureDate futureDate = new FutureDate(RIGHT_LIMIT);
        Long currentTime = System.currentTimeMillis();
        assertTrue(futureDate.generateAsLong() > currentTime);

    }

}