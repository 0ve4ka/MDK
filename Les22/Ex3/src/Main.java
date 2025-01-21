import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Доработайте данный метод, чтобы на экран выводилось 
        // сообщение в соответствии с заданием

        SearchService searchService = new SearchService();

        Optional<Candy> candy = searchService.search("Африка");

        if(candy.isPresent()){
            Candy t = candy.get();
            System.out.println("Товар \""+t.name +"\" доступен в количестве "+ t.amount+" кг по цене "+t.price+" руб за кг\" ");
        }


    }
}