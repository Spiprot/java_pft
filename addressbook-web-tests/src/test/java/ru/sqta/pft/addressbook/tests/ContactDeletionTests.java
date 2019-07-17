package ru.sqta.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHome();
        contactPrecondition();
        int before = app.getContactHelper().getElementsCount();
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHome();
        int after = app.getContactHelper().getElementsCount();
        Assert.assertEquals(after, before - 1);
    }
}