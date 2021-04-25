

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import hw3.LoginPage;
import hw3.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class attempt1 {

        private WebDriver driver;

        @BeforeTest
        public void setup() {
            driver = getDriver();
        }

        @Test
        public void invalidCredentials() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.open();
            assertTrue(loginPage.isLoaded());
            loginPage.login("email", "pass");
            String errorMessage = loginPage.getErrorMessage();
            assertEquals(errorMessage, "The email or mobile number you entered isn’t connected to an account. Find your account and log in.");

        }

    @Test
    public void missingCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "pass");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "The email or mobile number you entered isn’t connected to an account. Find your account and log in.");

    }

    @Test
    public void trueCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("pahumi84@gmail.com", ""); //this test case works
        assertTrue(new ProductPage(driver).isLoaded());

    }

        private WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver", "/Users/User/IdeaProjects/untitled3/src/main/resources/Drivers/chromedriver");
            return new ChromeDriver();
        }

        @AfterTest
        public void teardown() {
            driver.quit();
        }

    }

