package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import utils.Helpers;

public class ShoppingCartPage {

    private WebDriver driver;
    Integer waits = 15;

    private final String shoppingCartPopUp = "//*[@id=\"cart-popup\"]/div[2]/div[1]/h2";
    private final String closePopUp = "close";
    private final String goToshoppingCart = "cart_popup_header";
    private final String deleteFromShoppingCart = "before_delete";

    public ShoppingCartPage(WebDriver driver) {this.driver = driver;}

    @Step("Appearence of a pop-up window after buying some product")
    public void popUpAppearenceWhenBuying(){
        Helpers helpers = new Helpers(driver);
        helpers.waitForPresenceByXpath(shoppingCartPopUp);
    }

    @Step("Closing pop-up window")
    public void closeCurrentPopUp(){
        driver.findElement(By.name(closePopUp)).click();
    }

    @Step("Checking whether the product is presented in shopping cart")
    public void wasTheProductAddedToShoppingCart(){
        Helpers helpers = new Helpers(driver);
        WebElement goToShoppingCart = (new WebDriverWait(driver, waits))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(goToshoppingCart)));
        goToShoppingCart.click();
        helpers.waitForPresenceByName(deleteFromShoppingCart);
    }
}
