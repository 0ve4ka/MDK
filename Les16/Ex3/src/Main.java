public class Main {
    public static void main(String[] args) {
        FindRepeats check = new FindRepeats();
        int count = check.numberOfRepeats("раз, раз, раз, раз", "раз");
        System.out.println(count);
    }
}
class FindRepeats {
    int numberOfRepeats(String text, String substring) {
        int i = 0;
        while (text.contains(substring)){
            i++;
         text =  text.replaceFirst(substring,".");
        }
        return i;
    }
}
