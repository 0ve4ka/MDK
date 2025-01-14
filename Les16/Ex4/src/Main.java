public class Main {
    public static void main(String[] args) {

        System.out.println(capitalize("я не волшебник, я только учусь!"));
    }
    public static String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}