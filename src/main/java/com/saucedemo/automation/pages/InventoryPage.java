package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    private WebDriver driver;

    // Page locators
    private By productsTitle = By.className("title");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");
    private By menuButton=By.id("react-burger-menu-btn");
    private By logoutLink=By.id("logout_sidebar_link");
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public void addItemToCart(String productId) {
        By addToCartButton = By.id("add-to-cart-" + productId);
        driver.findElement(addToCartButton).click();
    }

    public void removeItemFromCart(String productId) {
        By removeButton = By.id("remove-" + productId);
        driver.findElement(removeButton).click();
    }

    public boolean isCartBadgeDisplayed() {
        return driver.findElements(cartBadge).size() > 0;
    }

    public int getCartItemCount() {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
    public void logout() {
    // Open menu
    driver.findElement(menuButton).click();

    // Small wait for sidebar animation (simple & acceptable for demo apps)
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Click logout
    driver.findElement(logoutLink).click();
}
   }

