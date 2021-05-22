package com.testing.webautomation.base;

import com.testing.webautomation.pageobjects.MainPage;
import org.openqa.selenium.WebDriver;

public class TodomvcSite {

    public TodomvcSite(WebDriver driver) {
        webDriver = driver;
    }
    //<editor-fold desc="List of site pages">
    public MainPage mainPage() {
        return new MainPage(webDriver);
    }
    //</editor-fold>

    WebDriver webDriver;
}




