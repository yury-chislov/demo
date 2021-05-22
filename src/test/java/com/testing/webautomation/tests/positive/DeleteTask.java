package com.testing.webautomation.tests.positive;

import com.testing.webautomation.base.TestBase;
import org.testng.annotations.Test;

public class DeleteTask extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Delete task and check results")
    public void testDeleteTask() throws InterruptedException {
        todomvcSite.mainPage().createNewTask("Task1");
        todomvcSite.mainPage().deleteTask("Task1");
        todomvcSite.mainPage().checkTodoCountAbsent();
        todomvcSite.mainPage().checkClearCompletedAbsent();
        todomvcSite.mainPage().checkTasksAbsent();
        refreshBrowser();
        todomvcSite.mainPage().checkTodoCountAbsent();
        todomvcSite.mainPage().checkClearCompletedAbsent();
        todomvcSite.mainPage().checkTasksAbsent();
    }
}
