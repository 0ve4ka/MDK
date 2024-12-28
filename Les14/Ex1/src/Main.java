import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<String, String> films = new LinkedHashMap<>();
    public static void main(String[] args) {

        films.put("Титаник", "Джеймс Кэмерон");
        films.put("Гарри Поттер и философский камень", "Крис Коламбус");
        films.put("Хакеры", "Иэн Софтли");
        films.put("Терминатор", "Джеймс Кэмерон");

        for (String film : films.keySet()) {
            System.out.println(film);
        }
    }
}