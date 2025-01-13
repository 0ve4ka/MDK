import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedHashSet<String> songs = new LinkedHashSet<>();
        fillSongs(songs);

        System.out.println("Количество песен: " + songs.size());

        System.out.println("Песни:");
        for (String song : songs) {
            System.out.println("  * " + song);
        }

    }
    private static void fillSongs(LinkedHashSet<String> songs) {
        songs.add("Sting – Shape Of My Heart");
        songs.add("Gorillaz – Clint Eastwood");
        songs.add("Lady Gaga – Bad Romance");
        songs.add("Taylor Swift – Wildest Dreams");
        songs.add("Ariana Grande – 7 rings");
        songs.add("Depeche Mode – Personal Jesus");
        songs.add("Gorillaz – Clint Eastwood");
        songs.add("Lady Gaga – Bad Romance");
        songs.add("Bruno Mars – Talking To The Moon");
        songs.add("Taylor Swift – Wildest Dreams");
    }
}