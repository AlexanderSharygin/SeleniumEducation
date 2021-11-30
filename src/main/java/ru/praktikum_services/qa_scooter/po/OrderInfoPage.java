package ru.praktikum_services.qa_scooter.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderInfoPage {

     //локатор карты статуса заказа
    @FindBy(how = How.CSS,using = "div.Track_OrderRoadmap__3eUiE")
    private SelenideElement orderTrackRoadmap;

    public boolean isOrderTrackRoadmapExistOnPage()
    {
        return orderTrackRoadmap.isDisplayed();
    }

}