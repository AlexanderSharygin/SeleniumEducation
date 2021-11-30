package ru.praktikum_services.qa_scooter.tests;

import org.junit.jupiter.api.*;
import ru.praktikum_services.qa_scooter.po.OrderWizard_ForWhomScooterPage;
import ru.praktikum_services.qa_scooter.po.MainPage;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidationTest {
    MainPage mainPage = open(MainPage.URL, MainPage.class);
    OrderWizard_ForWhomScooterPage forWhomScooterPage;


    @BeforeEach
    public void beforeEachTestActions() {

      forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
      mainPage.clickCloseCookieBannerButton();
    }

    @Test
    public void forWhomScooterPageNameFieldValidationPassed() {
        assertTrue(forWhomScooterPage.isNameFieldValidationPassed("Вася"));
    }

    @Test
    public void forWhomScooterPageNameFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isNameFieldValidationFailed("Vasya"));

    }

    @Test
    public void forWhomScooterPageSurnameFieldValidationPassed() {
        assertTrue(forWhomScooterPage.isSurnameFieldValidationPassed("Васин"));
    }

    @Test
    public void forWhomScooterPageSurnameFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isSurnameFieldValidationFailed("000"));
    }

    @Test
    public void forWhomScooterPageAddressFieldValidationPassed() {
        assertTrue(forWhomScooterPage.isAddressFieldValidationPassed("Москва"));
    }

    @Test
    public void forWhomScooterPageAddressFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isAddressFieldValidationFailed("Moscow"));
    }

    @Test
    public void forWhomScooterPageTelephoneFieldValidationPassed() {
        assertTrue(forWhomScooterPage.isTelephoneFieldValidationPassed("89109105621"));
    }

    @Test
    public void forWhomScooterPageTelephoneFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isTelephoneFieldValidationFailed("8910910910"));

    }

    @Test
    public void emptyNameFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isNameFieldEmptyValidationCorrect());

    }

    @Test
    public void emptySurnameNameFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isSurnameFieldEmptyValidationCorrect());
    }

    @Test
    public void emptyAddressNameFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isAddressFieldEmptyValidationCorrect());
    }

    @Test
    public void emptyMetroStationFieldValidationFailed() {
        assertTrue(forWhomScooterPage.isMetroStationFieldEmptyValidationCorrect());
    }

    @Test
    public void emptyTelephoneFieldValidationFailed() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        assertTrue(forWhomScooterPage.isTelephoneFieldEmptyValidationCorrect());
    }

    @Test
    public void validationMessageForNameFieldIsCorrect() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        assertEquals(forWhomScooterPage.getNameFieldValidationMessage(), "Введите корректное имя");
    }

    @Test
    public void validationMessageForSurnameFieldIsCorrect() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        assertEquals(forWhomScooterPage.getSurnameFieldValidationMessage(), "Введите корректную фамилию");
    }

    @Test
    public void validationMessageForAddressFieldIsCorrect() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        assertEquals(forWhomScooterPage.getAddressFieldValidationMessage(), "Введите корректный адрес");
    }

    @Test
    public void validationMessageForMetroStationSelectorIsCorrect() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        assertEquals(forWhomScooterPage.getMetroStationSelectorValidationMessage(), "Выберите станцию");
    }

    @Test
    public void validationMessageForTelephoneFieldIsCorrect() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        assertEquals(forWhomScooterPage.getTelephoneFieldValidationMessage(), "Введите корректный номер");
    }

    @AfterEach
    public void AfterEachAction() {
        forWhomScooterPage.clickRedirectToMainPageLink();
    }


}
