package ru.sqta.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void testUntitledTestCase() {
        gotoAddNewContactPage();
        fillContactInfo(new ContactData("Ayrat", "Mindubaev", "Anvarovich", "Spiprot", "InfoTeCS", "Ufa", "89373408863", "spiprot@bk.ru", "2", "February", "1995"));
        submitContact();
    }


}
