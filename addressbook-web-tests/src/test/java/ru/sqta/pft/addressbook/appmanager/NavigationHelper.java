package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
                return;
        }
        click(By.linkText("groups"));
    }

    public void gotoHome() {
        if (isElementPresent(By.id("maintble"))){
            return;
        }
        click(By.linkText("home"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void gotoAddNewContactPage() {
        click(By.linkText("add new"));
    }
}