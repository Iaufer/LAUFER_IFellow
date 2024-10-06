package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumATHomeworkPage {
    SelenideElement search = $x("//input[@name='searchString']");
    SelenideElement status = $x("//span[contains(@class, 'jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-blue-gray jira-issue-status-lozenge-new jira-issue-status-lozenge-max-width-medium')]");
    SelenideElement fixInV = $x("//a[contains(@title, 'Version 2.0')]");


    @Step("Пользователь ищет задачу 'TestSeleniumATHomework'")
    public void searchTask(){
        search.setValue("TestSeleniumATHomework").pressEnter();
    }

    @Step("Пользователь получает статус задачи")
    public String getTaskStatus(){
        return status.getText();
    }

    @Step("Пользователь получает версию задачи")
    public String getFixInVetsion(){
        return fixInV.getText();
    }
}
