package com.saucedemo.automation.tests.smoke;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.InventoryPage;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutSmokeTest extends BaseTest {

    @Test
    public void userCanLogoutSuccessfully() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Logout
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.logout();

        // Verify redirected to login page
        Assert.assertTrue(
            loginPage.isLoginPageDisplayed(),
            "Logout failed"
        );
    }
}
