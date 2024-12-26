package Les4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.BIKE,0);

        Assertions.assertEquals(-1,result);
    }

    @Test
    public void shouldReturn100ForBikeAndDistanceIs10Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.BIKE,10);

        Assertions.assertEquals(100F,result);
    }

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs21Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.BIKE,21);

        Assertions.assertEquals(-2,result);
    }


    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.CAR,0);

        Assertions.assertEquals(-1,result);
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1001Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.CAR,1001);

        Assertions.assertEquals(-2,result);
    }

    @Test
    public void shouldReturn7000ForCarAndDistanceIs1000Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.CAR,1000);

        Assertions.assertEquals(7000,result);
    }


    @Test
    public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.TRUCK,0);

        Assertions.assertEquals(-1,result);
    }

    @Test
    public void shouldReturn5000ForTruckAndDistanceIs1000Km() {
        // ваш код
        int result = priceCalculator.calculatePrice(TransportType.TRUCK,1000);

        Assertions.assertEquals(5000,result);
    }

    @Test
    public void shouldBeNullWhenDroneAndDistanceIs0Km() {
        // ваш код
        Integer result = priceCalculator.calculatePrice(TransportType.DRONE,0);

        Assertions.assertNull(result);
    }
}