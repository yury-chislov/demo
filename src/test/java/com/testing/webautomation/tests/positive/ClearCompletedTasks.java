package com.testing.webautomation.tests.positive;

import com.testing.webautomation.base.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

public class ClearCompletedTasks extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Complete Task and undo and check results")
    public void testClearCompletedTasks() throws IOException {
        todomvcSite.mainPage().createNewTask("Task1");
        todomvcSite.mainPage().checkTodoCountValue(1);
        todomvcSite.mainPage().clickCompleteTask("Task1");
        todomvcSite.mainPage().checkTodoCountValue(0);
        todomvcSite.mainPage().clickClearCompleted();
        refreshBrowser();
        todomvcSite.mainPage().checkTodoCountAbsent();
        todomvcSite.mainPage().checkClearCompletedAbsent();
        todomvcSite.mainPage().checkTasksAbsent();
        allureScreenshot("Tasks_completed_cleared");
    }
}
