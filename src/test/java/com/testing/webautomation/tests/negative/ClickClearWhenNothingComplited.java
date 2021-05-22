package com.testing.webautomation.tests.negative;

import com.testing.webautomation.base.TestBase;
import org.testng.annotations.Test;

public class ClickClearWhenNothingComplited extends TestBase {

    @Test(groups = {"mainPage"}, description = "Main page. Test: Attempt to click 'clear completed' when nothing completed")
    public void testClickClearWhenNothingComplited() {
        todomvcSite.mainPage().createNewTask("Task1");
        refreshBrowser();
        todomvcSite.mainPage().checkClearCompletedNotClickable();
        todomvcSite.mainPage().checkClearCompletedAbsent();
    }
}
