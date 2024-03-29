package ru.sqta.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHome();
        contactPrecondition();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
    }
}