package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    public static SelenideElement iLogin = $x("//input[@name='os_username']").as("Поле для ввода логина");
    public static SelenideElement iPassword = $x("//input[@name='os_password']").as("Поле для ввода пароля");
    public static SelenideElement lBtn = $x("//input[@name='login']").as("Кнопка войти");


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
}
