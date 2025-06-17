package tests.manual;

import annotations.Manual;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddTeamTests {

    @Test
    @Manual
    @Disabled("Ручной тест")
    @DisplayName("Добавление новой команды в профиле")
    public void shouldAddNewTeamFromProfile() {
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
