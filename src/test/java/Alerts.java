import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts {
    WebDriver driver;

    @AfterTest
    public void testName() throws InterruptedException {
        //Thread.sleep(3000); - NOT NEEDED
        driver.quit();
    }
    @Test
    public void test001() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\IdeaProjects\\portnov\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();  System.out.println("browser opened");
        navigateToPage();   System.out.println("page opened");
        findFieldTypeAndSubmit();   System.out.println("typed in field and submitted");
        RejectAlert();  System.out.println("delcine popup window");
        submitAgain();  System.out.println("open popup again");
        acceptAlert();  System.out.println("alert accepted");
        verifyPage();   System.out.println("correct page verified");
    }
    private void verifyPage() {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  -NOT NEEDED
        WebElement webElement = driver.findElement(By.name("cusid"));
        Assert.assertEquals(webElement.isDisplayed(),true);
        System.out.println("text in popup window:  " + webElement);
    }
    private void acceptAlert() throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    private void submitAgain() {
        WebElement webElement = driver.findElement(By.name("submit"));
        webElement.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    private void RejectAlert() throws InterruptedException {
        String alertMsg = driver.switchTo().alert().getText();
        System.out.println(alertMsg);
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    private void findFieldTypeAndSubmit() {
        WebElement webElement = driver.findElement(By.name("cusid"));
        webElement.sendKeys("555");
        webElement.submit();
    }
    private void navigateToPage() {
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }
    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //pageLoadTimeout(10, TimeUnit.SECONDS);- DOESNOT WORK!
    }
}
