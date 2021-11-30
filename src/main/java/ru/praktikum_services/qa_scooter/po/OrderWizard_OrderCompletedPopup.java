package ru.praktikum_services.qa_scooter.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class OrderWizard_OrderCompletedPopup {
    //локатор лэйбла Заказ оформлен
    @FindBy(how = How.XPATH,using = ".//div[text()='Заказ оформлен']")
    private SelenideElement orderCompletedLabel;
    //локатор кнопки посмотреть статус
    @FindBy(how = How.XPATH,using = ".//button[text()='Посмотреть статус']")
    private SelenideElement viewOrderStatusButton;

    public boolean isOrderCompleted()
    {
        return orderCompletedLabel.isDisplayed();
    }
    public OrderInfoPage clickViewOrderStatusButton()
    {
        viewOrderStatusButton.click();
        return page(OrderInfoPage.class);
    }
}
