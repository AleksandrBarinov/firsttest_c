package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    @FindBy(xpath = "//ul[@class='lg-menu__list']")
    WebElement mainMenu;

    @FindBy(xpath = "//div[@class='kitt-col kitt-col_lg_4']//ul[@class='lg-menu__sub-list']//*[contains(@href,'/ru/person/bank_inshure/insuranceprogram/')]/parent::li//parent::ul/parent::div")
    WebElement subMenu;

    @FindBy(xpath = "//div[@data-pid='SBRF-TEXT-2247407']/..//a[text()='Оформить онлайн']")
    WebElement registerOnline;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void selectMainMenu(String menuItem){

        mainMenu.findElement(By.xpath(".//*[text()='"+menuItem+"']")).click();

    }

    public void selectSubMenu(WebDriver driver, String menuItem){
        Wait<WebDriver> wait = new WebDriverWait(driver, 15, 1000);
        WebElement waitButton = driver.findElement(By.xpath(".//*[text()='"+menuItem+"']"));
        wait.until(ExpectedConditions.visibilityOf(waitButton));

        subMenu.findElement(By.xpath(".//*[text()='"+menuItem+"']")).click();

    }

    public void selectRegisterOnline(WebDriver driver) {
        Wait <WebDriver> wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.visibilityOf(registerOnline)).click();
    }

}
