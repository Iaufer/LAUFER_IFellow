package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TestSeleniumATHomeworkPage {
    SelenideElement search = $x("//input[@name='searchString']").as("Поиск задач");

    @Step("Пользователь ищет задачу 'TestSeleniumATHomework'")
    public void searchTask(){
        search.setValue("TestSeleniumATHomework").pressEnter();
    }
}
