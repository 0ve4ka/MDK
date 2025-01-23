
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    private ZonedDateTime currentTime;
    private int numOfZone;
    private final List<String> zones = Arrays.asList("America/New_York", "Asia/Vladivostok", "Europe/Moscow");

    public Main() {
        numOfZone = 0;
        ZoneId zone = ZoneId.of(zones.get(numOfZone));
        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 26, 0, 0);
        currentTime = ZonedDateTime.of(dateTime, zone);
    }

    public void changeTimeZone() {
        numOfZone += 1;
        if(numOfZone == 3)
            numOfZone = 0;
        ZoneId newZone = ZoneId.of(zones.get(numOfZone));
        // смените временную зону (время должно остаться прежним)
        currentTime =ZonedDateTime.of(currentTime.toLocalDateTime(),newZone);
    }

    public void addTenHours() {
        // увеличьте текущее время на 10 часов
       currentTime = currentTime.plusHours(10);
    }

    public void addHour() {
        // увеличьте текущее время на 1 час
        currentTime = currentTime.plusHours(1);
    }

    public void addTenMinutes() {
        // увеличьте текущее время на 10 минут
        currentTime = currentTime.plusMinutes(10);
    }

    public void addMinute() {
        // увеличьте текущее время на 1 минуту
        currentTime = currentTime.plusMinutes(1);
    }

    public ZonedDateTime getCurrentTime() {
        // верните текущее время
        return currentTime;
    }
}

class Practicum {
    public static void main(String[] args) {
        Main watch = new Main();
        int f = -1;
        Scanner scanner = new Scanner(System.in);
        // настройка часов
        while(true) {
            System.out.println("Что сделать?");
            System.out.println("0) Выход:");
            System.out.println("1) Изменить текущую зону на следующую.");
            System.out.println("2) Сдвинуть время на 10 часов вперёд.");
            System.out.println("3) Сдвинуть время на 1 час вперёд.");
            System.out.println("4) Сдвинуть время на 10 минут вперёд.");
            System.out.println("5) Сдвинуть время на 1 минуту вперёд.");
            f = scanner.nextInt();
            if(f == 0)
                break;
            switch (f) {
                case 1:
                    watch.changeTimeZone();
                case 2:
                    watch.addTenHours();
                case 3:
                    watch.addHour();
                case 4:
                    watch.addTenMinutes();
                case 5:
                    watch.addMinute();
            }

            System.out.println(watch.getCurrentTime());
        }
    }
}
