package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    public void init() {
        String browser = BrowserType.CHROME;
        if (browser == BrowserType.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME) {
            driver = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}