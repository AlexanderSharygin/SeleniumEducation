package ru.praktikum_services.qa_scooter.po;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class OrderWizard_AboutRentPage {
    //локатор ссылки перехода на главную страницу
    @FindBy(how = How.CSS,using = "a[href='/']")
    private SelenideElement redirectToMainPageLink;
    //локатор поля Когда привезти
    @FindBy(how = How.CSS,using = "input[placeholder='* Когда привезти самокат']")
    private SelenideElement whenGiveScooterField;
    //локатор поля Срок аренды
    @FindBy(how = How.CSS,using = "span.Dropdown-arrow")
    private SelenideElement rentPeriodInput;
    //локатор выпадающего списка поля Срок аренды
    @FindBy(how = How.CSS,using = "div.Dropdown-menu")
    private SelenideElement rentPeriodDropdownList;
    //локатор поля "цвет чёрный"
    @FindBy(how = How.ID,using = "black")
    private SelenideElement isScooterBlack;
    //локатор поля "цвет серый"
    @FindBy(how = How.ID,using = "grey")
    private SelenideElement isScooterGrey;
    //локатор поля комментарий
    @FindBy(how = How.CSS, using = "input[placeholder='Комментарий для курьера']")
    private SelenideElement commentField;
    //локатор кнопки заказать
    @FindBy(how = How.XPATH, using = ".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")
    private SelenideElement makeOrderButton;


    public OrderWizard_AboutRentPage setWhenGiveScooterFieldValue(String value)
    {
        whenGiveScooterField.setValue(value);
        return this;
    }
    public OrderWizard_AboutRentPage setRentPeriodInputFieldValue(String value)
    {
        rentPeriodInput.click();
        rentPeriodDropdownList.find(By.xpath(".//div[text()='"+value+"']")).click();
        return this;
    }
    public OrderWizard_AboutRentPage setGreyColorForScooter()
    {
        isScooterGrey.click();
        return this;
    }
    public OrderWizard_AboutRentPage setBlackColorForScooter()
    {
        isScooterBlack.click();
        return this;
    }
    public OrderWizard_AboutRentPage setCommentFieldValue(String value)
    {
        commentField.setValue(value);
        return this;
    }
    public OrderWizard_ConfirmOrderPopup clickMakeOrderButton()
    {
        makeOrderButton.click();
        return  page(OrderWizard_ConfirmOrderPopup.class);
    }
    public String clickRedirectToMainPageLink()
    {
        redirectToMainPageLink.click();
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

}
