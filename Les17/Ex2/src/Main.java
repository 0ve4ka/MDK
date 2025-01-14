public class Main {

    public static String[] readPoem() {
        return new String[]{
                "   Это кто там ложку «ложит»?",
                "",
                "   ",
                "Знай, такого быть не может!",
                "  Ложку мы на стол кладём,  ",
                "",
                "А тебя – к обеду ждём."
        };
    }

    public static String fixPoem(String[] poem) {
        // код метода
        StringBuilder result = new StringBuilder();
        for (String line: poem){
            if(line.isBlank() || line.isEmpty())
                continue;
            result.append(line.trim() + "\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String[] poem = readPoem();
        String poemAsString = fixPoem(poem);
        System.out.println(poemAsString);
    }
}