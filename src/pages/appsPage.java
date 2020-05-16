package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class appsPage {
    WebDriver driver;
    public appsPage(WebDriver driver){
        this.driver = driver;
    }

    public void openCategory(){
        driver.findElement(By.xpath("//*[@id=\"action-dropdown-parent-Categories\"]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"action-dropdown-children-Categories\"]/div/ul/li[1]/ul/li[11]")).click();
        String expectedUrl = "https://play.google.com/store/apps?hl=en";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
