package herokuapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ABtesting {
    WebDriver driver;


    @Test
    public void aBtesting() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        startBrowserAndOpenPage();
        clickLink();
        verifyPage();
        closeBrowser();
    }

    private void closeBrowser() {
        driver.quit();
    }

    private void verifyPage() {
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        String title = webElement.getText();
        System.out.println(title);
        String expectedTitle = "A/B Test Control";
        Assert.assertEquals(title, expectedTitle);
    }

    private void clickLink() {
        driver.findElement(By.linkText("A/B Testing")).click();
    }

    private void startBrowserAndOpenPage() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
    }
}
