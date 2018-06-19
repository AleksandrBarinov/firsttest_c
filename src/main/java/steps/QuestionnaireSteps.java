package steps;

import pages.QuestionnairePage;
import ru.yandex.qatools.allure.annotations.Step;

public class QuestionnaireSteps{

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new QuestionnairePage(BaseSteps.driver).fillField(field,value);
    }

    @Step("Нажата кнопка 'Минимальный'")
    public  void selectMinimal(){
        new QuestionnairePage(BaseSteps.driver).selectMinimal(BaseSteps.driver);
    }

    @Step("Нажата кнопка 'Оформить'")
    public void selectRegister(){
        new QuestionnairePage(BaseSteps.driver).selectRegister(BaseSteps.driver);
    }

    @Step("Нажата кнопка 'Продолжить'")
    public void selectContinue(){
        new QuestionnairePage(BaseSteps.driver).selectContinue(BaseSteps.driver);
    }

}
