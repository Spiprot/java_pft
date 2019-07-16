package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHome();
        if (!app.getContactHelper().isElementPresent(By.name("selected[]"))) {
            app.getNavigationHelper().gotoAddNewContactPage();
            app.getContactHelper().fillContactInfodefault();
            app.getContactHelper().submitContact();
            app.getNavigationHelper().returnToHomePage();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
    }
}