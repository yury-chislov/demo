package com.testing.webautomation.tests.positive;

import com.testing.webautomation.base.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

public class CompleteTasks extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Complete Task and undo and check results")
    public void testCompleteTask() throws IOException {
        todomvcSite.mainPage().createNewTask("Task1");
        todomvcSite.mainPage().createNewTask("Task2");
        todomvcSite.mainPage().checkTodoCountValue(2);
        todomvcSite.mainPage().clickCompleteTask("Task1");
        refreshBrowser();
        todomvcSite.mainPage().checkTodoCountValue(1);
        allureScreenshot("Task1_completed");
    }
}
