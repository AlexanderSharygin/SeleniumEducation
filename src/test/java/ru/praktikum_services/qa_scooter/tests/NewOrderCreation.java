package ru.praktikum_services.qa_scooter.tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.praktikum_services.qa_scooter.po.*;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class NewOrderCreation {
    OrderWizard_ForWhomScooterPage forWhomScooterPage;
    OrderWizard_AboutRentPage aboutRentPage;
    OrderWizard_ConfirmOrderPopup confirmationPopup;
    OrderWizard_OrderCompletedPopup orderCompletedPopup;
    OrderInfoPage orderInfoPage;
    MainPage mainPage;

    @BeforeEach
    public void beforeTestActions() {
        startMaximized = true;
        mainPage =  open(MainPage.URL, MainPage.class);
        mainPage.clickCloseCookieBannerButton();

    }

    @Test
    public void orderFirstSetOfValuesCreatedSuccessfully() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        aboutRentPage = forWhomScooterPage.setNameFieldValue("Ваня").
                setSurnameFieldValue("Иванов").
                setAddressFieldValue("г.Москва, ул. Ленина 21 корпус 1, квартира 1").
                setMetroStationFieldValue("Черкизовская")
                .setTelephoneFieldValue("8999912345678")
                .clickNextButton();
        confirmationPopup = aboutRentPage.setWhenGiveScooterFieldValue("27.10.2021").
                setRentPeriodInputFieldValue("сутки").
                setGreyColorForScooter().
                setCommentFieldValue("Люблю сёрые скутеры").
                clickMakeOrderButton();
        orderCompletedPopup = confirmationPopup.clickConfirmOrderButton();
        assertTrue(orderCompletedPopup.isOrderCompleted());
        orderInfoPage = orderCompletedPopup.clickViewOrderStatusButton();
        assertTrue(orderInfoPage.isOrderTrackRoadmapExistOnPage());
    }

    @Test
    public void orderSecondSetOfValuesCreatedSuccessfully() {
        forWhomScooterPage = mainPage.clickMakeOrderButtonOnPage();
        aboutRentPage = forWhomScooterPage.setNameFieldValue("Маша").
                setSurnameFieldValue("Петрова").
                setAddressFieldValue("Московская обл., Балашиха, ул. Кирова, квартира 1").
                setMetroStationFieldValue("Щёлковская")
                .setTelephoneFieldValue("888845661232")
                .clickNextButton();
        confirmationPopup = aboutRentPage.setWhenGiveScooterFieldValue("28.11.2021").
                setRentPeriodInputFieldValue("двое суток").
                setBlackColorForScooter().
                setCommentFieldValue("Люблю всё чёрное").
                clickMakeOrderButton();
        orderCompletedPopup = confirmationPopup.clickConfirmOrderButton();
        assertTrue(orderCompletedPopup.isOrderCompleted());
        orderInfoPage = orderCompletedPopup.clickViewOrderStatusButton();
        assertTrue(orderInfoPage.isOrderTrackRoadmapExistOnPage());
    }

    @AfterEach
    public void afterTestActions() {
        closeWebDriver();
    }

}



