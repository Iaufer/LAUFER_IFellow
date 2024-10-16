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
   cd LAUFER_IFellow/FHW_API

## Запуск

1. Генерация отчетов Allure:
    ```bash
    mvn allure:report

2. Чтобы запустить локальный сервер для просмотра отчетов:
    ```bash
   mvn allure:serve
