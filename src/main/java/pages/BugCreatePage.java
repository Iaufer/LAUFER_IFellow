package pages;

import com.codeborne.selenide.SelenideElement;
import tools.ConfigReader;

import static com.codeborne.selenide.Selenide.$x;

public class BugCreatePage {
    SelenideElement createBug = $x("//a[@id='create_link']");
    SelenideElement theme = $x("//input[contains(@class,'text long-field')]");
    SelenideElement desc = $x("//textarea[@id='description']");
    SelenideElement environment = $x("//textarea[@id='environment']");
    SelenideElement saveRes = $x("//input[@id='create-issue-submit']");
    SelenideElement inWork = $x("//a[@id='action_id_21']//span[@class='trigger-label']");
    SelenideElement done = $x("//a[@id='opsbar-transitions_more']");
    SelenideElement search = $x("//input[@name='searchString']");
    SelenideElement status = $x("//span[@class=' jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-green jira-issue-status-lozenge-done jira-issue-status-lozenge-max-width-medium']");


    public void moveCreate(){
        createBug.click();
    }

    public void writeFields(){
        theme.setValue(ConfigReader.confData().getProperty("task")); // взять из конфига
        desc.setValue("Some description");
        environment.setValue("Some environment");
    }

    public void saveTask(){
        saveRes.click();
    }

    public void allStatusTask(){
        searchTask();
        inWork.click();
        done.click();
        $x("//span[contains(text(), 'Выполнено')and @class='trigger-label']/..").click();
    }

    public void searchTask(){
        search.setValue(ConfigReader.confData().getProperty("task")).pressEnter(); //взять из конфига
    }

    public String getTaskStatus(){
        return status.getText();
    }

}
