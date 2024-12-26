package Les3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FortuneCookieFactoryTest {

    private static FortuneCookieFactory factory;

    @BeforeAll
    public static void beforeAll() {
        FortuneConfig config = new FortuneConfig(true);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        factory = new FortuneCookieFactory(config,
                positive,
                negative
        );
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        // ваш код
        factory.bakeFortuneCookie();
        int result = factory.getCookiesBaked();

        Assertions.assertEquals(1,result);
    }
    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        // ваш код
        factory.bakeFortuneCookie();
        int result = factory.getCookiesBaked();

        Assertions.assertEquals(2,result);

    }
    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        // ваш код
        factory.resetCookiesCreated();
        int result = factory.getCookiesBaked();

        Assertions.assertEquals(0,result);
    }
}