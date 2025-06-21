package tests.manual;

import annotations.Manual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.label;
import static io.qameta.allure.Allure.step;

public class SidebarTests {

    @Test
    @Manual
    @DisplayName("Открытие и закрытие боковой панели в профиле")
    public void shouldOpenAndCloseSidebar() {
        label("ALLURE_MANUAL", "true");

        step("Предусловие: Пользователь авторизован");
        step("Перейти в раздел 'Профиль'");
        step("Нажать кнопку открытия боковой панели");
        step("Убедиться, что панель открылась");
        step("Нажать кнопку закрытия");
        step("Убедиться, что панель закрылась");
        step("Ожидаемый результат: Панель корректно появляется и исчезает");
    }
}
