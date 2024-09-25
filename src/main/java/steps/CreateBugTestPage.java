package steps;

import io.cucumber.java.ru.И;
import pages.BugCreatePage;

public class CreateBugTestPage {
    private final BugCreatePage bgPage = new BugCreatePage();

    @И("Пользователь нажимает создать баг")
    public void createBug(){
        bgPage.moveCreate();
    }

    @И("Пользователь заполняет поля")
    public void writeFields(){
        bgPage.writeFields();
    }

    @И("Пользователь сохраняет баг")
    public void saveBug(){
        bgPage.saveTask();
    }

    @И("Пользователь проводит задачу по статусам")
    public void allStatus(){
        bgPage.allStatusTask();
    }
}
