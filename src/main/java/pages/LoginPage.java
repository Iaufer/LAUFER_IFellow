package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    public SelenideElement iLogin = $x("//input[@name='os_username']");
    public SelenideElement iPassword = $x("//input[@name='os_password']");
    public SelenideElement lBtn = $x("//input[@name='login']");
    public SelenideElement text = $x("//h3[text()='Добро пожаловать в Jira']");

    public void inputLogin(String login){
        iLogin.setValue(login);
    }

    public void inputPassword(String password){
        iPassword.setValue(password);
    }

    public void clickBtn(){
        lBtn.click();
    }

    public String getText(){
        return text.getText();
    }
}
