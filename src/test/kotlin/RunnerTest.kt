import Actions.UserProfile
import Auth.Auth
import CVD.CVD
import CVD.check.Driver
import Registration.NormalReg
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class RunnerTest {
    private lateinit var driver: ChromeDriver

    private val webLink: String = "https://rwminvest-dev.tecman.ru/login"
    private val adminLink: String = "https://rwminvest-dev.tecman.ru/adminLC/clients"


    @Before


    fun singUp() {
        CVD("C:\\webDriver\\chrome\\", "C:\\Program Files (x86)\\Google\\Chrome\\Application").check()
        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\webDriver\\chrome\\" + Driver().getLocalDriverSet("C:\\webDriver\\chrome\\")
                .last() + "\\chromedriver.exe"
        )
        driver = ChromeDriver()
        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()

    }

        @Test
// Тест авторизации
    fun auth() {
        Auth().standard(
            driver,
            webLink,
            "autotest@dontuse.com",
            "qwerty123"
        ) // Когда логин почта
        var exm: WebElement =
            driver.findElement(By.xpath("//div[@class='left-side-bar__user-information-body-content__info']/span[@class='left-side-bar__user-information-body-content__info-name']"))
        if (exm.text.contains("ДляАвтотестов НеТрогать")) {
            println("Тест успешно пройден. Авторизация по почте")
        } else {
            Assert.fail("Тест не пройден. ФИО Пользователя не найдено1!")
        }

        UserProfile().signOut(driver) // Нажатие по кнопке разлогина в профиле пользователя

        Auth().standard(
            driver,
            webLink,
            "+78999999999",
            "qwerty123"
        ) // Когда логин номер телефона
        exm =
            driver.findElement(By.xpath("//div[@class='left-side-bar__user-information-body-content__info']/span[@class='left-side-bar__user-information-body-content__info-name']"))
        if (exm.text.contains("ДляАвтотестов НеТрогать")) {
            println("Тест успешно пройден. Авторизация по номеру телефона")

        } else {
            Assert.fail("Тест не пройден. ФИО Пользователя не найдено!")
        }
    }


    @Test
    fun reg() {
        NormalReg().run(webLink, adminLink, driver)

    }


    @After
    fun shutDown() {
        driver.quit()

    }
}