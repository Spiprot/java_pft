package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewContactPage();
        app.getContactHelper().fillContactInfo(new ContactData("Ayrat", "Mindubaev",
                "Anvarovich", "Spiprot", "InfoTeCS", "Ufa", "89373408863",
                "spiprot@bk.ru", "2", "February", "1995"));
        app.getContactHelper().submitContact();
    }
}