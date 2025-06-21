package tests.manual;

import annotations.Manual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.label;
import static io.qameta.allure.Allure.step;

public class SearchTests {

    @Test
    @Manual
    @DisplayName("Проверка поиска в профиле")
    public void shouldSearchCorrectlyInProfile() {
        label("ALLURE_MANUAL", "true");

        step("Предусловие: Пользователь авторизован и находится в разделе 'Профиль'");
        step("Кликнуть на иконку поиска");
        step("Ввести запрос, например: 'настройки'");
        step("Убедиться, что отображаются релевантные результаты");
        step("Кликнуть по одному из результатов");
        step("Убедиться, что открылась соответствующая страница");
        step("Ожидаемый результат: Система корректно обрабатывает поисковой запрос и отображает релевантные результаты");
    }
}
