package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps{

    @Step("Выбран пункт меню {0}")
    public void selectMainMenu(String menuItem){
        new MainPage(BaseSteps.driver).selectMainMenu(menuItem);
    }

    @Step("Выбран пункт {0} в сабменю")
    public void selectSubMenu(String menuItem){
        new MainPage(BaseSteps.driver).selectSubMenu(BaseSteps.driver,menuItem);
    }

    @Step("Нажата кнопка 'Оформить онлайн'")
    public void selectRegisterOnline(){
        new MainPage(BaseSteps.driver).selectRegisterOnline(BaseSteps.driver);
    }

}