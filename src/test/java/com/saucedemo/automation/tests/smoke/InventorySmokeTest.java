package com.saucedemo.automation.tests.smoke;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventorySmokeTest extends BaseTest {

    @Test
    public void userCanAddAndRemoveBikeLightFromCart() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Inventory page object
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Step 3: Verify inventory page loaded
        Assert.assertTrue(
                inventoryPage.isProductsDisplayed(),
                "Inventory page did not load after login"
        );

        // Step 4: Add bike light to cart
        inventoryPage.addItemToCart("sauce-labs-bike-light");

        // Step 5: Verify cart count = 1
        Assert.assertEquals(
                inventoryPage.getCartItemCount(),
                1,
                "Cart count should be 1 after adding bike light"
        );

        // Step 6: Remove bike light from cart
        inventoryPage.removeItemFromCart("sauce-labs-bike-light");

        // Step 7: Verify cart count = 0
        Assert.assertEquals(
                inventoryPage.getCartItemCount(),
                0,
                "Cart count should be 0 after removing bike light"
        );
    }

    @Test
    public void userSeesCorrectCartCountAfterMultipleAddRemoveActions() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        int expectedCount = 0;

        // Add backpack
        inventoryPage.addItemToCart("sauce-labs-backpack");
        expectedCount++;

        // Add bike light
        inventoryPage.addItemToCart("sauce-labs-bike-light");
        expectedCount++;

        // Remove backpack
        inventoryPage.removeItemFromCart("sauce-labs-backpack");
        expectedCount--;

        // Add fleece jacket
        inventoryPage.addItemToCart("sauce-labs-fleece-jacket");
        expectedCount++;

        // Remove bike light
        inventoryPage.removeItemFromCart("sauce-labs-bike-light");
        expectedCount--;

        // Final assertion
        Assert.assertEquals(
                inventoryPage.getCartItemCount(),
                expectedCount,
                "Cart count mismatch after multiple add/remove actions"
        );
    }
}
