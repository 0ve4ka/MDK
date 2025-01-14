public class Main {
    static public boolean isPalindromeWord(String str) {
        // ваш код
        StringBuilder stringBuilder = new StringBuilder(str);
        return str.equals(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {

        System.out.println(isPalindromeWord("казак"));
    }
}