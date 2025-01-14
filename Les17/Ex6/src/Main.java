import java.util.ArrayList;
import java.util.List;

public class Main {
    static String gradeStringToInt(String grade) {
        switch (grade) {
            case "Безупречно": {
                return "5";
            }
            case "Потрясающе": {
                return "4";
            }
            case "Восхитительно": {
                return "3";
            }
            case "Прекрасно": {
                return "2";
            }
            default:
                return "1";
        }
    }

    static String serializeGrades(String[] grades) {
        // реализуйте метод здесь
        List<String> result = new ArrayList<>();
        for(String grade: grades){
            String[] temp = grade.split(" ");
            String name = temp[0].toLowerCase();
            String SureName = temp[1].toLowerCase();
            String object = temp[2];
            String g = gradeStringToInt(temp[4]);
            result.add(String.join(",",name,SureName,object,g));
        }
        return String.join(";",result);
    }
    public static void main(String[] args) {
        System.out.println(serializeGrades(new String[]{"Вероника Чехова физика — Безупречно","Анна Строкова математика — Потрясающе","Иван Петров геометрия — Безупречно"}));
    }
}