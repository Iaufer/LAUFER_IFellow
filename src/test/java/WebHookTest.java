import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.TestPage;
import webhooks.WebHook;

public class WebHookTest extends WebHook {
    private final LoginPage lPage = new LoginPage();
    private final TestPage tPage = new TestPage();


    @Test
    public void edujiraIFTest(){
        lPage.inputLogin("AT6");
        lPage.inputPassword("Qwerty123");
        lPage.clickBtn();

        tPage.clickBtn();
        tPage.checkTask();
    }



}
