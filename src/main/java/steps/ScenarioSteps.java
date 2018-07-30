package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.QuestionnairePage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static steps.BaseSteps.driver;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    QuestionnaireSteps questionnaireSteps = new QuestionnaireSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.selectMainMenu(menuItem);
    }
    @When("^выбран вид страхования - \"(.*)\"$")
    public void selectSubMenu(String menuItem){
        mainSteps.selectSubMenu(menuItem);
    }
    @When("^выполнено нажатие на кнопку - Оформить онлайн$")
    public void selectRegisterOnline(){
        mainSteps.selectRegisterOnline();
    }
    @When("^выполнено нажатие на кнопку - Минимальный$")
    public void selectMinimal(){
        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));
        questionnaireSteps.selectMinimal();
    }
    @When("^выполнено нажатие на кнопку - Оформить$")
    public void selectRegister(){
        questionnaireSteps.selectRegister();
    }

    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields){
        fields.asMap(String.class,String.class).forEach(
                (key,value) -> questionnaireSteps.stepFillField(key,value)
        );

    }
    @When("^выполнено нажатие на кнопку - Продолжить$")
    public void selectContinue(){
        questionnaireSteps.selectContinue();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        }
    }

    @When("проверка сообщения об ошибке")
    public void checkErrorMessage(){
        QuestionnairePage questionnairePage = new QuestionnairePage(driver);

        isElementPresent(questionnairePage.getErrorMessage());

        if(isElementPresent(questionnairePage.getErrorMessage()) == true){
            assertEquals("Заполнены не все обязательные поля",questionnairePage.getErrorMessage().getText());
        } else {assertTrue("Сообщение об ошибке отсутствует на странице", isElementPresent(questionnairePage.getErrorMessage()));}


    }
}
