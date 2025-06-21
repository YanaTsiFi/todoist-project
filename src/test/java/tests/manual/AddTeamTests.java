package tests.manual;

import annotations.Manual;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddTeamTests {

    @Test
    @Manual
    @DisplayName("Добавление новой команды в профиле")
    public void shouldAddNewTeamFromProfile() {
        Allure.label("ALLURE_MANUAL", "true");
        boolean isManualTestRun = Boolean.getBoolean("manual.test.run");
        Assumptions.assumeTrue(isManualTestRun, "Это ручной тест!");
        /*
         Предусловие: Пользователь авторизован и находится в разделе "Профиль"

         Шаги:
         1. Перейти в раздел "Команды" или аналогичный
         2. Нажать на кнопку "Добавить команду"
         3. Заполнить обязательные поля (например: название, участники)
         4. Подтвердить создание команды
         5. Убедиться, что команда появилась в списке

         Ожидаемый результат:
         Новая команда успешно создаётся и отображается в интерфейсе
         */
    }
}
