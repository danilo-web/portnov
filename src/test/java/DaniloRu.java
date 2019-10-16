import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DaniloRu {
    WebDriver driver;
    String result1 = "/html/body/pre/font/font/text()";
    String result2 = "/html/body/center/font/a/input";


    @Test
    public void test1() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        navigateToMainPage();
        typeQuery();
        //setDropBox();
        submitSearch();
        checkBox();
        //weitForResultElement();
        //assertResultPage();

    }

    private void checkBox() {
        String selector = "#main-filters > div:nth-child(4) > section:nth-child(1) > fieldset > ul > li:nth-child(1) > div > div > div > label > " +
                "div > i";
        WebElement checkBoxNew = driver.findElement(By.cssSelector(selector));
        checkBoxNew.click();
    }


    private void assertResultPage() {

            WebElement resultStatsElement = driver.findElement(By.xpath(result1));
            WebElement resultStatsElement2 = driver.findElement(By.xpath(result2));

            boolean isDisplayed = resultStatsElement.isDisplayed() || resultStatsElement2.isDisplayed();
            boolean expected = true;
            Assert.assertEquals(isDisplayed, expected);


    }
    private void submitSearch() {
        String selector = "header-search-button";
        driver.findElement(By.className(selector)).submit();
        System.out.println("search submited");
    }
    private void setDropBox() {
        Select domen = new Select(driver.findElement(By.name("name")));
        domen.selectByVisibleText("com");
    }

    private void typeQuery() {
        String selector = "gh-search-input";
        WebElement webElement = driver.findElement(By.id(selector));
        webElement.sendKeys("mackbook air");
        System.out.println("typed query");
    }
    private void navigateToMainPage() {
        String url = "https://www.bestbuy.com/";
        driver.get(url);
        System.out.println("open page");
    }
    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("browser opened");
    }
}