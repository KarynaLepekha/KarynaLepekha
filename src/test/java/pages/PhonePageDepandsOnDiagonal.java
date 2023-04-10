package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PhonePageDepandsOnDiagonal extends BasePage{
    private List <Double> listOfValues;
    @FindBy(xpath = "//a[@class='catalog-selection__link']")
    private WebElement valuesOfDiagonal;

    public PhonePageDepandsOnDiagonal(WebDriver driver) {
        super(driver);
    }

    public String getValueOfDiagonal() {
        wait.until(ExpectedConditions.visibilityOf(valuesOfDiagonal));
        return valuesOfDiagonal.getText();
    }
}
