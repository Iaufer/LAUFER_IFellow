package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    SelenideElement projectBtn = $x("//a[@id='browse_link']");
    SelenideElement testBtn = $x("//a[@id='admin_main_proj_link_lnk']");
    SelenideElement sum = $x("//div[@class='showing']");
    SelenideElement createTask = $x("//div[@class='iic-trigger']//button[@class='aui-button aui-button-subtle']");
    SelenideElement test = $x("//span[@id='issues-subnavigation-title']");


    private int oldCount;
    private int newCount;

    private final String nameTask = "FIX FIX BUGy";

    @Step("Пользователь нажимает кнпоку")
    public void clickBtn(){
        projectBtn.click();
        testBtn.click();
    }

    @Step("Пользователь смотрит сколько задач есть")
    public void checkTask(){
        oldCount =  Integer.parseInt(sum.getText().split(" ")[2]);
        createTask.click();
        $(By.xpath("//div[@class='iic-widget']")).should(Condition.visible);
        $(By.xpath("//textarea[@name='summary']")).setValue(nameTask).pressEnter();
        $(sum).shouldNotHave(Condition.text(sum.getText()));
        clickBtn(); // если этого не делать количество заданий будет совсем другое, а если сделать так(перезайти на страницу то все сработает и тасков станет + 1
        newCount = Integer.parseInt(sum.getText().split(" ")[2]);
    }

    @Step("Пользователь получает количество задач до создания еще одной")
    public int getOldCount(){
        return oldCount;
    }

    public String getText(){
        return test.getText();
    }
}
