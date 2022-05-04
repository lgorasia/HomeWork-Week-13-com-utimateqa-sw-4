package com.ultimateqa.courses.testsuite;


import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.SigninPage;
import com.ultimateqa.courses.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SigninPageTest extends TestBase {
    HomePage homepage = new HomePage();
    SigninPage signinPage = new SigninPage();

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        homepage.clickOnsigninLink();
       String expectedMessage = "Welcome Back!";
        String actualMessage = signinPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");

    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {
        homepage.clickOnsigninLink();
        signinPage.enterUsername("abc@yahoo.com");
        signinPage.enterPassword("123456");
        signinPage.cliclOnLoginButton();

        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = signinPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }


}
