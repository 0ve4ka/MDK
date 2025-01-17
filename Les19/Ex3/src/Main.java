import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество участников: ");
        int playersNumber = scanner.nextInt();

        List<String> words = readWordsFromFile("src/words.txt");

        // если слов меньше, чем участников, то выведите сообщение:
        // "Недостаточно слов в файле. Добавьте слова и обновите файл."
        // и завершите выполнение программы

        if(words.size() < playersNumber) {
            System.out.println("Недостаточно слов в файле. Добавьте слова и обновите файл.");
            System.exit(0);
        }

        // воспользуйтесь статическим методом Collections.shuffle(List<?> list),    
        // чтобы поменять порядок слов случайным образом
        Collections.shuffle(words);

        int wordsNumber = words.size() / playersNumber;

        for (int i = 0; i < playersNumber; i++) {
            String filename = String.format("src/player%s.txt", i + 1);
            List<String> subList = words.subList(i * wordsNumber, (i + 1) * wordsNumber);

            writeListToFile(subList, filename);
        }

        System.out.println("Карточки готовы!");
    }

    private static List<String> readWordsFromFile(String filename) {
        // добавьте построчное чтение из файла с помощью BufferedReader
        // в случае ошибки выведите сообщение: "Произошла ошибка во время чтения файла."
        List<String> result = new ArrayList<>();
        try {
            FileReader fileInputStream = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileInputStream);
            while(br.ready()){
                result.add(br.readLine());

            }
            br.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время чтения файла.");
        }
        return  result;
    }

    private static void writeListToFile(List<String> list, String filename) {
        // добавьте запись слов в файл с помощью FileWriter
        // в случае ошибки выведите сообщение: "Произошла ошибка во время записи файла."
        try {
            FileWriter filrWriter = new FileWriter(filename);
            BufferedWriter br = new BufferedWriter(filrWriter);
            for(int i = 0; i<list.size(); i ++){
                br.write(list.get(i)+"\n");
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время записи файла.");
        }
    }
}