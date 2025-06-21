package tests.manual;

import annotations.Manual;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTests {

    @Test
    @Manual
    @DisplayName("Проверка поиска в профиле")
    public void shouldSearchCorrectlyInProfile() {
        Allure.label("ALLURE_MANUAL", "true");
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
