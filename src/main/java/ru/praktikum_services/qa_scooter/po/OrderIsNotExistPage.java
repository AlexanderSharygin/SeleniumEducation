package ru.praktikum_services.qa_scooter.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderIsNotExistPage {

    //локатор сообщения заказ не найден
    @FindBy(how = How.CSS,using = "div.Track_NotFound__6oaoY")
    private SelenideElement orderNotFoundMessage;
    //локатор ссылки перехода на главную страницу
    @FindBy(how = How.CSS,using = "a[href='/']")
    private SelenideElement redirectToMainPageLink;

    public boolean isOrderNotFoundMessageExist()
    {
       return orderNotFoundMessage.is(Condition.visible);
    }

    public String clickRedirectToMainPageLink()
    {
        redirectToMainPageLink.click();
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
