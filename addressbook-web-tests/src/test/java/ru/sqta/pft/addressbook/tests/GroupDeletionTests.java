package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCreation();
            app.getGroupHelper().fillGroupFormdefault();
            app.getGroupHelper().submitGroupCreation();
            app.getNavigationHelper().returnToGroupPage();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().returnToGroupPage();
    }
}