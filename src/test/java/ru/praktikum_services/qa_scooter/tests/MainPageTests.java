package ru.praktikum_services.qa_scooter.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.praktikum_services.qa_scooter.po.MainPage;
import ru.praktikum_services.qa_scooter.po.OrderIsNotExistPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainPageTests {

    MainPage mainPage;
    OrderIsNotExistPage orderIsNotExistPage;

    @BeforeEach
    public void beforeTestActions()
    {
        Configuration.startMaximized=true;
        mainPage =open(MainPage.URL, MainPage.class);
        mainPage.clickCloseCookieBannerButton();
    }

   @Test
   public void questionListItemsExpandedAndAnswersAreCorrect()
    {
        for (int i = 0; i < mainPage.getQuestionListItemsLength(); i++) {
            mainPage.questionListItemExpand(i);
            assertTrue(mainPage.isQuestionListItemExpanded(i));
            assertEquals("Неверный текст в элементе выпадающего списка № " + i+ ". Ожидаемый результат: " + mainPage.expectedAnswer(i), mainPage.isAnswersTextCorrect(i));
        }
    }


    @Test
    public void orderStatusPageIsCorrectForNonExistedOrder()
    {
      orderIsNotExistPage = mainPage.checkOrderStatus("3535353");
      assertTrue(orderIsNotExistPage.isOrderNotFoundMessageExist());
    }

    @AfterEach

        public  void afterTestActions() {
        closeWebDriver();
    }



}




