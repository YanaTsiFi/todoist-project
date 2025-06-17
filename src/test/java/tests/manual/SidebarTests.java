package tests.manual;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("MANUAL")
public class SidebarTests {

    @Test
    @Disabled("Ручной тест — не запускается автоматически")
    @DisplayName("Открытие и закрытие боковой панели в профиле")
    public void shouldOpenAndCloseSidebar() {
        /*
         Предусловие: Пользователь авторизован

         Шаги:
         1. Перейти в раздел "Профиль"
         2. Нажать кнопку открытия боковой панели
         3. Убедиться, что панель открылась
         4. Нажать кнопку закрытия
         5. Убедиться, что панель закрылась

         Ожидаемый результат:
         Панель корректно появляется и исчезает
         */
    }
}
