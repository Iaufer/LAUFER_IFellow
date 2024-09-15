package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    SelenideElement projectBtn = $x("//a[@id='browse_link']");
    SelenideElement testBtn = $x("//a[@id='admin_main_proj_link_lnk']");
    SelenideElement sum = $x("//div[@class='showing']");
    SelenideElement createTask = $x("//div[@class='iic-trigger']//button[@class='aui-button aui-button-subtle']");

    public void clickBtn(){
        projectBtn.click();
        testBtn.click();
    }

    public void checkTask(){
        String sSum = sum.getText();
        System.out.println(sSum);
        createTask.click();
        $(By.xpath("//div[@class='iic-widget']")).should(Condition.visible);
        $(By.xpath("//textarea[@name='summary']")).setValue("fix bag").pressEnter();
    }
}
