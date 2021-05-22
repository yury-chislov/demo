package com.testing.webautomation.tests.positive;

import com.testing.webautomation.base.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

public class RenameTask extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Rename task and check results")
    public void testRenameTask() throws IOException, InterruptedException {
        todomvcSite.mainPage().createNewTask("Task1");
        todomvcSite.mainPage().editTaskName("Task1","newName");
        todomvcSite.mainPage().checkTaskCreated("newName");
        //Check there is only one record
        todomvcSite.mainPage().checkTodoCountValue(1);
        refreshBrowser();
        todomvcSite.mainPage().checkTodoCountValue(1);
        todomvcSite.mainPage().checkTaskCreated("newName");
        allureScreenshot("renamedTask_newName");
    }
}
