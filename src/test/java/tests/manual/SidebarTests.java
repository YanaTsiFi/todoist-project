package tests.manual;

import annotations.Manual;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SidebarTests {

    @Test
    @Manual
    @Disabled("Ручной тест – выполняется вручную через TestOps")
    @DisplayName("Открытие и закрытие боковой панели в профиле")
    public void shouldOpenAndCloseSidebar() {
        Allure.label("ALLURE_MANUAL", "true");
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
