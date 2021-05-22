package com.testing.webautomation.tests.positive;

import com.testing.webautomation.base.TestBase;
import com.testing.webautomation.base.TestData;
import org.testng.annotations.Test;
import java.io.IOException;

public class CreateTasks extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test Create Tasks and Check results")
    public void testCreateTasks() throws IOException, InterruptedException {
        todomvcSite.mainPage().createMultipleNewTask(TestData.taskNameList);
        refreshBrowser();
        todomvcSite.mainPage().checkTaskListCreated(TestData.taskNameList);
        todomvcSite.mainPage().checkTodoCountValue(TestData.taskNameList.size());
        allureScreenshot("multipleTasksCreated");
    }
}
