package Registration

import Actions.DellUser
import org.openqa.selenium.chrome.*
import Auth.Auth
import Auth.SmsCode
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import java.io.File
import java.util.concurrent.TimeUnit

class NormalReg {
    fun run(url: String, adminUrl: String, driver: ChromeDriver) {

        DellUser().dell(driver, "test@test.test", false) // Проверка и удаление пользователя


        // 1ый шаг регистрации
        println("1ый шаг регистрации")
        println("Открываем форму авторзации")
        driver.get(url)
        println("Нажимаем зарегистрироваться")
        var exm: WebElement = driver.findElement(By.xpath("//span[contains(text(),'Зарегистрироваться')]"))
        exm.click()

        println("Выбираем пункт По паспортным данным")
        exm = driver.findElement(By.xpath("//div[@class='reg-form-container']/div[2]/button[@type='button']")) // По паспортным данным
        exm.click()

        println("Вводим фамилию")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__fio']/div[1]/div[1]/div[1]/div[1]/input[1]")) // Фамилия
        exm.click()
        exm.sendKeys("Тестовый")

        println("Вводим Имя")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__fio']/div[2]/div[1]/div[1]/div[1]/input[1]")) // Имя
        exm.click()
        exm.sendKeys("Тест")

        println("Вводим отчество")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__fio']/div[3]/div[1]/div[1]/div[1]/input[1]")) // Отчество
        exm.click()
        exm.sendKeys("Тестович")

        println("Вводим номер телефона")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[1]/div[1]/div[1]/div[1]/input[1]")) // Номер телефона без +7
        exm.click()
        exm.sendKeys("9999999999")

        println("Вводим почту")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[2]/div[1]/div[1]/div[1]/input[1]")) // Почта
        exm.click()
        exm.sendKeys("test@test.test")

        println("Вводим дату рождения")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[3]/div[1]/div[1]/div[1]/input[1]")) // Дата рождения
        exm.click()
        exm.sendKeys("01011901")

        println("Вводим место рождения")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[4]/div[1]/div[1]/div[1]/input[1]")) // Место рождения
        exm.click()
        exm.sendKeys("Баговск")

        println("Вводим адрес регистрации")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[5]/div[1]/div[1]/div[1]/input[1]")) // Адрес регистрации
        exm.click()
        exm.sendKeys("Москва")
        exm = driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[5]/div[1]/div[2]/p[1]"))
        exm.click()

        println("Вводим адрес проживания")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[7]/div[1]/div[1]/div[1]/input[1]")) // Адрес проживания
        exm.click()
        exm.sendKeys("Москва")
        Thread.sleep(1000)
        exm.sendKeys(" ")
        exm = driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[7]/div[1]/div[2]/p[2]"))
        exm.click()

        println("Вводим ИНН")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__data']/div[8]/div[1]/div[1]/div[1]/input[1]")) // ИНН
        exm.click()
        exm.sendKeys("000000000000")

        println("Выбираем чек бокс 1")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__checkbox-group']/div[2]/label[1]/span[2]")) // чек бокс 1
        exm.click()

        println("Выбираем чек бокс 2")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__checkbox-group']/div[3]/label[1]/span[2]")) // чек бокс 2
        exm.click()

        println("Выбираем чек бокс 3")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__checkbox-group']/div[4]/label[1]/span[2]")) // чек бокс 3
        exm.click()

        println("Выбираем чек бокс 4")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__checkbox-group']/div[5]/label[1]/span[2]")) // чек бокс 4
        exm.click()

        println("Выбираем чек бокс 5")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__checkbox-group']/div[6]/label[1]/span[2]")) // чек бокс 5
        exm.click()

        println("Вводим пароль")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__password-section']/div[1]/div[1]/div[1]/div[1]/input[1]")) // Пароль
        exm.click()
        exm.sendKeys("QWerty123!")

        println("Вводим подтверждение пароля")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__password-section']/div[3]/div[1]/div[1]/div[1]/input[1]")) // Повторили Пароль
        exm.click()
        exm.sendKeys("QWerty123!")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__password-section']/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()

        println("Нажимаем подписать")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__password-section']/div[5]/button[1]")) // Подписать
        exm.click()

        println("Вводим смс код")
        exm =
            driver.findElement(By.xpath("//div[@class='form-container__form__password-section']/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")) // смс код
        exm.click()
        exm.sendKeys(SmsCode().get("79999999999"))
        Thread.sleep(5000)

        // Проверяем в админке, что пользователь появился в списке и имеет статус 1.

        println("Заходим в админку")
        driver.get("https://rwminvest-dev.tecman.ru/adminLC/clients")
        Thread.sleep(2000)

        println("Ищем созданного пользователя")
        exm = driver.findElement(By.xpath("//input[@name='vgt-email']"))
        exm.sendKeys("test@test.test")
        Thread.sleep(1000)

        try {
            exm = driver.findElement(By.xpath("//span[contains(text(),'test@test.test')]"))
            println("Новый пользователь найден в админке ${exm.text}")
        } catch (e: NoSuchElementException) {
            Assert.fail("Пользователь не найден")
        }
        val userID: String = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/span[1]")).text.replace(
            " ",
            ""
        ) // ID пользователя, нужно для ссылки подтверждения админом

