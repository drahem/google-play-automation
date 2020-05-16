package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class educationPage {

    WebDriver driver;
    public educationPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String keyword){
        driver.findElement(By.xpath("//*[@id=\"gbqfq\"]")).sendKeys(keyword+"\n");
        String expectedUrl = "https://play.google.com/store/apps/category/EDUCATION?hl=en";

        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

}
