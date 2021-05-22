package com.testing.webautomation.tests.negative;

import com.testing.webautomation.base.TestBase;
import com.testing.webautomation.base.TestData;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateEmptyTask extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Attempt to create Empty Task and check results")
    public void testCreateEmptyTask() throws IOException {
        todomvcSite.mainPage().createMultipleNewTask(TestData.invalidNameList);
        refreshBrowser();
        todomvcSite.mainPage().checkTodoCountAbsent();
        todomvcSite.mainPage().checkClearCompletedAbsent();
        todomvcSite.mainPage().checkTasksAbsent();
        allureScreenshot("emptyNameTasksAttempt");
    }
}
