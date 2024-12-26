import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potato> potatoes = List.of(
                new Potato(1, 30, 30, 30),
                new Potato(2, 35, 31, 35),
                new Potato(3, 40, 35, 44),
                new Potato(4, 28, 44, 41),
                new Potato(5, 33, 23, 30),
                new Potato(6, 35, 33, 33),
                new Potato(7, 38, 41, 24)
        );

        //Для проверки
        for(Potato potato:potatoes)
            System.out.println((int)potato.getAlpha());

        List<Potato> fourUnderExperiment = findPotatoesForExperiment(potatoes);

        System.out.println("Картофелины для эксперимента: " + fourUnderExperiment);
    }

    private static List<Potato> findPotatoesForExperiment(List<Potato> potatoes) {
        potatoes = new ArrayList<>(potatoes);
				/* Вычислите две самые большие и две самые маленькие картофелины,
           а затем выведите их в порядке от самых маленьких до самых больших.*/
        Potato min1 = Collections.min(potatoes);
        Potato max1 = Collections.max(potatoes);

        //для проверки
        System.out.println(min1);
        System.out.println(max1);

        potatoes.remove(min1);
        potatoes.remove(max1);

        Potato min2 = Collections.min(potatoes);
        Potato max2 = Collections.max(potatoes);

        //для проверки
        System.out.println(min2);
        System.out.println(max2);

        return new ArrayList<>(List.of(min1,min2,max1,max2));
    }
}
