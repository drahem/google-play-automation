package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class tedPage {
    WebDriver driver;
    public tedPage(WebDriver driver){
        this.driver = driver;
    }

    public void chooseTed(){
      //  driver.findElement(By.xpath("//*[@id=\"fcxH9b\"]/div[4]/c-wiz[3]/div/div[2]/div/c-wiz/c-wiz/c-wiz/div/div[2]/div[1]/c-wiz/div/div/div[2]/div/div/div[1]/div/div/div[1]")).click();
       driver.findElement(By.xpath("//*[text()='ted']")).click();
       // String expectedUrl = "https://play.google.com/store/apps/details?id=com.ted.android&hl=en";
       // Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

}
