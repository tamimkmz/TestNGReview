package review01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class testNG {
    /*GOT TO THE fb.com

asseert that the  email address is enabled
   assert that the login button is enabled*/
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(groups = "regression")
    public void  TestTheForm(){
        WebElement username = driver.findElement(By.id("email"));
        boolean usernameStatus = username.isEnabled();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(usernameStatus);
//        confirm that login button is enabled
        WebElement loginBtn = driver.findElement(By.name("login"));
        boolean loginBtnStatus = loginBtn.isEnabled();
        soft.assertTrue(loginBtnStatus);
        soft.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
