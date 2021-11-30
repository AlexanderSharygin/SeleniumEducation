package ru.praktikum_services.qa_scooter.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class OrderWizard_ConfirmOrderPopup {
    //локатор кноки подвтердить заказ (да)
    @FindBy(how = How.XPATH,using = ".//button[text()='Да']")
    private SelenideElement confirmOrderButton;



    public OrderWizard_OrderCompletedPopup clickConfirmOrderButton()
    {
        confirmOrderButton.click();
        return  page(OrderWizard_OrderCompletedPopup.class);
    }


}
