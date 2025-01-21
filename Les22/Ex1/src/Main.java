import java.util.Optional;
import java.util.Scanner;


public class Main {

    static Optional<String> requestUserName() {
        //Здесь должен быть запрос к пользователю, но пока его не реализовали
        //Поместите в переменную username имя пользователя или оставьте ее пустой, если имя скрыто
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите своё имя (Если хотите остаться анонимным, просто нажмите enter): ");
        String username = scanner.nextLine();

        if (username.isBlank()) {
            //вставьте код здесь
            return Optional.empty();
        } else {
            //вставьте код здесь
            return Optional.of(username);
        }
    }

    public static void main(String[] args) {
        Optional<String> maybeName = requestUserName();
        if (maybeName.isPresent()/*вставьте код здесь*/) {
            //вставьте код здесь
            String name = maybeName.get();;
            System.out.println("Привет, " + name + "!");
        } else {
            System.out.println("Ваше право не называть имя!");
        }
    }
}
