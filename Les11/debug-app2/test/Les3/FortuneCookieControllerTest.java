package Les3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FortuneCookieControllerTest {

    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;

    public static FortuneCookieFactory create(boolean isPositive) {
        FortuneConfig config = new FortuneConfig(isPositive);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        return new FortuneCookieFactory(config,
                positive,
                negative
        );
    }

    @BeforeAll
    public static void BeforeAll() {
        goodFactoryController = new FortuneCookieController(create(true));
        badFactoryController = new FortuneCookieController(create(false));
    }

    @Test
    public void shouldReturnPositiveFortune() {
        String reusult = goodFactoryController.tellFortune().getFortuneText();

        Assertions.assertEquals("positive",reusult);
    }

    @Test
    public void shouldReturnNegativeFortune() {
        // ваш код
        String reusult = badFactoryController.tellFortune().getFortuneText();

        Assertions.assertEquals("negative",reusult);
    }
}