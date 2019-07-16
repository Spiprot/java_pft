package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class SessionHelper extends HelperBase {

    SessionHelper(WebDriver driver) {
        super(driver);
    }

    void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//*[@id=\"LoginForm\"]/input[3]"));
    }
}