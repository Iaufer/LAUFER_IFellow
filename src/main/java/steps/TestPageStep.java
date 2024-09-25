package steps;

import io.cucumber.java.ru.И;
import pages.TestPage;

public class TestPageStep {
    private final TestPage tPage = new TestPage();

    @И("Пользователь нажимает на проект Test")
    public void clickTest(){
        tPage.clickBtn();
    }

    @И("Пользователь проверяет задачи")
    public void checkTask(){
        tPage.checkTask();
    }
}
