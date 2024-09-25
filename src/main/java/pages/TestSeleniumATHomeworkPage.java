package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumATHomeworkPage {
    SelenideElement search = $x("//input[@name='searchString']");
    SelenideElement status = $x("//span[contains(@class, 'jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-blue-gray jira-issue-status-lozenge-new jira-issue-status-lozenge-max-width-medium')]");
    SelenideElement fixInV = $x("//a[contains(@title, 'Version 2.0')]");

    public void searchTask(){
        search.setValue("TestSeleniumATHomework").pressEnter();
    }

    public String getTaskStatus(){
        return status.getText();
    }

    public String getFixInVetsion(){
        return fixInV.getText();
    }


}
