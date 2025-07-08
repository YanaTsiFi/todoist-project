# Проект автоматизации тестирования [Todoist](https://www.todoist.com)

<p >
  <a href="https://todoist.com">
    <img src="media/logo/todoist-logo.png" width="600" alt="Todoist Logo">
  </a>
</p>

## 📋 Содержание

- [Описание](#описание)
- [Технологии и инструменты](#технологии-и-инструменты)
- [Реализованные проверки](#реализованные-проверки)
  - [Web](#web)
  - [API](#api)
  - [Mobile](#mobile)
  - [Ручные проверки](#ручные-проверки-управляются-в-allure-testops)
- [Запуск тестов](#запуск-тестов)
  - [Локальный запуск](#локальный-запуск)
  - [Удалённый запуск](#удалённый-запуск)
  - [Запуск в Jenkins](#запуск-в-jenkins)
- [Генерация отчетов](#генерация-отчетов)
- [Allure Report](#allure-report)
  - [Основная страница Allure Report](#1-основная-страница-allure-report)
  - [Просмотр тест-кейсов](#2-просмотр-тест-кейсов-в-allure-report)
  - [Графики и диаграммы](#3-графики-и-диаграммы-с-результатами-тестов)
- [Allure TestOps](#allure-testops)
  - [Основная страница Allure TestOps](#1-основная-страница-allure-testops)
  - [Авто и Ручные тест-кейсы](#2-авто-и-ручные-тест-кейсы)
- [Интеграция с Jira](#интеграция-с-jira)
- [Telegram-уведомления](#telegram-уведомления)
- [Видео из Selenoid](#видео-из-selenoid)
- [Видео из BrowserStack](#видео-из-browserstack)

## Описание

**[Todoist](https://www.todoist.com)** — один из самых популярных сервисов для управления задачами и повышения продуктивности, доступный как в веб-версии, так и на мобильных платформах.

Проект включает в себя автоматизированные UI-тесты для веб-интерфейса Todoist, с реализацией на Java, использованием Selenide, JUnit и Allure Report.

**Особенности проекта**:
- Использование шаблона проектирования `Page Object`
- Гибкая конфигурация через `Owner`
- Возможность запуска тестов:
  - локально
  - удалённо через Selenoid
  - в Jenkins по тегам
- Генерация данных с помощью `Faker`
- Моделирование данных в API-тестах с помощью `Lombok`
- Интеграция с:
  - Allure Report (пошаговые отчёты, скриншоты, видео)
  - Allure TestOps (управление кейсами и запуск из интерфейса)
  - Jira (привязка тестов к задачам)
  - Telegram (уведомления о прохождении тестов)
- Уведомления о статусе тестов приходят автоматически в Telegram-чат
- По завершению каждого запуска формируется Allure-отчёт со следующими данными:
  - Подробные шаги выполнения
  - Скриншот финального состояния страницы
  - Исходный код DOM
  - Консоль браузера
  - Видео выполнения теста (Selenoid и BrowserStack)

## Технологии и инструменты
<p>
  <a href="https://www.jetbrains.com/idea/"><img alt="IntelliJ IDEA" src="media/logo/Idea.svg" width="50" height="50"></a>
  <a href="https://github.com/"><img alt="GitHub" src="media/logo/GitHub.svg" width="50" height="50"></a>
  <a href="https://www.java.com/"><img alt="Java" src="media/logo/Java.svg" width="50" height="50"></a>
  <a href="https://gradle.org/"><img alt="Gradle" src="media/logo/Gradle.svg" width="50" height="50"></a>
  <a href="https://junit.org/junit5/"><img alt="JUnit 5" src="media/logo/Junit5.svg" width="50" height="50"></a>
  <a href="https://selenide.org/"><img alt="Selenide" src="media/logo/Selenide.svg" width="50" height="50"></a>
  <a href="https://rest-assured.io/"><img alt="Rest Assured" src="media/logo/RestAssured.svg" width="50" height="50"></a>
  <a href="https://aerokube.com/selenoid/"><img alt="Selenoid" src="media/logo/Selenoid.svg" width="50" height="50"></a>
  <a href="https://www.browserstack.com/"><img alt="BrowserStack" src="media/logo/Browserstack.svg" width="50" height="50"></a>
  <a href="https://developer.android.com/studio"><img alt="Android Studio" src="media/logo/android-studio.png" style="width:50px; height:50px;"/></a>
  <a href="https://www.jenkins.io/"><img alt="Jenkins" src="media/logo/Jenkins.svg" width="50" height="50"></a>
  <a href="https://github.com/allure-framework/"><img alt="Allure Report" src="media/logo/Allure.svg" width="50" height="50"></a>
  <a href="https://qameta.io/"><img alt="Allure TestOps" src="media/logo/Allure_TO.svg" width="50" height="50"></a>
  <a href="https://www.atlassian.com/software/jira"><img alt="Jira" src="media/logo/Jira.svg" width="50" height="50"></a>
  <a href="https://telegram.org/"><img alt="Telegram" src="media/logo/Telegram.svg" width="50" height="50"></a>
</p>


## Реализованные проверки

### Web
- [x] Успешная авторизация с валидными данными
- [x] Ошибка при вводе неправильного пароля
- [x] Отображение кнопки входа на форме логина
- [x] Проверка элементов формы регистрации
- [x] Ввод текста в поле email
- [x] Ввод текста в поле пароля
- [x] Успешная регистрация нового пользователя
- [x] Проверка кнопки "Start for free"
- [x] Создание и проверка задачи

### Api
- [x] Получение списка всех проектов
- [x] Получение конкретного проекта по ID
- [x] Создание нового проекта
- [x] Обновление названия проекта
- [x] Удаление проекта
- [x] Негативный сценарий — создание проекта без названия
- [x] Создание задачи в проекте

### Mobile
- [x] Проверка элементов формы входа
- [x] Отображение логотипа Todoist
- [x] Проверка текста на втором экране онбординга

### Ручные проверки (управляются в Allure TestOps)
- [x] Добавление новой команды в профиле
- [x] Поиск по профилю
- [x] Работа с боковой панелью

## Запуск тестов

> **Примечание:**  
> Убедитесь, что у вас установлены Java, Gradle, IntelliJ IDEA (рекомендуется), Appium Server (для мобильных тестов), Docker (для Selenoid)
> Конфигурационные файлы `.properties` лежат в папке `resources` — при необходимости их можно изменить.

### Локальный запуск

Основные команды:
#### Все тесты
```bash
gradle clean allTests \
-DbaseUrl=https://todoist.com
```


#### Только WEB
```bash
gradle clean webTests \
-Dbrowser=chrome \
-DbrowserVersion=lates \
-DbrowserSize=1920x1080 \
-DbaseUrl=https://todoist.com
```

#### Только API
```bash
gradle clean apiTests\
-DbaseUrl=https://todoist.com
```

#### Мобильные тесты (локальный эмулятор)
```bash
gradle clean mobileTests\
-DdeviceHost=local_emulator \
-DbaseUrl=http://localhost:8080
```

### Удалённый запуск

#### Selenoid (Web)
```bash
gradle clean webTests \
-DremoteUrl=selenoid.autotests.cloud \
-Dbrowser=chrome \
-DbrowserVersion=127.0 \
-DbrowserSize=1920x1080 \
-DbaseUrl=https://todoist.com
```

#### BrowserStack (Mobile)
```bash
gradle clean mobileTests \
-DdeviceHost=browserstack \
-DbaseUrl=https://todoist.com
```

### Запуск в Jenkins

Основные параметры для сборки:

- `TEST_TYPE` — тип тестов: `WEB`, `API`, `MOBILE`, `ALL`
- `BASE_URL` — адрес тестируемого приложения
  > Пример: `https://todoist.com`
- `browser` — браузер: `chrome` / `firefox` (по умолчанию: `chrome`)
- `browserVersion` — версия браузера
  > По умолчанию: `127.0` для Chrome, `124.0` для Firefox
- `browserSize` — разрешение окна браузера (по умолчанию: `1920x1080`)
- `remoteUrl` — адрес удалённого сервера для запуска браузеров
  > По умолчанию: `selenoid.autotests.cloud`
- `mobileDeviceSource` — платформа для мобильных тестов:
  > `browserstack` или `local_emulator`
- `ENVIRONMENT` — тестовое окружение
  > Например: `stage.qa.guru`, `test.qa.guru`

## Генерация отчетов

### Сформировать Allure отчет
gradle allureReport

### Открыть отчет локально
gradle allureServe

### Отчеты в Jenkins доступны автоматически после выполнения сборки.

## [Allure Report](https://jenkins.autotests.cloud/job/YanaTsiFi-todoist-project/allure/)

После завершения сборки в блоке **Build History** напротив номера сборки появятся значки **Allure Report** и **Allure TestOps**.  
При клике на них откроются страницы с генерированным HTML-отчетом и тестовой документацией.

### Скриншоты:

#### 1. Основная страница Allure Report
![Allure Report Main](/media/screenshots/allurereport1.png)

#### 2. Просмотр тест-кейсов в Allure Report
![Allure Report Test Cases](/media/screenshots/allurereport2.png)

#### 3. Графики и диаграммы с результатами тестов
![Allure Report Graphs](/media/screenshots/allurereport3.png)


## [Allure TestOps](https://allure.autotests.cloud/project/4793/dashboards)
На Dashboard в Allure TestOps удобно отслеживать статистику по тестам: сколько добавлено, какие ручные, а какие автоматизированы.
Платформа позволяет легко запускать нужные тесты, анализировать результаты и управлять тестированием в одном месте — это значительно упрощает работу команды и повышает её эффективность.

#### 1. Основная страница Allure Testops
![Allure Report Main](/media/screenshots/testops1.png)

#### 2. Авто и Ручные тест-кейсы
![Allure Report Main](/media/screenshots/testops2.png)

## [Интеграция с Jira](https://jira.autotests.cloud/browse/HOMEWORK-1464)
Реализована интеграция Allure TestOps с Jira.  
В каждом тикете отображаются:

🔹 связанные тест-кейсы, написанные в рамках задачи;  
🔹 результаты их прогона (успешные, упавшие и пропущенные);  
🔹 отчётность прямо внутри Jira — удобно для QA и разработчиков.

### Пример интеграции
![Jira integration screenshot](media/screenshots/jira-integration.png)


## Telegram-уведомления
После завершения сборки бот в Telegram автоматически обрабатывает результаты и отправляет уведомление с отчетом о прогоне тестов.

### Содержание уведомления

- ✔️ Окружение, в котором запускались тесты
- ✔️ Комментарий к прогону
- ✔️ Длительность прохождения тестов
- ✔️ Общее количество сценариев
- ✔️ Процент прохождения тестов
- ✔️ Ссылка на Allure отчет

### Пример уведомления
![Jira integration screenshot](media/screenshots/telegram.png)


## Видео-из-selenoid
Каждый автотест записывается на видео с помощью Selenoid. Это позволяет быстро находить и анализировать ошибки при выполнении тестов. Видео автоматически прикрепляется к отчёту в Allure.

### Пример записи выполнения теста:
![Web test video](media/video/web-test.gif)


## Видео-из-browserstack
Для мобильных автотестов используется облачная платформа BrowserStack, которая также записывает видео каждого прогона. Это помогает отслеживать поведение приложения на разных устройствах и ОС.

### Пример записи выполнения мобильного теста:
![Mobile test video](media/video/mobile-test.gif)