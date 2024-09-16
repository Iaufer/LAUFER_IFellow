import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BugCreatePage;
import pages.LoginPage;
import pages.TestPage;
import pages.TestSeleniumATHomeworkPage;
import tools.ConfigReader;
import webhooks.WebHook;

public class WebHookTest extends WebHook {
    private final LoginPage lPage = new LoginPage();
    private final TestPage tPage = new TestPage();
    private final TestSeleniumATHomeworkPage TSPage = new TestSeleniumATHomeworkPage();
    private final BugCreatePage BGPage = new BugCreatePage();

    @Test
    public void edujiraIFTest(){
        lPage.inputLogin(ConfigReader.confData().getProperty("login"));
        lPage.inputPassword(ConfigReader.confData().getProperty("password"));
        lPage.clickBtn();
        Assertions.assertEquals(lPage.getText(), "Добро пожаловать в Jira");

        tPage.clickBtn();
        Assertions.assertEquals(tPage.getText(), "Открытые задачи");
        tPage.checkTask();
        Assertions.assertEquals(tPage.getNewCount(), tPage.getOldCount()+1);

        //TSPage.moveMainPage();
        TSPage.searchTask();
        Assertions.assertEquals(TSPage.getTaskStatus(), "СДЕЛАТЬ");
        Assertions.assertEquals(TSPage.getFixInVetsion(), "Version 2.0");

        BGPage.moveCreate();
        BGPage.writeFields();
        BGPage.saveTask();
        BGPage.allStatusTask();
        Assertions.assertEquals(BGPage.getTaskStatus(), "ГОТОВО");
//        BGPage.allStatusTask();
    }



}
