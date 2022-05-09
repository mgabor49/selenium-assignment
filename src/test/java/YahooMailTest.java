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


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void LoginTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        MainPage mainPage = signInPage.makeLogin();
        Assert.assertTrue(mainPage.driver.getTitle().contains("mgaborselenium@yahoo.com"));
    }

    @Test
    public void formFillTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        MainPage mainPage = signInPage.makeLogin();
        mainPage = mainPage.formFill();
        Assert.assertTrue(mainPage.driver.getTitle().contains("mgaborselenium@yahoo.com"));
    }

    @Test
    public void logoutTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        MainPage mainPage = signInPage.makeLogin();
        signInPage = mainPage.logout();
        Assert.assertEquals("Yahoo Mail", signInPage.driver.getTitle());
    }

    @Test
    public void staticPageTest(){
        SignInPage signInPage = new SignInPage(this.driver);
        Assert.assertEquals("Help for your Yahoo Account", signInPage.driver.getTitle());
    }

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
