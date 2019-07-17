package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHome();
        contactPrecondition();
        int before = app.getContactHelper().getElementsCount();
        app.getContactHelper().initContactModification(before - 1);
        app.getContactHelper().fillContactInfo(new ContactData("Ayrat", "Mindubaev",
                "Anvarovich", "Spiprot", "InfoTeCS", "Ufa", null,
                "89373408863", "spiprot@bk.ru", "2", "February",
                "2022"), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContactHelper().getElementsCount();
        Assert.assertEquals(after, before);
    }
}