package com.saucedemo.automation.tests.smoke;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeSmokeTest extends BaseTest {

    @Test
    public void invalidUserShouldSeeErrorMessage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        String actualError = loginPage.getErrorMessage();

        Assert.assertTrue(
            actualError.contains("Username and password do not match"),
            "Expected error message not displayed"
        );
    }
}
