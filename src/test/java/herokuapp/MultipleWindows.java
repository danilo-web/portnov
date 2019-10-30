package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultipleWindows {
    private WebDriver driver;

    @Test
    public void test001() {
        startBrowserAndOpenPage();
        verifyCorrectLink();
        clickOnTheLink();
        quantityOfHandlesAssert();
        switchTowWindow2();
        verifyCorrectWindowOpened();
        switchTowWindow1AndBackToWindow2();
        closeWindow2();
        switchToWindow1();
        verifyWindow1();
        driver.quit();
    }


    private void verifyWindow1() {
        WebElement webElement = driver.findElement(By.xpath("//*[text()='Click Here' and @target='_blank']"));
        String actualLink = webElement.getAttribute("href");
        String expectedLink = "https://the-internet.herokuapp.com/windows/new";
        Assert.assertEquals(actualLink, expectedLink, "expected link on the page");
    }

    private void switchToWindow1() {
        Object[] allWindows = driver.getWindowHandles().toArray();
        String window1 = (String) allWindows[0];
        driver.switchTo().window(window1);
    }

    private void closeWindow2() {
        driver.close();
    }

    private void switchTowWindow1AndBackToWindow2() {
        Object[] allWindows = driver.getWindowHandles().toArray();
        String window1 = (String) allWindows[0];
        driver.switchTo().window(window1);
        String window2 = (String) allWindows[1];
        driver.switchTo().window(window2);
    }

    private void verifyCorrectWindowOpened() {
        WebElement webElement = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String actualText = webElement.getText();
        System.out.println(actualText);
        String expectedText = "New Window";
        Assert.assertEquals(actualText, expectedText, "verifyCorrectWindowOpened");
    }

    private void switchTowWindow2() {
        Object[] allWindows = driver.getWindowHandles().toArray();
        String window2 = (String) allWindows[1];
        driver.switchTo().window(window2);
    }

    private void quantityOfHandlesAssert() {
        int actualSizeOfHandles = driver.getWindowHandles().size();
        int expectedSizeOfHandles = 2;
        Assert.assertEquals(actualSizeOfHandles, expectedSizeOfHandles, "quantityOfHandles");
    }

    private void clickOnTheLink() {
        driver.findElement(By.xpath("//*[text()='Click Here' and @target='_blank']")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }

    private void verifyCorrectLink() {
        WebElement webElement = driver.findElement(By.xpath("//*[text()='Click Here' and @target='_blank']"));
        String actualLink = webElement.getAttribute("href");
        String expectedLink = "https://the-internet.herokuapp.com/windows/new";
        Assert.assertEquals(actualLink, expectedLink, "expected link on the page");
    }

    private void startBrowserAndOpenPage() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

}
