package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.sqta.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    void groupPrecondition() {
        app.goTo().GroupPage();
        if (!app.group().isGroup()) {
            app.group().initGroupCreation();
            app.group().fillGroupForm();
            app.group().submitGroupCreation();
            app.goTo().returnToGroupPage();
        }
    }

    void contactPrecondition() {
        if (!app.getContactHelper().isContact()) {
            app.goTo().gotoAddNewContactPage();
            app.getContactHelper().fillContactInfo();
            app.getContactHelper().submitContact();
            app.goTo().returnToHomePage();
        }
    }
}