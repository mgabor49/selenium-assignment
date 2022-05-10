import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://mail.yahoo.com");
    }

    /**
     * Logs in the user.
     * First it fills out the username input field then clicks next after that it fills out the
     * password field and clicks the login button. It waits for the mailbox component to show up.
     * @return MainPage instance with the state of the driver after the log in.
     * Tasks satisfied:
     *  - Fill simple form and send
     *  - Fill input 2x
     *  - Send a form 1x
     *  - Explicit wait
     */
    public MainPage makeLogin() {
        WebElement username = driver.findElement(By.id("login-username"));
        WebElement nextButton1 = driver.findElement(By.id("login-signin"));

        username.sendKeys("mgaborselenium@yahoo.com");
        nextButton1.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
        WebElement password = driver.findElement(By.id("login-passwd"));
        WebElement nextButton2 = driver.findElement(By.id("login-signin"));

        password.sendKeys("iloveselenium1");
        nextButton2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail-app-component")));

        return new MainPage(driver);
    }

    /**
     * Clicks the help button in the top right corner of the main page, clicks the cookie setter when it appears and
     * checks the title of the page.
     * @return The title of the Help page.
     * Tasks satisfied:
     *  - Static Page test
     *  - Complex xPath 3x
     *  - Explicit wait
     *  - Reading the page title
     */
    public String staticHelpTest(){
        WebElement helpLink = driver.findElement(By.xpath("//*[@id=\"login-body\"]/div[1]/span[2]/a"));
        helpLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"consent-page\"]/div/div/div/form/div[2]/div[2]/button")));
        WebElement cookieClick = driver.findElement(By.xpath("//*[@id=\"consent-page\"]/div/div/div/form/div[2]/div[2]/button"));
        cookieClick.click();

        wait.until(ExpectedConditions.titleIs("Help for your Yahoo Account"));
        return driver.getTitle();
    }


}
