package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.sqta.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    void groupPrecondition() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isGroup()) {
            app.getGroupHelper().initGroupCreation();
            app.getGroupHelper().fillGroupForm();
            app.getGroupHelper().submitGroupCreation();
            app.getNavigationHelper().returnToGroupPage();
        }
    }

    void contactPrecondition() {
        if (!app.getContactHelper().isContact()) {
            app.getNavigationHelper().gotoAddNewContactPage();
            app.getContactHelper().fillContactInfo();
            app.getContactHelper().submitContact();
            app.getNavigationHelper().returnToHomePage();
        }
    }
}