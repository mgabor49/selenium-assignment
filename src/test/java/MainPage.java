
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

    public String hoverOnProfile(){
        Actions actions = new Actions(driver);

        WebElement profileHover = driver.findElement(By.xpath("//*[@id=\"ybarAccountMenu\"]"));
        actions.moveToElement(profileHover).perform();

        WebElement username = waitAndReturnElement(By.xpath("//*[@id=\"ybarAccountMenuBody\"]/ul/li/div/span[2]"));

        return username.getText();
    }
}