        if (driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).text != "Активный 1") { // Чекаем, что статус Активный 1
            Assert.fail(
                "Не верный статус пользователя, должен быть \"Активный 1\"\nСейчас " + driver.findElement(
                    By.xpath(
                        "//tbody/tr[1]/td[6]/span[1]"
                    )
                ).text
            )
        } else {
            println("Статус верный 1")
        }
        Thread.sleep(1000)
        println("Переходим по ссылке на 2ой шаг регистрации")
        // Второй шаг регистрации
        driver.get("http://rwminvest-dev.tecman.ru/client/v1/user/confirm-email?token=" + RegToken().get("test@test.test")) // Переходим по ссылке на 2ой шаг

        println("Жмем продолжить")
        exm = driver.findElement(By.xpath("//button[@type='button']")) // Кнопка продолжить

        Thread.sleep(5000)

        println("Вводим серию и номер паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("1111111111") // Серия и номер паспорта

        println("Загружаем скан паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[9]/div[1]/div[2]/div[1]/div[1]/input[1]"))
        exm.sendKeys(File("pasport.pdf").absolutePath) // Прикрепили скан паспорта

        println("Указываем код подразделения")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("102507") // Код подразделения

        println("Указываем кем выдан паспорт")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("УФМС ПО г. МОСКВЕ") // Кем выдан паспорт

        println("Указываем дату выдачи")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[12]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("10102006") // Дата выдачи паспорта

        println("Вводим снилс")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[14]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("00000000000") // Снилс

        println("Загружаем скан снилса")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[14]/div[2]/div[1]/div[1]/input[1]"))
        exm.sendKeys(File("snils.pdf").absolutePath) // Прикрепили скан снилса

        println("Нажимаме подписать")
        exm = driver.findElement(By.xpath("//div[@class='col-3']/button[1]"))
        exm.click() // Нажали подписать

        println("Вводим код из смс")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[15]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        Thread.sleep(2000)
        exm.sendKeys(SmsCode().get("79999999999")) // Код из смс
        Thread.sleep(5000)


        //  В админку, проверять статус, должен быть Активный 2
        println("Проверяем статус в админке 2")
        driver.get("https://rwminvest-dev.tecman.ru/adminLC/clients")
        Thread.sleep(2000)

        println("Вводим в поиск почту")
        exm = driver.findElement(By.xpath("//input[@name='vgt-email']"))
        exm.sendKeys("test@test.test")
        Thread.sleep(1000)

        try {
            exm = driver.findElement(By.xpath("//span[contains(text(),'test@test.test')]"))
            println("Новый пользователь найден в админке ${exm.text}")
        } catch (e: NoSuchElementException) {
            Assert.fail("Пользователь не найден")
        }

        if (driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).text != "Активный 2") { // Чекаем, что статус Активный 2
            Assert.fail(
                "Не верный статус пользователя, должен быть \"Активный 2\"\nСейчас " + driver.findElement(
                    By.xpath(
                        "//tbody/tr[1]/td[6]/span[1]"
                    )
                ).text
            )
        } else {
            println("Статус верный 2")
        }

        println("Открываем карточку пользователя для подтверждения")
        exm = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/span[1]/div[1]/*[1]")); // Открыли карточку пользователя
        exm.click()

        println("Ставим чек бокс Данные верны")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/label[1]/span[2]"));
        exm.click() // Чек-бокс Данные проверены

        println("Жмем сохранить")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/button[1]"))
        exm.click() // Кнопка сохранить
        Thread.sleep(4000)

        println("Проверям, что статус изменился")
        driver.get("https://rwminvest-dev.tecman.ru/adminLC/clients")
        Thread.sleep(2000)

        println("Вводим в админке почту пользователя в поиск")
        exm = driver.findElement(By.xpath("//input[@name='vgt-email']"))
        exm.sendKeys("test@test.test")
        Thread.sleep(1000)

        try {
            exm = driver.findElement(By.xpath("//span[contains(text(),'test@test.test')]"))
            println("Новый пользователь найден в админке ${exm.text}")
        } catch (e: NoSuchElementException) {
            Assert.fail("Пользователь не найден")
        }

        if (driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).text != "Активный 3") { // Чекаем, что статус Активный 3
            Assert.fail(
                "Не верный статус пользователя, должен быть \"Активный 3\"\nСейчас " + driver.findElement(
                    By.xpath(
                        "//tbody/tr[1]/td[6]/span[1]"
                    )
                ).text
            )
        } else {
            println("Статус верный 3")
        }
        Thread.sleep(1000)



        println("Удаляем тестового пользователя")
        DellUser().dell(driver, "test@test.test", true) // Проверка и удаление пользователя





        println("Тест окончен!")




        Thread.sleep(5000)
    }
}