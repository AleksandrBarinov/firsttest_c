package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import pages.QuestionnairePage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
        ArrayList tabs2 = new ArrayList(BaseSteps.driver.getWindowHandles());
        BaseSteps.driver.switchTo().window((String) tabs2.get(1));
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
    @When("проверка сообщения об ошибке")
    public void checkErrorMessage(){
        QuestionnairePage questionnairePage = new QuestionnairePage(BaseSteps.driver);

        assertEquals("Заполнены не все поля",questionnairePage.getErrorMessage().getText());
    }
}
