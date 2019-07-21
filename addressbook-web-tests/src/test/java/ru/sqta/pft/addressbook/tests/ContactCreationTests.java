package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreation() {
        groupPrecondition();
        app.goTo().gotoHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Ayrat", "Anvarovich",
                "Mindubaev", "Spiprot", "InfoTeCS", "Ufa", "test1",
                "89373408863", "spiprot@bk.ru", "2", "February", "1995");
        app.goTo().gotoAddNewContactPage();
        app.getContactHelper().fillContactInfo(contact, true);
        app.getContactHelper().submitContact();
        app.goTo().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}