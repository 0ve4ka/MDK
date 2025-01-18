import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private HeaderDecorator headerDecorator;
    private List<LineProcessor> lineProcessors = new ArrayList<>();

    public static void main(String[] args) {
        Main bookEditor = new Main();

        bookEditor.setHeaderDecorator((String temp) -> {return temp.toUpperCase() + "\n";});
        bookEditor.addLineProcessor((String line) -> {return line.substring(0, 1).toUpperCase() + line.substring(1);});

        List<String> content = Arrays.asList(
                "Приключения Java-программиста",
                "История началась рано утром, ",
                "когда программист вышел из дома, ",
                "решив выпить утренний кофе."
        );

        List<String> resultContent = bookEditor.processText(content);
        for(String result: resultContent)
            System.out.println(result);
    }

    public List<String> processText(List<String> sourceText) {
        List<String> resultText = new ArrayList<>();

        String sourceHeader = sourceText.get(0);
        String decoratedHeader = headerDecorator.decorate(sourceHeader);
        resultText.add(decoratedHeader);

        for (int i=1; i<sourceText.size(); i++) {
            String currentLine = sourceText.get(i);
            for (LineProcessor processor: lineProcessors) {
                currentLine = processor.processLine(currentLine);
            }
            resultText.add(currentLine);
        }

        return resultText;
    }

    public void setHeaderDecorator(HeaderDecorator headerDecorator) {
        this.headerDecorator = headerDecorator;
    }

    public void addLineProcessor(LineProcessor lineProcessor) {
        this.lineProcessors.add(lineProcessor);
    }
}

interface HeaderDecorator {
    String decorate(String header);
}

interface LineProcessor {
    String processLine(String line);
}
