package pages;

import ConfigManager.ConfigManager;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    private final String nameTask = ConfigManager.getNameTask();//из конфига

    SelenideElement projectBtn = $x("//a[@id='browse_link']").as("Кнопка 'Проекты'");
    SelenideElement testBtn = $x("//a[@id='admin_main_proj_link_lnk']").as("Кнопка 'Test'");
    SelenideElement sum = $x("//div[@class='showing']").as("Количество задач");
    SelenideElement createTask = $x("//div[@class='iic-trigger']//button[@class='aui-button aui-button-subtle']").as("Кнопка создать задачу");


    @Step("Пользователь нажимает кнпоку")
    public void clickBtn(){
        projectBtn.click();
        testBtn.click();
    }

    @Step("Пользователь смотрит сколько задач есть")
    public void checkTask(){
        createTask.click();
        $(By.xpath("//div[@class='iic-widget']")).should(Condition.visible);
        $(By.xpath("//textarea[@name='summary']")).setValue(nameTask).pressEnter();
        $(sum).shouldNotHave(Condition.text(sum.getText()));
        clickBtn(); // если этого не делать количество заданий будет совсем другое, а если сделать так(перезайти на страницу то все сработает и тасков станет + 1
    }
}
