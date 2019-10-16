import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearch1 {
    WebDriver driver;
    String resultID = "resultStats";

    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }
    @Test
    public void test0001() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        navigateToMainPage();
        typeQuory();
        //submitSearch();
        waitForResultElement();
        assertResultPage();
    }
    private void assertResultPage() {
        WebElement resultStatsElement = driver.findElement(By.id(resultID));
        boolean isDisplayed = resultStatsElement.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(isDisplayed, expected);
    }
    private void waitForResultElement() {
        By elementToWait = By.id(resultID);
        ExpectedCondition condition = ExpectedConditions.presenceOfElementLocated(elementToWait);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
       webDriverWait.until(condition);
    }
    private void submitSearch() {
        String selector = "#tsf > div:nth-child(2) > div.A8SBwf > div.FPdoLc.VlcLAe > center > input.gNO89b";
        driver.findElement(By.cssSelector(selector)).submit();
    }
    private void typeQuory() {
        String selector = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
        WebElement webElement = driver.findElement(By.cssSelector(selector));
        webElement.sendKeys("Portnov computer school");
        webElement.submit();
    }
    private void navigateToMainPage() {
        String url = "https://google.com";
        driver.get(url);
    }
    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}