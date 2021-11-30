package ru.praktikum_services.qa_scooter.po;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String[] EXPECTED_ANSWERS_TEXT = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    public String expectedAnswer(int index) {
        return EXPECTED_ANSWERS_TEXT[index];
    }
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //локаторы используемые в тестах
    //локатор кнопки cookie
    @FindBy(how = How.ID, using = "rcc-confirm-button")
    private static SelenideElement closeCookieBannerButton;
    //локатор кнопки заказа в header стринцы
    @FindBy(how = How.XPATH, using = ".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']")
    private static SelenideElement makeOrderHeaderButton;
    //локатор кнопки статус заказа
    @FindBy(how = How.XPATH, using = ".//div[@class='Header_Nav__AGCXC']/button[text()='Статус заказа']")
    private static SelenideElement checkOrderStatusButton;
    //локатор кнопки go
    @FindBy(how = How.XPATH, using = ".//div[@class='Header_SearchInput__3YRIQ']/button")
    private static SelenideElement goButton;
    //локатор текстбокса введите номер заказа
    @FindBy(how = How.XPATH, using = ".//div[@class='Header_SearchInput__3YRIQ']/div/input")
    private static SelenideElement enterOrderNumberInput;
    //локатор локатор кнопки редиректа на страницу Яндекс
    @FindBy(how = How.CSS, using = "a[href='//yandex.ru']")
    private static SelenideElement redirectToYandexLink;
    //локатор кнопки заказа в теле страницы
    @FindBy(how = How.XPATH, using = ".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']")
    private static SelenideElement makeOrderPageButton;
    //локатор списка вопросов
    @FindBy(how = How.CSS, using = "div.accordion__button")
    private ElementsCollection questionListItems;
    //локатор списка выпадающих ответов
    @FindBy(how = How.CSS, using = "div.accordion__panel")
    private ElementsCollection answersListItems;


    //остальные локаторы (не используятся в тестах но сделаны в соотв. с заданием
    //Сылка Самокат
    @FindBy(how = How.CSS, using = "a.Header_LogoScooter__3lsAR")
    private SelenideElement mainPageLink;
    //Лэйбл учебный тренажёр
    @FindBy(how = How.CSS, using = "div.Header_Disclaimer__3VEni")
    private SelenideElement studyPlaceLabel;
    //Главный текст страницы (Самокат на пару дней)
    @FindBy(how = How.CSS, using = "div.Home_Header__iJKdX")
    private SelenideElement mainPageHeader;
    //Главный текст страницы (под заголовокм Самокат на пару дней)
    @FindBy(how = How.XPATH, using = "(.//div[@class = 'Home_Header__iJKdX']/div)[1]")
    private SelenideElement subPageHeader1;
    @FindBy(how = How.XPATH, using = ".//div[@class = 'Home_Header__iJKdX']/div[last()]")
    private SelenideElement subPageHeader2;
    //Картинка со скрутером
    @FindBy(how = How.CSS, using = "div.Home_Scooter__3YdJy")
    private SelenideElement scooterImage;
    //Модель скрутера
    @FindBy(how = How.XPATH, using = ".//div[@class ='Home_Table__2kPxP']/div/div[contains(text(),'Модель')]")
    private SelenideElement scooterModel;
    //Лэйбл Максимальная скорость
    @FindBy(how = How.XPATH, using = ".//div[text()='Максимальная скорость']")
    private SelenideElement  scooterMaxSpeedLabel;
    //Значение Максимальной скорости
    @FindBy(how = How.XPATH, using = ".//div[text()='Максимальная скорость']/following-sibling::div")
    private SelenideElement  scooterMaxSpeedValue;
    //Лэйбл Максимальный путь без зарядки
    @FindBy(how = How.XPATH, using = ".//div[text()='Проедет без поздарядки']")
    private SelenideElement scooterMaxWayWithoutChargeLabel;
    //Значение Максимальный путь без зарядки
    @FindBy(how = How.XPATH, using = ".//div[text()='Проедет без поздарядки']/following-sibling::div")
    private SelenideElement  scooterMaxWayWithoutChargeValue;
    //Лэйбл Максимальный вес
    @FindBy(how = How.XPATH, using = ".//div[text()='Выдерживает вес']")
    private SelenideElement scooterMaxWeightLabel;
    //Значение Максимальный вес
    @FindBy(how = How.XPATH, using = ".//div[text()='Выдерживает вес']/following-sibling::div")
    private SelenideElement scooterMaxWeightValue;
    //карта процедуры заказа
    @FindBy(how = How.CSS, using = "div.Home_RoadMap__2tal_")
    private SelenideElement orderProcedureRoadMap;
    //Элементы карты заказа
    @FindBy(how = How.CSS, using = "div.Home_StatusBrick__1PsW9")
    private ElementsCollection orderProcedureRoadMapItems;
    //лэйбл вопросы о важном
    @FindBy(how = How.XPATH, using = "//div[text()='Вопросы о важном']")
    private SelenideElement importantQuestionsLabel;


    public OrderWizard_ForWhomScooterPage clickMakeOrderButtonInHeader() {
        makeOrderHeaderButton.click();
        return page(OrderWizard_ForWhomScooterPage.class);
    }

    public OrderWizard_ForWhomScooterPage clickMakeOrderButtonOnPage() {
        makeOrderPageButton.scrollTo().click();
        return page(OrderWizard_ForWhomScooterPage.class);
    }

    public void clickCloseCookieBannerButton() {
        if (closeCookieBannerButton.isDisplayed()) {
            closeCookieBannerButton.scrollTo().click();

        }
    }

    public int getQuestionListItemsLength() {

        return questionListItems.size();
    }

    public void questionListItemExpand(int index) {
        questionListItems.get(index).scrollTo().click();

    }

    public boolean isQuestionListItemExpanded(int index) {

        SelenideElement questionItem = questionListItems.get(index);
        SelenideElement answerItem = answersListItems.get(index);
        return questionItem.is(Condition.attribute("aria-expanded", "true")) && !answerItem.is(Condition.attribute("hidden"));

    }

    public boolean isAnswersTextCorrect(int index) {
        int compareResult = answersListItems.get(index).find(By.cssSelector("p")).innerText().compareTo(EXPECTED_ANSWERS_TEXT[index]);
        return compareResult != 0 ? false : true;

    }

    public OrderIsNotExistPage checkOrderStatus(String number) {
        checkOrderStatusButton.click();
        enterOrderNumberInput.setValue(number);
        goButton.click();
        return page(OrderIsNotExistPage.class);
    }

    public String clickRedirectToYandexPageLink() {
        redirectToYandexLink.click();
        String currentUrl = switchTo().window("Яндекс").getCurrentUrl();

        return currentUrl;
    }






}

