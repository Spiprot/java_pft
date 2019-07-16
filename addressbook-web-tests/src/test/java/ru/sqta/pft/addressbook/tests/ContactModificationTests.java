package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHome();
        if (!app.getContactHelper().isElementPresent(By.name("selected[]"))) {
            app.getNavigationHelper().gotoAddNewContactPage();
            app.getContactHelper().fillContactInfodefault();
            app.getContactHelper().submitContact();
            app.getNavigationHelper().returnToHomePage();
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactInfo(new ContactData("Ayrat", "Mindubaev",
                "Anvarovich", "Spiprot", "InfoTeCS", "Ufa", null, "89373408863",
                "spiprot@bk.ru", "2", "February", "2020"), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
    }
}