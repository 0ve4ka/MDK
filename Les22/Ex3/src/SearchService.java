import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SearchService {
    // Создаём объект класса, отвечающий за склад магазина
    private final Warehouse warehouse = new Warehouse();
    // Создаём объект класса, отвечающий за работу с поставщиками
    public final SRM srm = new SRM();

    // Основной метод поиска
    // Проверяет наличие товара с указанным именем на складе магазина
    // Если товар отсутствует, то проверяются склады поставщиков,
    // предпочтение отдаётся тому поставщику, у которого наименьшая цена товара.
    // Для поиска товара на складе поставщиков используется метод supplierSearch
    // Если товар нигде не найден, то возвращается пустой Optional
    public Optional<Candy> search(String candyName) {
        // Реализуйте данный метод, с использованием методов Optional
        Optional<Candy> candy1 = warehouse.search(candyName);
        Optional<Candy> candy2 = supplierSearch(candyName);
        if(candy1.isPresent())
            return candy1;
        return candy2;
    }

    // Ищет товар с указанным именем на складах поставщиков
    // Возвращает Optional с самым дешевым вариантом товара среди всех
    // поставщиков или пустой Optional, если товар не найден
    private Optional<Candy> supplierSearch(String candyName) {
        // Реализуйте данный метод при помощи Stream API и Optional,
        // используйте метод min из Stream API для нахождения товара с наименьшей ценой
        Set<Candy> candies = new HashSet<>();
        for(String str: srm.listSuppliers()){
            if(srm.getProduct(str,candyName).isPresent())
                candies.add(srm.getProduct(str,candyName).get());
        }
        return candies.stream().min(Comparator.comparing(t->t.price));
    }
}