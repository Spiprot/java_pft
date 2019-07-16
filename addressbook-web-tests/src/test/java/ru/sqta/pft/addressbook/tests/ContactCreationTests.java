package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCreation();
            app.getGroupHelper().fillGroupFormdefault();
            app.getGroupHelper().submitGroupCreation();
            app.getNavigationHelper().returnToGroupPage();
        }
        app.getNavigationHelper().gotoAddNewContactPage();
        app.getContactHelper().fillContactInfo(new ContactData("Ayrat", "Mindubaev",
                        "Anvarovich", "Spiprot", "InfoTeCS", "Ufa", "test1",
                        "89373408863", "spiprot@bk.ru", "2", "February", "1995"),
                true);
        app.getContactHelper().submitContact();
    }
}