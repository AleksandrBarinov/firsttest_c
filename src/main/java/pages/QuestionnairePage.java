package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuestionnairePage {

    @FindBy(name = "insured0_surname")
    WebElement insuredSurname;
    @FindBy(name = "insured0_name")
    WebElement insuredName;
    @FindBy(name = "insured0_birthDate")
    WebElement insuredBirthDate;

    @FindBy(name = "surname")
    WebElement surname;
    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "middlename")
    WebElement middlename;
    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(name = "passport_series")
    WebElement passportSeries;
    @FindBy(name = "passport_number")
    WebElement passportNumber;
    @FindBy(name = "issueDate")
    WebElement issueDate;
    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//div[text()='Минимальная']")
    WebElement minimal;
    @FindBy(xpath = "//span[text()='Оформить']")
    WebElement register;
    @FindBy(xpath = "//*[text()='Продолжить']")
    WebElement continueButton;

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(xpath = "//*[text()='Заполнены не все обязательные поля']")
    WebElement errorMessage;

    public QuestionnairePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void selectMinimal (WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.visibilityOf(minimal)).click();
    }
    public void selectRegister (WebDriver driver) {
        Wait <WebDriver> wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.visibilityOf(register)).click();
    }

    public void selectContinue (WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.visibilityOf(continueButton)).click();
    }



    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "insuredSurname":
                fillField(insuredSurname, value);
                break;
            case "insuredName":
                fillField(insuredName, value);
                break;
            case "insuredBirthDate":
                fillField(insuredBirthDate, value);
                break;

            case "surname":
                fillField(surname, value);
                break;
            case "name":
                fillField(name, value);
                break;
            case "middlename":
                fillField(middlename, value);
                break;
            case "birthDate":
                fillField(birthDate, value);
                break;

            case "passportSeries":
                fillField(passportSeries, value);
                break;
            case "passportNumber":
                fillField(passportNumber, value);
                break;
            case "issueDate":
                fillField(issueDate, value);
                break;
            case "issuePlace":
                fillField(issuePlace, value);
                break;

        }


    }

    protected void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);

    }

}
