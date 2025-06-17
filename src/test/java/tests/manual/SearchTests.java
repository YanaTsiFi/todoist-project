package tests.manual;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("MANUAL")
public class SearchTests {

    @Test
    @Disabled("Ручной тест — не запускается автоматически")
    @DisplayName("Проверка поиска в профиле")
    public void shouldSearchCorrectlyInProfile() {
        /*
         Предусловие: Пользователь авторизован и находится в разделе "Профиль"

         Шаги:
         1. Кликнуть на иконку поиска или в строку поиска
         2. Ввести запрос, например: "настройки"
         3. Убедиться, что отображаются релевантные результаты
         4. Кликнуть по одному из результатов
         5. Убедиться, что открылась соответствующая страница или раздел

         Ожидаемый результат:
         Система корректно обрабатывает поисковой запрос и отображает релевантные результаты
         */
    }
}

