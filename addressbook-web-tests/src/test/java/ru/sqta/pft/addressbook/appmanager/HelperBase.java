package ru.sqta.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

class HelperBase {

    WebDriver driver;

    HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    void click(By locator) {
        driver.findElement(locator).click();
    }

    void type(By locator, String text) {
        if (text != null) {
            click(locator);
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public int getElementsCount() {
        return driver.findElements(By.name("selected[]")).size();
    }
}