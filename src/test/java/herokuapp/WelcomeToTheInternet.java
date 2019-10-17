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

public class WelcomeToTheInternet {
    WebDriver driver;

    @Test
    public void test02AddRemoveElements() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        startBrowserAndOpenPage2();
        openPageAddRemoveElements();
        addElement();
        verifyElements();
//        verifyPage2();
//        closeBrowser2();
    }

    private void verifyElements() {
        List<WebElement> listOfElements = driver.findElements(By.className("added-manually"));
        int actual = listOfElements.size();
        int expected = 2;
        Assert.assertEquals(actual, expected, "Expected = " + expected + ". Actual = " + actual);
    }

    private void addElement(){ 
        driver.findElement(By.cssSelector("#content > div > button")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    private void openPageAddRemoveElements() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
    }

    public void startBrowserAndOpenPage2(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        driver.get("https://the-internet.herokuapp.com/");
    }

//    @Test
//    public void test01ABtesting(){
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");
//
//        startBrowserAndOpenPage();
//        clickLink();
//        verifyPage();
//        closeBrowser();
//    }
//    private void closeBrowser() {
//        driver.quit();
//    }
//    private void verifyPage() {
//        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
//        String title = webElement.getText();
//        System.out.println(title);
//        String expectedTitle = "A/B Test Control";
//        Assert.assertEquals(title, expectedTitle);
//    }
//    private void clickLink() {
//        driver.findElement(By.linkText("A/B Testing")).click();
//    }
//    private void startBrowserAndOpenPage() {
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://the-internet.herokuapp.com/");
//    }
}
