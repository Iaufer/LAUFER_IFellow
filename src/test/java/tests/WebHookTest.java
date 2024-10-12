package tests;

import ConfigManager.ConfigManager;
import org.junit.jupiter.api.*;
import pages.BugCreatePage;
import pages.LoginPage;
import pages.TestPage;
import pages.TestSeleniumATHomeworkPage;
import tools.ConfigReader;
import webhooks.WebHook;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WebHookTest extends WebHook {
    private final String login = ConfigManager.getLogin();
    private final String password = ConfigManager.getPassword();

    private final LoginPage lPage = new LoginPage();
    private final TestPage tPage = new TestPage();
    private final TestSeleniumATHomeworkPage TSPage = new TestSeleniumATHomeworkPage();
    private final BugCreatePage BGPage = new BugCreatePage();


    @Test
    @Order(1)
    @DisplayName("Тест авторизации")
    public void testLoginUser(){
        lPage.inputLogin(login);
        lPage.inputPassword(password);
        lPage.clickBtn();
    }

    @Test
    @Order(2)
    @DisplayName("Пользователь проверяет, что при создании задачи их становится на одну больше")
    public void checkTaskTest(){
        lPage.inputLogin(login);
        lPage.inputPassword(password);
        lPage.clickBtn();

        tPage.clickBtn();
        tPage.checkTask();
    }

    @Test
    @Order(3)
    @DisplayName("Пользователь переходит в задачу TestSeleniumATHomework, проверяет статус задачи и версию")
    public void checkTestSelATHomework(){
        lPage.inputLogin(login);
        lPage.inputPassword(password);
        lPage.clickBtn();

        tPage.clickBtn();
        tPage.checkTask();

        TSPage.searchTask();
    }

    @Test
    @Order(4)
    @DisplayName("Пользователь создает баги добавляет описание")
    public void testCreateBug(){
        lPage.inputLogin(login);
        lPage.inputPassword(password);
        lPage.clickBtn();

        tPage.clickBtn();
        tPage.checkTask();

        TSPage.searchTask();

        BGPage.moveCreate();
        BGPage.writeFields();
        BGPage.saveTask();
        BGPage.allStatusTask();
    }
}