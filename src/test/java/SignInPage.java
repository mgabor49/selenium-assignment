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
        WebElement mailAppComponent = driver.findElement(By.id("mail-app-component"));
        System.out.println(driver.getTitle());

        return new MainPage(driver);
    }

    public String staticHelpTest(){
        WebElement helpLink = driver.findElement(By.xpath("//*[@id=\"login-body\"]/div[1]/span[2]/a"));
        helpLink.click();

        wait.until(ExpectedConditions.titleIs("Help for your Yahoo Account"));
        return driver.getTitle();
    }


}
