package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    private WebDriver driver;
    Integer waits = 30;

    public Helpers(WebDriver driver) {this.driver = driver;}

    //waiting for element presence by ID
    public void waitForPresenceByID(String ID){
        WebDriverWait wait = new WebDriverWait(driver, waits);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID)));
    }

    //waiting for element presence by XPath
    public void waitForPresenceByXpath(String XPath){
        WebDriverWait wait = new WebDriverWait(driver, waits);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPath)));
    }

    //waiting for element presence by Name
    public void waitForPresenceByName(String Name){
        WebDriverWait wait = new WebDriverWait(driver, waits);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(Name)));
    }

    //Scrolling page uo
    public void scrollPageUp(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, -250);");
    }
}
