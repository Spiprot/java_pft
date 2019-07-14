package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.sqta.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        if (isElementPresent(By.name("selected[]"))){
            click(By.name("selected[]"));
        } else {
            new NavigationHelper(driver).gotoGroupPage();
            initGroupCreation();
            fillGroupForm(new GroupData("Ayrat", "Mindubaev",null));
            new GroupHelper(driver).submitGroupCreation();
            new NavigationHelper(driver).returnToGroupPage();
            click(By.name("selected[]"));
        }
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}