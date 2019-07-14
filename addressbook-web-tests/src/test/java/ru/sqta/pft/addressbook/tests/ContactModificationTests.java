package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHome();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactInfo(new ContactData("Ayrat", "Mindubaev",
                "Anvarovich", "Spiprot", "InfoTeCS", "Ufa", null, "89373408863",
                "spiprot@bk.ru", "2", "February", "1994"),false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
    }
}