package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    public static SelenideElement iLogin = $x("//input[@name='os_username']");
    public static SelenideElement iPassword = $x("//input[@name='os_password']");
    public static SelenideElement lBtn = $x("//input[@name='login']");
    public static SelenideElement text = $x("//h3[text()='Добро пожаловать в Jira']");


    @Step("Пользователь вводить логин")
    public void inputLogin(String login){
        iLogin.setValue(login);
    }

    @Step("Пользователь вводить пароль")
    public void inputPassword(String password){
        iPassword.setValue(password);
    }

    @Step("Пользователь нажимает войти")
    public void clickBtn(){
        lBtn.click();
    }

    @Step("Пользователь получает информацию о количестве заданий")
    public String getText(){
        return text.getText();
    }
}
