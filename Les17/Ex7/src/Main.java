import java.util.Scanner;

public class Main {
    public static void printCheck(String[] items) {
      // ваш код
        StringBuilder stringBuilder = new StringBuilder();
        for(String item: items){
            String result = "";
            String[] temp = item.split(",");
            stringBuilder.append(String.format("%-10s%-10s%-10s",temp[0],temp[1],temp[2]) + "\n");
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество записей:");
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = new String[n];
        for (int i=0; i<n; ++i)
            values[i] = scanner.nextLine();
        printCheck(values);
    }
}