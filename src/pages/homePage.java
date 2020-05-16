package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class homePage {

    String baseUrl = "https://play.google.com/store?hl=en";
    WebDriver driver;
    public homePage(WebDriver driver){
        this.driver = driver;
    }

    public void openApps(){
            driver.findElement(By.xpath("//*[@id=\"fcxH9b\"]/div[1]/c-wiz[1]/ul/li[2]/a/span/span[2]")).click();
        }
        void openMovies(){
            driver.findElement(By.xpath("//*[@id=\"fcxH9b\"]/div[1]/c-wiz[1]/ul/li[3]/a/span/span[2]")).click();
        }
        void openBooks(){
            driver.findElement(By.xpath("//*[@id=\"fcxH9b\"]/div[1]/c-wiz[1]/ul/li[4]/a/span/span[2]")).click();
        }

    public void search(String keyword){
        driver.findElement(By.xpath("//*[@id=\"gbqfq\"]")).sendKeys(keyword);
        driver.findElement(By.xpath("//*[@id=\"gbqfb\"]/span")).click();
    }
}