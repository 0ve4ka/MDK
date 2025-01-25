
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


enum SubtitleLanguage {
en,ru,cn
}

class SubtitleItem {
    Map<SubtitleLanguage,String> values = new HashMap<>();

    LocalTime begin;

    LocalTime end;

    // геттеры и сеттеры


    public Map<SubtitleLanguage, String> getValues() {
        return values;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setValues(Map<SubtitleLanguage, String> values) {
        this.values = values;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        return Objects.equals(((SubtitleItem) o).getBegin(),begin) &&
                Objects.equals(end,((SubtitleItem) o).getEnd()) &&
                Objects.equals(values,((SubtitleItem) o).getValues());
    }

    @Override
    public int hashCode() {
       return values.hashCode()*17+begin.hashCode()*31+ end.hashCode()*17;
    }

    public SubtitleItem(Map<SubtitleLanguage,String> values,LocalTime begin,LocalTime end) {
			this.values = values;
            this.begin = begin;
            this.end = end;
    }
}

class SubtitleListTypeToken extends TypeToken<List<SubtitleItem>> {

        }

class LocalTimeTypeAdapter extends TypeAdapter<LocalTime> {
private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

@Override
public void write(final JsonWriter jsonWriter, final LocalTime localTime) throws IOException {
    jsonWriter.value(localTime.format(timeFormatter));
}

@Override
public LocalTime read(JsonReader jsonReader) throws IOException {
return LocalTime.parse(jsonReader.nextString(),timeFormatter);
}
}

public class Main {

    public static void main(String[] args) {
        List<SubtitleItem> subtitles = Arrays.asList(
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Здравствуйте!",
                        SubtitleLanguage.en, "Hello!",
                        SubtitleLanguage.cn, "Ni hao"),
                        LocalTime.of(0, 0, 15),
                        LocalTime.of(0, 0, 17)
                ),
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Привет!",
                        SubtitleLanguage.en, "Hi!",
                        SubtitleLanguage.cn, "Ni hao"),
                        LocalTime.of(0, 0, 21),
                        LocalTime.of(0, 0, 24)
                ),
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Как дела?",
                        SubtitleLanguage.en, "How are you?",
                        SubtitleLanguage.cn, "Ni hao ma"),
                        LocalTime.of(0, 0, 28),
                        LocalTime.of(0, 0, 31)
                ),
                new SubtitleItem(Map.of(SubtitleLanguage.ru, "Всё хорошо, спасибо!",
                        SubtitleLanguage.en, "I'm fine, thank you!",
                        SubtitleLanguage.cn, "Wo hen hao, xie xie"),
                        LocalTime.of(0, 0, 34),
                        LocalTime.of(0, 0, 37)
                )
        );

        // адаптер для преобразования типа LocalTime в String в формате субтитров
        LocalTimeTypeAdapter localTimeTypeAdapter = new LocalTimeTypeAdapter();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(LocalTime.class,localTimeTypeAdapter);
        Gson gson = gsonBuilder.create();

        String subtitlesJson = gson.toJson(subtitles);
        System.out.println(subtitlesJson);

        List<SubtitleItem> parsed = gson.fromJson(subtitlesJson, new SubtitleListTypeToken().getType());
        if(parsed.equals(subtitles)) {
            System.out.println("Субтитры десериализованы корректно.");
        } else {
            System.out.println("Произошла ошибка при десериализации.");
        }
    }
}



