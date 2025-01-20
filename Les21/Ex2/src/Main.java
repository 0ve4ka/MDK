@FunctionalInterface//добавьте аннотацию
interface Summator {
    int sum(int n1, int n2);
}

public class Main {

    public static void main(String[] args) {
        // сохраните лямбду в переменную
        // лямбда должна складывать два целых числа
        Summator summator = (n1, n2) -> {return n1+n2;};
        // допишите код, использующий лямбду

        int result = summator.sum(23,65);

        System.out.println("Сумма 23 и 65 равна " + result);
    }
}

