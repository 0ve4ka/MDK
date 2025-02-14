import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                printMenu();
                String command = scanner.nextLine();

                System.out.println("Введите путь к файлу/директории: ");
                String enteredPath = scanner.nextLine();
                Path path = Paths.get(enteredPath);// создайте переменную пути
                if (! (path.toFile().isFile() || path.toFile().isDirectory())){ // проверьте, не ошибся ли пользователь
                    System.out.println("Введённый путь не существует.");
                    break;
                }
                switch (command) {
                    case "exit":
                        System.out.println("Выход.");
                        System.exit(0); // пользователь хочет найти выход, выход есть всегда
                        break;
                    case "ls":
                        try {
                            for (String element : path.toFile().list()){
                                System.out.println(element);
                            }
                        } catch (Exception e) {
                            System.out.println("Произошла ошибка при запросе содержимого директории.");
                            e.printStackTrace();
                        }
                        break;

                    case "mkdir":
                        try {
                            Files.createDirectory(Paths.get(path + "/" + scanner.next()));
                        } catch (IOException e) {
                            System.out.println("Произошла ошибка при создании директории.");
                            e.printStackTrace();
                        }
                        break;
                    case "touch":
                        try {
                        Files.createFile(Paths.get(path + "/" + scanner.next()));
                        } catch (IOException e) {
                            System.out.println("Произошла ошибка при создании файла.");
                            e.printStackTrace();
                        }
                        break;
                    case "rename":
                        System.out.println("Введите новое имя файла/директории: ");
                        String newName = scanner.nextLine();
                        try {
                            Files.move(path, Paths.get(path.toString().replaceFirst(path.getFileName().toString(),newName)),StandardCopyOption.REPLACE_EXISTING);// с помощью опции StandardCopyOption.REPLACE_EXISTING
                        } catch (IOException e) {
                            System.out.println("Произошла ошибка при переименовании файла/директории.");
                            e.printStackTrace();
                        }
                        break;
                    case "rm_file":
                        try {
                            if (! path.toFile().isDirectory()){
                                Files.deleteIfExists(path);
                            } else{
                                System.out.println("С помощью этой команды можно удалить только файл!");
                            }
                        } catch (IOException e) {
                            System.out.println("Произошла ошибка при удалении файла.");
                            e.printStackTrace();
                        }
                    default:
                        System.out.println("Извините, такой команды пока нет.");
                }

            }
        }

        public static void printMenu () {
            System.out.println("Что вы хотите сделать? ");
            System.out.println("ls - посмотреть содержимое директории.");
            System.out.println("mkdir - создать директорию.");
            System.out.println("touch - создать файл.");
            System.out.println("rename - переименовать директорию/файл.");
            System.out.println("rm_file - удалить файл.");
            System.out.println("exit - выход.");
        }
    }
