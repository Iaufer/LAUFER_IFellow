package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import pages.LoginPage;
import tools.ConfigReader;

public class LoginStep {
    private final LoginPage lPage = new LoginPage();

    @Когда("Пользователь вводит логин")
    public void inputLog(){
        lPage.inputLogin(ConfigReader.confData().getProperty("login"));
    }

    @И("Пользователь вводит пароль")
    public void inputPass(){
        lPage.inputPassword(ConfigReader.confData().getProperty("password"));
    }

    @И("Пользователь нажимает \"Войти\"")
    public void clickBtn(){
        lPage.clickBtn();
    }
}
