public class Main {
    static int  numberOfRepeats(String text, String substring) {
        int count = 0;
        // код метода
        StringBuilder txt = new StringBuilder(text);
        while(txt.indexOf(substring) != -1){
            txt.delete(txt.indexOf(substring),txt.indexOf(substring) + substring.length());
            count++;
        }
        return count;
    }
    public static void main(String[] args) {

        int count = numberOfRepeats("раз, раз, раз, раз", "раз");
        System.out.println(count);
    }
}