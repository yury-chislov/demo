package com.testing.webautomation.pageobjects;


import com.testing.webautomation.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class MainPage extends TestBase {
    private WebDriver webDriver;
    private WebDriverWait wait;
    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    //<editor-fold desc="Objects">
    @FindBy(xpath = "//input[@class='toggle']")
    List<WebElement> radioButtons;
    @FindBy(xpath = "//input[contains(@class,'new-todo')]")
    public WebElement newTodoBox;
    @FindBy(xpath = "//span[@class=('todo-count')]/strong")
    public WebElement todoCountNumber;
    @FindBy (xpath = "//label")
    List<WebElement> taskList;
    @FindBy (xpath = "//button[(@class='clear-completed')]")
    public WebElement clearCompletedButton;
    @FindBy (xpath = "//button[(@class='destroy')]")
    public WebElement deleteButton;

    //This function works only with unique task names. If there's multiple tasks with the same name it will find the first one from top
    public WebElement getCreatedRadioByName(String taskName) {
        try {
            for (int i = 0; i < taskList.size(); i++) {
                if ((taskList.get(i).getText()).equals(taskName)) {
                    return radioButtons.get(i);
                }
            }
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            Assert.fail("Task " + taskName + " does not exist!");
            System.out.println(exception);
        }
        return null;
    }

    public WebElement getCreatedTaskByName(String taskName)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//label[contains(text(),'" + taskName + "')]"))));
            return webDriver.findElement(By.xpath("//label[contains(text(),'" + taskName + "')]"));
        }
        catch (org.openqa.selenium.NoSuchElementException exception){
            Assert.fail("Task " + taskName + " does not exist!");
            System.out.println(exception);
            return null;
        }
    }

    //</editor-fold>

    //<editor-fold desc="Actions">
    @Step("Create a new task")
    public void createNewTask(String taskName){
        wait.until(ExpectedConditions.visibilityOf(newTodoBox));
        newTodoBox.sendKeys(taskName);
        newTodoBox.sendKeys(Keys.ENTER);
    }

    @Step("Click clear completed button")
    public void clickClearCompleted(){
        wait.until(ExpectedConditions.visibilityOf(clearCompletedButton));
        clearCompletedButton.click();
    }

    @Step("Click 'delete' completed button")
    public void clickDeleteButton(){
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
    }

    @Step("Create multiple new task")
    public void createMultipleNewTask(List<String> taskNameList){

        for (int i = 0; i < taskNameList.size(); i++){
            createNewTask(taskNameList.get(i));
        }
    }

    @Step("Click radio button 'Complete task'")
    public void clickCompleteTask(String taskName) {
        getCreatedRadioByName(taskName).click();
    }

    @Step("Edit task name")
    public void editTaskName(String oldTaskName, String newTaskName) {
        Actions act = new Actions(webDriver);
        act.doubleClick(getCreatedTaskByName(oldTaskName)).perform();
        act.click().perform();
        for (int i=0; i < oldTaskName.length(); i++) {
            act.sendKeys(Keys.BACK_SPACE).perform();
        }
        act.sendKeys(newTaskName).perform();
        act.sendKeys(Keys.ENTER).perform();
    }

    @Step("Edit task name but don't save it")
    public void editTaskNameNoSaving(String oldTaskName, String newTaskName) {
        Actions act = new Actions(webDriver);
        act.doubleClick(getCreatedTaskByName(oldTaskName)).perform();
        act.click().perform();
        for (int i=0; i < oldTaskName.length(); i++) {
            act.sendKeys(Keys.BACK_SPACE).perform();
        }
        act.sendKeys(newTaskName).perform();
    }

    @Step("Delete task")
    public void deleteTask(String TaskName) throws InterruptedException {
        Actions act = new Actions(webDriver);
        act.moveToElement(getCreatedTaskByName(TaskName)).perform();
        clickDeleteButton();

    }
   //</editor-fold>

    //<editor-fold desc="Checkers">
    @Step ("Check task with name {taskName} is displayed")
    public void checkTaskCreated(String taskName) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertNotNull(getCreatedTaskByName(taskName));
    }

    @Step ("Check list of tasks has been created")
    public void checkTaskListCreated(List<String> taskNameList) throws InterruptedException {

        for (int i = 0; i < taskNameList.size(); i++){
            checkTaskCreated(taskNameList.get(i));
        }
    }

    @Step ("Check todo count number displayed")
    public  void checkTodoCountDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(todoCountNumber));
            Assert.assertNotNull(todoCountNumber);
        }
        catch (org.openqa.selenium.NoSuchElementException exception){
            Assert.fail("todo count number NOT displayed!");
            System.out.println(exception);
        }
    }

    @Step ("Check absence of count number")
    public  void checkTodoCountAbsent(){
        try {
            if (todoCountNumber.isDisplayed()) {
                Assert.fail("todo count is displayed!");
            }
        }
        catch (org.openqa.selenium.NoSuchElementException exception){
            Assert.assertTrue(true);
        }
    }

    @Step ("Check absence of 'clear completed' button")
    public  void checkClearCompletedAbsent(){
        try {
            if (clearCompletedButton.isDisplayed()) {
                Assert.fail("clear completed button is displayed!");
            }
        }
        catch (org.openqa.selenium.NoSuchElementException exception){
            Assert.assertTrue(true);
        }
    }

    @Step ("Check 'clear completed' button not clickable")
    public  void checkClearCompletedNotClickable(){
        try {
                clearCompletedButton.click();
                Assert.fail("clear completed button is displayed!");
        }
        catch (org.openqa.selenium.NoSuchElementException exception){
            Assert.assertTrue(true);
        }
    }


    @Step ("Check there is no tasks")
    public  void checkTasksAbsent(){
        try {
            if (taskList.get(0).isDisplayed()) {
                Assert.fail("some tasks are displayed!");
            }
        }
        catch (java.lang.IndexOutOfBoundsException exception){
            Assert.assertTrue(true);
        }
    }

    @Step ("Check todo count number value")
    public  void checkTodoCountValue(int number){
        wait.until(ExpectedConditions.visibilityOf(todoCountNumber));
        Assert.assertEquals(todoCountNumber.getText(), Integer.toString(number));
    }
    //</editor-fold>
}
