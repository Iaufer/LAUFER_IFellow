import org.junit.jupiter.api.Test;
import pages.LoginPage;
import webhooks.WebHook;

    public class WebHookTest extends WebHook {
    private LoginPage lPage = new LoginPage();

    @Test
    public void edujiraIFTest(){
        lPage.inputLogin("AT6");
        lPage.inputPassword("Qwerty123");
        lPage.clickBtn();
    }
}
