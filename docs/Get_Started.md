# web-automation for 'https://todomvc.com/examples/angular2/'

# Get Started

This is a beginners guide to having the framework installed and running successfully on your computer.

This document is intended for anyone interested in running the project, no matter background.

It goes into deep detail on everything that you need to setup.

## Before You Start

This instruction assumes that:

- You know how to use the terminal (command line) on your operating system
- You are familiar with GitHub

## Requirements and Setup

### Basic Setup from Intellij

##### To run auto-tests from this project the following is required
1. Java 10/11 has been installed in the machine you would like to run tests.
2. JAVA_HOME is set on your machine. (Instruction for this: 'https://docs.oracle.com/cd/E19509-01/820-3208/inst_cli_jdk_javahome_t/')
3. At least one of the following browsers are installed: Chrome, Firefox. Ideally to have installed all both. This would allow to run test in different browsers.

#### To clone this repository using Intellij
1. Before you import, you need to make sure that in Intellij’s project defaults you have JDK 10/11 setup as an SDK properly.
2. Clean up your existing folder or create a new one for this project.
3. File -> New -> Project from Version Control -> Git
4. Specify this repository URL 'https://github.com/yury-chislov/demo.git' and specify the path where to clone this Project and click "clone"
4. When Project is cloned IJ asks you if you want to open the project say yes.
5. It should then instantly open and show you this message in the corner: "Unlinked Gradle project? Import Gradle project".
6. Clink import, a Window "Import Module from Gradle" opens. Tick boxes "Use auto-import", "Create separate module per source set" and click on "Use default gradle wrapper" radiobutton. In Gradle JVM box choose your JDK.
7. When you open any *java file in "tests" package, if it complains that there’s no ProjectSDK set. Click the link and fix it.
8. In the version control window in IJ you should now have the project with NO changes, NO added or deleted files etc. IF it shows any changes, do not proceed and try to clone the repository to the new directory.

#### To clone this repository using terminal:
This option assumes that you are familiar with GitHub and git clone so just do as you will do normally and clone the 'https://github.com/yury-chislov/demo.git' repository in your machine.

### Downloading WebDrivers

- For testing with Chrome browser get Chrome driver for your platform from: https://sites.google.com/a/chromium.org/chromedriver/downloads.

- For testing with Firefox browser get geckodriver for your platform from: https://github.com/mozilla/geckodriver/releases.

*NOTE:* WebDrivers **must** match the version of webBrowser on the PC.


### Create local.properties file

Create a file **local.properties** in the root of the project (https://github.com/yury-chislov/demo/blob/master/local.properties.sample). It needs to:
- Contain the location to the binary of your WebDriver(s). 
_Example:_ `chromeDriverBinaryPath=/home/yury/.local/bin/chromedriver`. You can use local.properties.sample (which IS part of the repository) as a template.
- Contain the location to folder with test screenshots and ERROR_log file:
_Example:_ `screenshotsPath=C:/Users/yury/AutoScreenshots/`

## How to run tests in Intellij

1. Right click on one of the folowing files in folder `com/testing/webautomation/base/`
    * `chromeBrowserTest.xml` if you wish to run tests only with chrome browser
    * `firefoxBrowserTest.xml` if you wish to run tests only with firefox browser
    * `corssBrowserTest.xml` if you wish to run tests with both browsers
2. Select `Run '.../...BrowserTest.xml'`

You also can specify in the files above what test goups/classes you want to run you you dont wan to run all test suite.
    
   For execution specified test(s) include only `<include name = "myTest" />` and assign `myTest` group to this test(s) in `tests` package. 
    
   _Example:_ 
   `@Test(groups = {"myTests"})`
    
   After finish execution delete "myTest" group.
   
   For execution all tests put in `<run>` tag `<include name="all">`

## How to run tests using command line

1. cd to the project directory `cd <your local path to the project>`
1. Run `gradlew clean`. This cleans up all build and output directories.
2. Run a defined test suite.

    _Example:_

    * `./gradlew test -PchromeBrowserSuite` to run tests with Chrome browser
    * `./gradlew test -PfirefoxBrowserSuite` to run tests with Firefox browser
    * `./gradlew test -PcrossBrowserSuite`     to run tests with both browsers
    
    It is highly recommended to run with `--info` to have all passing test steps and another useful information in your console!
 
    
    _Example:_ **`gradlew test -PchromeBrowserSuite --info`**
    
    *NOTE* The first time you run the test suite from the console, it may take some time, because it will download and compile all the necessary components.

## Process to create Allure report
##### The best way to see a test report is to run "Allure Report"

1. Run Allure report creation: `gradlew allureReport`
    This will create test report information in the following directories:
    ```
    build/allure-results
    build/reports
    build/test-results
    ```
2. Serve up the Allure report in a browser: `gradlew allureServe` It will open the browser with the UI test report.
