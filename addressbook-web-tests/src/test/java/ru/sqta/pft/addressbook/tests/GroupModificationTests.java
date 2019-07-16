package ru.sqta.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.sqta.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCreation();
            app.getGroupHelper().fillGroupFormdefault();
            app.getGroupHelper().submitGroupCreation();
            app.getNavigationHelper().returnToGroupPage();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "Modification"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returnToGroupPage();
    }
}