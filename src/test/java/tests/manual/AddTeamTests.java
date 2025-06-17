package tests.manual;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("MANUAL")
public class AddTeamTests {

    @Test
    @Disabled("Ручной тест — не запускается автоматически")
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
