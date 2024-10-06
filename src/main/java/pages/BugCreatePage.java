package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tools.ConfigReader;

import static com.codeborne.selenide.Selenide.$x;

public class BugCreatePage {
    private final ConfigReader Prop = ConfigReader.getInstance();
    private final String task = Prop.task();

    SelenideElement createBug = $x("//a[@id='create_link']");
    SelenideElement theme = $x("//input[contains(@class,'text long-field')]");
    SelenideElement desc = $x("//textarea[@id='description']");
    SelenideElement environment = $x("//textarea[@id='environment']");
    SelenideElement saveRes = $x("//input[@id='create-issue-submit']");
    SelenideElement inWork = $x("//a[@id='action_id_21']//span[@class='trigger-label']");
    SelenideElement done = $x("//a[@id='opsbar-transitions_more']");
    SelenideElement search = $x("//input[@name='searchString']");
    SelenideElement status = $x("//span[@class=' jira-issue-status-lozenge aui-lozenge jira-issue-status-lozenge-green jira-issue-status-lozenge-done jira-issue-status-lozenge-max-width-medium']");


    @Step("Пользователь нажимает 'создать баг'")
    public void moveCreate(){
        createBug.click();
    }

    @Step("Пользователь заполняет поля для создания бага")
    public void writeFields(){
        theme.setValue(task);
        desc.setValue("Some description");
        environment.setValue("Some environment");
    }

    @Step("Пользователь сохраняет баг")
    public void saveTask(){
        saveRes.click();
    }

    @Step("Пользователь проводит задачу по всем статусам")
    public void allStatusTask(){
        searchTask();
        inWork.click();
        done.click();
        $x("//span[contains(text(), 'Выполнено')and @class='trigger-label']/..").should(Condition.visible).click();
    }

    @Step("Пользователь ищет задачу")
    public void searchTask(){
        search.setValue(task).pressEnter();
    }

    @Step("Пользователь получает статус задачи")
    public String getTaskStatus(){
        return status.getText();
    }

}
