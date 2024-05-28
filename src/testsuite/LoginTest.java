package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password is invalid!”
 */
public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    //Annotation
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Annotation
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on the ‘username’
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //click on the ‘password’
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //click on the ‘login’
        driver.findElement(By.tagName("button")).click();

        // Verify the text ‘Secure Area’
        String expectedText = "Secure Area";
        WebElement secureAreaElement = driver.findElement(By.xpath("//h2"));
        String actualText = secureAreaElement.getText();
        Assert.assertEquals(" ", expectedText, actualText);


    }

    //Annotation
    @Test
    public void verifyTheUsernameErrorMessage() {
        //click on the username and enter invalid username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");

        //click on the ‘password’
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //click on the ‘login’
        driver.findElement(By.tagName("button")).click();

        // Verify the text ‘Your username is invalid!’
        String expectedText = "Your username is invalid!\n" + "×";
        WebElement userNameIsInvalidAreaElement = driver.findElement(By.id("flash"));
        String actualText = userNameIsInvalidAreaElement.getText();
        Assert.assertEquals("Error Verification", expectedText, actualText);

    }

    //Annotation
    @Test
    public void verifyThePasswordErrorMessage() {
        //click on the username
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        //click on the password and enter invalid password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //click on the ‘login’
        driver.findElement(By.tagName("button")).click();

        //Verify the text ‘Your password is invalid!’
        String expectedText = "Your password is invalid!\n" + "×";
        WebElement yourPasswordIsInvalidElement = driver.findElement(By.id("flash"));
        String actualText = yourPasswordIsInvalidElement.getText();
        Assert.assertEquals("Error Verification", expectedText, actualText);


    }

    @After
    public void tearDown() {
        driver.close();
    }
}