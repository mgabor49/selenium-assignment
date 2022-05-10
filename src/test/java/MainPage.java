
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Fills the compose letter form on the Addressed, Subject inputs and writes into the text area under them.
     * @return MainPage instance with the state of the driver after the form fill
     * Tasks satisfied:
     *  - Form sending with user
     *  - Fill input 3x
     *  - Send a form 1x
     *  - Complex xPath 3x
     *  - Filling or reading textarea content
     *  - Explicit wait
     */
    public MainPage formFill() {
        WebElement composeButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/nav/div/div[1]/a"));
        composeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message-to-field\"]")));

        WebElement addressed = driver.findElement(By.xpath("//*[@id=\"message-to-field\"]"));
        addressed.sendKeys("mgaborselenium@yahoo.com");

        WebElement subject = driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div/div/div/div[1]/div[3]/div/div/input"));
        subject.sendKeys("Test email");

        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"editor-container\"]/div[1]"));
        textArea.sendKeys("Hello World!");


        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div/div/div/div[2]/div[2]/div/button"));
        sendButton.click();

        return new MainPage(driver);
    }

    /**
     * Makes a log-out.
     * First it clicks the profile name hover in the top right corner, then waits for the sign-out
     * link to appear and clicks it. After that it looks for the button that links back to the Yahoo mail sign-in page.
     * @return SignInPage instance with the current state of the driver.
     * Tasks satisfied:
     *  - Logout
     *  - Explicit wait
     */
    public SignInPage logout(){
        WebElement profileHover = driver.findElement(By.xpath("//*[@id=\"ybar-inner-wrap\"]/div[2]/div/div[3]/div[1]/div"));
        profileHover.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"profile-signout-link\"]")));
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"profile-signout-link\"]"));
        logoutButton.click();

        WebElement backToMailButton = driver.findElement(By.xpath("//*[@id=\"root_1\"]"));
        backToMailButton.click();

        return new SignInPage(driver);
    }

    /**
     * Hovers on the profile name hover in the top right corner.
     * Instantiates an Actions type variable with the driver. Moves the actions cursor to the profile hover and reads
     * the username of the user.
     * @return The username of the user in text format.
     * Task satisfied:
     *  - Hover test
     */
    public String hoverOnProfile(){
        Actions actions = new Actions(driver);

        WebElement profileHover = driver.findElement(By.xpath("//*[@id=\"ybarAccountMenu\"]"));
        actions.moveToElement(profileHover).perform();

        WebElement username = waitAndReturnElement(By.xpath("//*[@id=\"ybarAccountMenuBody\"]/ul/li/div/span[2]"));

        return username.getText();
    }
}
