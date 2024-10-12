package pages;

import ConfigManager.ConfigManager;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BugCreatePage {
    private final String task = ConfigManager.getTask();

    SelenideElement createBug = $x("//a[@id='create_link']").as("Создать задачу");
    SelenideElement theme = $x("//input[contains(@class,'text long-field')]").as("Поле ввода темы");
    SelenideElement desc = $x("//textarea[@id='description']").as("Поле ввода описания");
    SelenideElement environment = $x("//textarea[@id='environment']").as("Поле ввода окружение");
    SelenideElement saveRes = $x("//input[@id='create-issue-submit']").as("Кнопка 'Создать'");
    SelenideElement inWork = $x("//a[@id='action_id_21']//span[@class='trigger-label']").as("Статус задачи 'В работе'");
    SelenideElement done = $x("//a[@id='opsbar-transitions_more']").as("Статус задачи 'Выполнено'");
    SelenideElement search = $x("//input[@name='searchString']").as("Поиск задачи");
    SelenideElement ready = $x("//span[contains(text(), 'Выполнено')and @class='trigger-label']/..").as("Статус задачи 'Выполнено'");

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
        ready.should(Condition.visible).click();
    }

    @Step("Пользователь ищет задачу")
    public void searchTask(){
        search.setValue(task).pressEnter();
    }
}
