import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> cities = new HashSet<>();
        cities.add("Москва");

        System.out.println("Есть ли в множестве Москва?");
        System.out.println(cities.contains("Москва"));

    }
}