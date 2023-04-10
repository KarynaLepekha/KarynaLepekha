package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

public class MobilePhonesPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), ' Діагональ екрана ')]/..//../div//li//a")
    private List<WebElement> listOfCheckBoxes;

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public PhonePageDepandsOnDiagonal selectCheckBox(Double screenDiagonal) {
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfCheckBoxes));
        List<Double> selectedValues = new ArrayList<Double>();

        for (WebElement listOfCheckBox : listOfCheckBoxes) {
            double selectedValue;
            String valueOfCheckBox = listOfCheckBox.getAttribute("data-id");
            if (valueOfCheckBox == null){
                wait.until(ExpectedConditions.visibilityOfAllElements(listOfCheckBoxes));
                valueOfCheckBox = listOfCheckBox.getText();
            }
            String[] allValuesInCheckBox = valueOfCheckBox.split("[^0-9\\.]+");

            if (allValuesInCheckBox.length == 1) {
                selectedValue = Double.parseDouble(allValuesInCheckBox[0]);
            } else selectedValue = Double.parseDouble(allValuesInCheckBox[1]);
            selectedValues.add(selectedValue);
        }
        int index = 0;
        for (Double value : selectedValues) {
            if (screenDiagonal <= value) {
                break;
            }
            index++;
        }
        if (index >= listOfCheckBoxes.size()) {
            listOfCheckBoxes.get(listOfCheckBoxes.size() - 1).click();
        } else {
            listOfCheckBoxes.get(index).click();
        }
        return new PhonePageDepandsOnDiagonal(driver);
    }
}

