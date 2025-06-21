package tests.manual;

import annotations.Manual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.label;
import static io.qameta.allure.Allure.step;

public class AddTeamTests {

    @Test
    @Manual
    @DisplayName("Добавление новой команды в профиле")
    public void shouldAddNewTeamFromProfile() {
        label("ALLURE_MANUAL", "true");

        step("Предусловие: Пользователь авторизован и находится в разделе 'Профиль'");
        step("Нажать на кнопку 'Добавить команду'");
        step("Заполнить обязательные поля (например: название)");
        step("Подтвердить создание команды");
        step("Убедиться, что команда появилась в списке");
        step("Ожидаемый результат: Новая команда успешно создаётся и отображается в интерфейсе");
    }
}
