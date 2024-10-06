## Введение

Набор тестов. Тесты для авторизации пользователя, создания задач, проверки статуса задач и создания багов.

## Стек технологий

- **Java JDK 17**
- **Maven**
- **Allure**
- **Selenide**
- **Junit**

## Установка

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Iaufer/LAUFER_IFellow/tree/IF_HW_6

2. Перейдите в папку проекта:
    ```bash
   cd LAUFER_IFellow/IF_HW_6


## Запуск

1. Чтобы запустить тесты, выполните следующую команду:
    ```bash
   mvn install test

2. Генерация отчетов Allure:
    ```bash
    mvn allure:report

3. Чтобы запустить локальный сервер для просмотра отчетов:
    ```bash
   mvn allure:serve


## Тестовые случаи

1. Авторизация пользователя
    ```bash
    @Test
    @Order(1)
    @DisplayName("Тест авторизации")
        public void testLoginUser(){
        lPage.inputLogin(Prop.login());
        lPage.inputPassword(Prop.password());
        lPage.clickBtn();
    }

2. Проверка создания задачи
    ```bash
    @Test
    @Order(2)
    @DisplayName("Пользователь проверяет, что при создании задачи их становится на одну больше")
    public void checkTaskTest(){
        lPage.inputLogin(Prop.login());
        lPage.inputPassword(Prop.password());
        lPage.clickBtn();

        tPage.clickBtn();
        tPage.checkTask();
    }

3. Проверка статуса и версии задачи
    ```bash
    @Test
    @Order(3)
    @DisplayName("Пользователь переходит в задачу TestSeleniumATHomework, проверяет статус задачи и версию")
    public void checkTestSelATHomework(){
        lPage.inputLogin(Prop.login());
        lPage.inputPassword(Prop.password());
        lPage.clickBtn();
    
        tPage.clickBtn();
        tPage.checkTask();
    
        TSPage.searchTask();
    }

4. Создание бага
    ```bash
    @Test
    @Order(4)
    @DisplayName("Пользователь создает баги добавляет описание")
    public void testCreateBug(){
        lPage.inputLogin(Prop.login());
        lPage.inputPassword(Prop.password());
        lPage.clickBtn();

        tPage.clickBtn();
        tPage.checkTask();

        TSPage.searchTask();

        BGPage.moveCreate();
        BGPage.writeFields();
        BGPage.saveTask();
        BGPage.allStatusTask();
    }



