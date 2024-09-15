package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    public static SelenideElement iLogin = $x("//input[@name='os_username']");
    public static SelenideElement iPassword = $x("//input[@name='os_password']");
    public static SelenideElement lBtn = $x("//input[@name='login']");
    public static SelenideElement text = $x("//h3[text()='Добро пожаловать в Jira']");

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
