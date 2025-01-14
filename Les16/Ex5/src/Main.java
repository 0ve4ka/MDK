public class Main {
    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String fixText(String text) {

        text = text.trim();
        text = capitalize(text);

        text = text.replace("“","»");
        text = text.replace("„","«");

        text = text.replaceFirst("цевилизаций","цивилизаций");
        return text;
        
    }

    public static void main(String[] args) {
        String text = "    история каждой из крупных галактических цевилизаций может быть разделена на три различные, " +
                "ярко выраженные фазы: Борьба за выживание, Любопытство и Утонченность, также именуемые фазами " +
                "„Как?“, „Зачем?“ и „Где?“. Пример: если для первой фазы характерен вопрос: „Как бы нам поесть?“," +
                " а для второй „Зачем мы едим?“, то третья отличается вопросом: „Где бы нам лучше поужинать?“.   ";

        var fixedText = fixText(text);
        System.out.println(fixedText);
    }
}