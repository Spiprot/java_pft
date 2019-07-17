package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sqta.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContact() {
        click(By.name("submit"));
    }

    public void fillContactInfo(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        type(By.name("byear"), contactData.getByear());
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void fillContactInfo() {
        fillContactInfo(new ContactData("Ayrat", "Mindubaev", "Anvarovich",
                "Spiprot", "InfoTeCS", "Ufa", "test1", "89373408863",
                "spiprot@bk.ru", "2", "February", "1995"), true);
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
        driver.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        driver.findElements(By.xpath("//img[@title=\"Edit\"]")).get(index).click();
    }

    public boolean isContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (WebElement row : driver.findElements(By.name("entry"))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            contacts.add(new ContactData(cells.get(1).getText(), cells.get(2).getText()));
        }
        return contacts;
    }

    //public List<ContactData> getContactList() {
    // List<ContactData> contacts = new ArrayList<ContactData>();
    //  List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    //  for (WebElement element : elements) {
    //     String name = element.getText();
    // GroupData group = new GroupData(name,null,null);
    // groups.add(group);
    // }
    //return groups;
    // }
}