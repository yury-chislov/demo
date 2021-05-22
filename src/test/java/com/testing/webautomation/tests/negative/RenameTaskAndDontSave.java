package com.testing.webautomation.tests.negative;

import com.testing.webautomation.base.TestBase;
import org.testng.annotations.Test;

public class RenameTaskAndDontSave extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Rename task but refresh browser without saving and check results")
    public void testRenameTaskAndDontSave() throws InterruptedException {
        todomvcSite.mainPage().createNewTask("Task1");
        todomvcSite.mainPage().editTaskNameNoSaving("Task1","newName");
        refreshBrowser();
        todomvcSite.mainPage().checkTaskCreated("Task1");
    }
}
