package ru.praktikum_services.qa_scooter.tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.praktikum_services.qa_scooter.po.OrderWizard_AboutRentPage;
import ru.praktikum_services.qa_scooter.po.OrderWizard_ForWhomScooterPage;
import ru.praktikum_services.qa_scooter.po.MainPage;
import ru.praktikum_services.qa_scooter.po.OrderIsNotExistPage;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RedirectionTests {
    MainPage mainPage;
    OrderWizard_ForWhomScooterPage forWhomScooterPage;
    OrderWizard_AboutRentPage aboutRentPage;
    OrderIsNotExistPage trackOrderPage;


    @BeforeEach
    public void beforeTestActions()
    {
        Configuration.startMaximized=true;
        mainPage =open(MainPage.URL, MainPage.class);
        mainPage.clickCloseCookieBannerButton();
    }

    @Test
    public void redirectFromMainPageToYandexMainPageSuccess()
    {
        String actualUrl = mainPage.clickRedirectToYandexPageLink();
        String expectedUrl = "https://yandex.ru/";
        assertEquals(expectedUrl, actualUrl);


    }

    @Test
    public void redirectFromForWhomScooterPageToMainPageSuccess()
    {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        String actualUrl = forWhomScooterPage.clickRedirectToMainPageLink();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        assertEquals(expectedUrl, actualUrl);


    }

    @Test
    public void redirectFromAboutRentPageToMainPageSuccess()
    {
        forWhomScooterPage = mainPage.clickMakeOrderButtonInHeader();
        aboutRentPage = forWhomScooterPage.setNameFieldValue("Саша").
                setSurnameFieldValue("Иванов").
                setAddressFieldValue("Далеко далеко").
                setMetroStationFieldValue("Черкизовская").
                setTelephoneFieldValue("892092013264").
                clickNextButton();
        String actualUrl = aboutRentPage.clickRedirectToMainPageLink();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        assertEquals(expectedUrl, actualUrl);


    }
    @Test
    public void redirectFromTrackOrderPageToMainPageSuccess()
    {
        trackOrderPage = mainPage.checkOrderStatus("55564");
        String actualUrl = trackOrderPage.clickRedirectToMainPageLink();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        assertEquals(expectedUrl, actualUrl);


    }

    @AfterEach

    public  void afterTestActions() {
        closeWebDriver();
    }



}

