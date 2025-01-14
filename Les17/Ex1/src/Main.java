

public class Main {
    public static void main(String[] args) {
        String start = "Привет! Меня зовут ";
        StringBuilder hello = new StringBuilder();
        // создайте StringBuilder с началом start
        hello.append("<ваше имя>");
        hello.append(". Я из города ");
        hello.append("<ваш город>");
        // добавьте подстроку "<ваше имя>"

        // добавьте подстроку ". Я из города "
        // добавьте подстроку "<ваш город>."



        String asString = start + hello.toString();
        System.out.println(asString);


    }
}