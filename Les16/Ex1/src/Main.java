public class Main {
    public static void main(String[] args) {
        System.out.println(fixString("  "));
        System.out.println(fixString(""));
        System.out.println(fixString("  life  "));
    }

    public static String fixString(String str){
        if(str.isEmpty() || str.isBlank())
            return "Вы ничего не ввели!";
        return str.trim();
    }
}