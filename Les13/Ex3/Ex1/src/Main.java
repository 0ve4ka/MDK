
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<String> passengerNames = List.of(
            // Пример списка пассажиров (на самом деле их больше)
            "Василий Петров",
            "Анна Ягирская",
            "Виктория Сотова",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    public static void main(String[] args) {
        Map<String, Integer> seats = assignSeats(passengerNames);
        System.out.println("Места пассажиров: " + seats);

    }
    public static Map<String, Integer> assignSeats(List<String> passengerNames) {
        // Тут нужно написать код, который будет распределять места в самолёте ✈️
        Map<String, Integer> result = new HashMap<>();

        int i = 0;

        for (String name : passengerNames) {
            i++;
            result.put(name,i);
        }

        return result;
    }
}