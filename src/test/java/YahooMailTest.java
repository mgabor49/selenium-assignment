import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class YahooMailTest {

    public WebDriver driver;

    /**
     * Sets up the WebDriver
     */
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    /**
     * Makes a new SignInPage object with the WebDriver as parameter and calls its makeLogin() function to execute
     * a login that returns a MainPage object. After that it tests if title of the main page contains the given username.
     */
    @Test
    public void LoginTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        MainPage mainPage = signInPage.makeLogin();
        Assert.assertTrue(mainPage.driver.getTitle().contains("mgaborselenium@yahoo.com"));
    }

    /**
     * Makes a new SignInPage object with the WebDriver as parameter and makes a login. After that it fills the Compose
     * page with the formFill() function of the MainPage object and tests whether the title contains the users username.
     */
    @Test
    public void formFillTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        MainPage mainPage = signInPage.makeLogin();
        mainPage = mainPage.formFill();
        Assert.assertTrue(mainPage.driver.getTitle().contains("mgaborselenium@yahoo.com"));
    }

    /**
     * Makes a new SignInPage object with the WebDriver as parameter and makes a login. After the successful login it
     * makes a logout with the logout() function of the MainPage object and check for the Yahoo Mail title.
     */
    @Test
    public void logoutTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        MainPage mainPage = signInPage.makeLogin();
        signInPage = mainPage.logout();
        Assert.assertEquals("Yahoo Mail", signInPage.driver.getTitle());
    }

    /**
     * Tests the Help link of the Sign-in page and check for the title of the Help page.
     */
    @Test
    public void staticPageTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        Assert.assertEquals("Help for your Yahoo Account", signInPage.staticHelpTest());
    }

    /**
     * Makes a new SignInPage object with the WebDriver as parameter and makes a login. After the sign-in it hovers to
     * the profile hover in the top right corner of the page and checks for the users' username.
     */
    @Test
    public void hoverOnProfileTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        MainPage mainPage = signInPage.makeLogin();
        Assert.assertEquals("mgaborselenium", mainPage.hoverOnProfile());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
