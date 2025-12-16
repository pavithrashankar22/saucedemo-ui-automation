package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    // Locator for the Products title
    private By productsTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }
}
