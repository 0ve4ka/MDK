import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
try {
    Map<String, Integer> frequencyMap = new HashMap<>();


    FileReader reader = new FileReader("src/result.txt");
    BufferedReader br = new BufferedReader(reader);

    // читайте файл построчно и сразу обновляйте frequencyMap.
    while(br.ready()){
        String str = br.readLine();
        if(frequencyMap.get(str) == null)
            frequencyMap.put(str, 1);
        else
            frequencyMap.put(str, frequencyMap.get(str)+1);

    }
    br.close();
    // выведите результат в формате "<буква>: <количество>".
    for(Map.Entry<String, Integer> str:  frequencyMap.entrySet())
        System.out.println(str.getKey() + ": " + str.getValue());
}
catch (IOException e){
    System.out.println(e.getMessage());
}
        }
    }
