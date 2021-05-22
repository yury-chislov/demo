package com.testing.webautomation.tests.negative;

import com.testing.webautomation.base.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateTasksNoCookies extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Try to create a task when cookies disabled and check results")
    @Parameters("browser")
    public void testCreateTasksNoCookies(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            todomvcSite.mainPage().createNewTask("Task1");
            refreshBrowser();
            todomvcSite.mainPage().checkTodoCountAbsent();
            todomvcSite.mainPage().checkClearCompletedAbsent();
            todomvcSite.mainPage().checkTasksAbsent();
        } else {
            System.out.println("Skipped. This test only for chrome browser current browser is: " + browser);
        }
    }
}
