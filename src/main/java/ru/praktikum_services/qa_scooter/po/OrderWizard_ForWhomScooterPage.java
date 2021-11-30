package ru.praktikum_services.qa_scooter.po;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;


public class OrderWizard_ForWhomScooterPage {

    //локатор ссылки перехода на главную страницу
    @FindBy(how = How.CSS,using = "a[href='/']")
    private SelenideElement redirectToMainPageLink;
    //локатор поля имя
    @FindBy(how = How.CSS,using = "input[placeholder='* Имя']")
    private SelenideElement nameInput;
    //локатор сообщения об ошибке поля Имя
   @FindBy(how = How.CSS,using = "input[placeholder='* Имя']+div")
    private SelenideElement validationMessageForNameInput;
    //локатор поля фамилия
    @FindBy(how = How.CSS, using = "input[placeholder='* Фамилия']")
    private SelenideElement surnameInput;
    //локатор сообщения об ошибке поля фамилия
    @FindBy(how = How.CSS,using = "input[placeholder='* Фамилия']+div")
    private SelenideElement validationMessageForSurnameInput;
    //локатор поля адрес
    @FindBy(how = How.CSS, using = "input[placeholder='* Адрес: куда привезти заказ']")
    private SelenideElement addressInput;
    //локатор сообщения об ошибке поля фамилия
    @FindBy(how = How.CSS, using = "input[placeholder='* Адрес: куда привезти заказ']+div")
    private SelenideElement validationMessageForAddressInput;
    //локатор поля станция метро
    @FindBy(how = How.CSS, using = "input.select-search__input")
    private SelenideElement metroStationSelector;
    //локатор сообщения об ошибке поля станция метро
    @FindBy(how = How.CSS, using = "div.Order_MetroError__1BtZb")
    private SelenideElement validationMessageForMetroStationSelector;
       //локатор выпадающего списка метро
    @FindBy(how = How.CSS,using = "div.select-search__select")
    private SelenideElement metroStationsList;
    //локатор плейсхолдера Выберите станцию
    @FindBy(how = How.XPATH,using = ".//div[text()='Выберите станцию']")
    private SelenideElement selectStationPlaceholder;
   //локатор поля телефон
    @FindBy(how = How.CSS, using = "input[placeholder='* Телефон: на него позвонит курьер']")
    private SelenideElement telephoneInput;
    //локатор сообщения об ошибке поля телефон
    @FindBy(how = How.CSS, using = "input[placeholder='* Телефон: на него позвонит курьер']+div")
    private SelenideElement validationMessageForTelephoneInput;
    //локатор кнопки далее
    @FindBy(how = How.XPATH,using = ".//button[text()='Далее']")
    private SelenideElement nextButton;



    public boolean isNewOrderWizardIsStarted()
    {
       return nameInput.isDisplayed() && surnameInput.isDisplayed() &&  addressInput.isDisplayed() &&  metroStationSelector.isDisplayed() && telephoneInput.isDisplayed();
    }

    public OrderWizard_ForWhomScooterPage setNameFieldValue(String value)
    {
        nameInput.setValue(value);
        return this;
    }
    public OrderWizard_ForWhomScooterPage setSurnameFieldValue(String value)
    {
        surnameInput.setValue(value);
        return this;
    }
    public OrderWizard_ForWhomScooterPage setAddressFieldValue(String value)
    {
        addressInput.setValue(value);
        return this;
    }
    public OrderWizard_ForWhomScooterPage setMetroStationFieldValue(String value)
    {
        metroStationSelector.click();
        metroStationSelector.setValue(value);
        metroStationsList.find(By.xpath(".//ul/li[@data-index='1']")).click();
        return this;
    }

    public OrderWizard_ForWhomScooterPage setTelephoneFieldValue(String value)
    {
        telephoneInput.setValue(value);
        return this;
    }
    public OrderWizard_AboutRentPage clickNextButton()
    {
        nextButton.click();
        return  page(OrderWizard_AboutRentPage.class);
    }
    public String clickRedirectToMainPageLink()
    {
        redirectToMainPageLink.click();
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public boolean isNameFieldValidationPassed(String value)
    {
        nameInput.setValue(value);
        nextButton.click();
       return !nameInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isNameFieldValidationFailed(String value)
    {
        nameInput.setValue(value);
        nextButton.click();
       return nameInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isNameFieldEmptyValidationCorrect()
    {

        nextButton.click();
        return nameInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isSurnameFieldValidationPassed(String value)
    {
        surnameInput.setValue(value);
        nextButton.click();
        return !surnameInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }


    public boolean isSurnameFieldValidationFailed(String value)
    {

        surnameInput.setValue(value);
        nextButton.click();
        return surnameInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isSurnameFieldEmptyValidationCorrect()
    {

        nextButton.click();
        return surnameInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }

    public boolean isAddressFieldValidationPassed(String value)
    {
        addressInput.setValue(value);
        nextButton.click();
        return !addressInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isAddressFieldValidationFailed(String value)
    {
        addressInput.setValue(value);
        nextButton.click();
        return addressInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isAddressFieldEmptyValidationCorrect()
    {

        nextButton.click();
        return addressInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isMetroStationFieldEmptyValidationCorrect()
    {

        nextButton.click();
        return selectStationPlaceholder.is(Condition.cssClass("Order_MetroError__1BtZb"));

    }

    public boolean isTelephoneFieldValidationPassed(String value)
    {
       telephoneInput.setValue(value);
        nextButton.click();
        return !telephoneInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean  isTelephoneFieldValidationFailed(String value)
    {
        telephoneInput.setValue(value);
        nextButton.click();
        return telephoneInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public boolean isTelephoneFieldEmptyValidationCorrect()
    {

        nextButton.click();
        return telephoneInput.is(Condition.cssClass("Input_Error__1Tx5d"));

    }
    public String getNameFieldValidationMessage() {
        nameInput.setValue("Vasya");
        nextButton.click();
        return validationMessageForNameInput.text();


    }

    public String getSurnameFieldValidationMessage() {
        surnameInput.setValue("789");
        nextButton.click();
        return validationMessageForSurnameInput.text();


    }

    public String getAddressFieldValidationMessage() {
        addressInput.setValue("999a");
        nextButton.click();
        return validationMessageForAddressInput.text();


    }
    public String getMetroStationSelectorValidationMessage() {

        nextButton.click();
        return validationMessageForMetroStationSelector.text();


    }

    public String getTelephoneFieldValidationMessage() {
        telephoneInput.setValue("777");
        nextButton.click();
        return validationMessageForTelephoneInput.text();


    }

}