package steps;

import io.cucumber.java.ru.И;
import pages.TestSeleniumATHomeworkPage;

public class TestSelenPage {
    private final TestSeleniumATHomeworkPage tsPage = new TestSeleniumATHomeworkPage();

    @И("Пользователь ищет Test Selenium")
    public void findTestSelenium(){
        tsPage.searchTask();
    }

    @И("Пользователь проверяет статус")
    public void checStatusTask(){
        tsPage.getTaskStatus();
    }

    @И("Пользователь проверяет Исправить в версиях")
    public void checkVersion(){
        tsPage.getFixInVetsion();
    }
}
