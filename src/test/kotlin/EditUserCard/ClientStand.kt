package EditUserCard

import Auth.SmsCode
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import java.io.File

class ClientStand {

    fun edit(driver: ChromeDriver) {

        println("Нажали на Редактировать")
        var exm: WebElement =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[8]/div[1]/button[1]"))
        exm.click()

        println("Нажали продолжить")
        exm = driver.findElement(By.xpath("//body/div[@id='modals-container']/div[1]/div[2]/div[1]/button[1]"))
        exm.click()

        println("Меняем фамилию")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("2")

        println("Меняем имя")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("2")

        println("Меняем отчество")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("2")

        println("Меняем дату рождения")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        val builder = Actions(driver)
        val backSpace = builder.sendKeys(Keys.BACK_SPACE).build()
        backSpace.perform()
        exm.sendKeys("2")

        println("Меняем место рождения")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("2")

        println("Меняем адрес регистрации")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys(" Ж")
        exm = driver.findElement(By.xpath("//p[contains(text(),'г Москва, ул Жуковского')]"))
        exm.click()

        println("Меняем адрес проживания")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[3]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        for (k in 0..50) {
            backSpace.perform()
        }
        exm.sendKeys("Ярославль ")
        exm = driver.findElement(By.xpath("//p[contains(text(),'Ярославская обл, г Ярославль')]"))
        exm.click()

        println("Меняем серию паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        backSpace.perform()
        exm.sendKeys("2")

        println("Меняем номер паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        backSpace.perform()
        exm.sendKeys("2")

        println("Меняем дату выдачи паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[3]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        backSpace.perform()
        exm.sendKeys("2")

        println("Меняем код подразделения")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[4]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        backSpace.perform()
        exm.sendKeys("2")

        println("Меняем скан паспорта")
        println("Удаляем старый скан")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[5]/div[1]/div[1]/div[2]/i[1]"))
        exm.click()
        try {
            exm = driver.findElement(By.xpath("//span[contains(text(),'Прикрепить скан паспорта')]"))
            println("Скан паспорта удалён")
        } catch (e: NoSuchElementException) {
            Assert.fail("Скан не удалился")
        }
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[5]/div[1]/div[1]/input[1]"))
        exm.sendKeys(File("pasport2.pdf").absolutePath)

//        println("Меняем скан снилса")
//        println("Удаляем старый скан")
//        exm =
//            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[7]/div[2]/div[1]/div[1]/div[2]/i[1]"))
//        exm.click()
//        try {
//            exm = driver.findElement(By.xpath("//span[contains(text(),'Прикрепить скан СНИЛС')]"))
//            println("Скан СНИЛС удалён")
//        } catch (e: NoSuchElementException) {
//            Assert.fail("Скан не удалился")
//        }
//        exm =
//            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[7]/div[2]/div[1]/div[1]/input[1]"))
//        exm.sendKeys(File("snils2.pdf").absolutePath)

        println("Меняем кем выдан паспорт")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[6]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("2")

        println("Меняем ИНН")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[6]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        for (k in 1..20) {
            backSpace.perform()
        }
        exm.sendKeys("7743880975")

        println("Меняем СНИЛС")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[7]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        for (k in 1..20) {
            backSpace.perform()
        }
        exm.sendKeys("08336732477")

        println("Нажимаем Сохранить")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[8]/div[1]/button[1]"))
        exm.click()
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[9]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys(SmsCode().get("79999999999"))
        Thread.sleep(4000)

        println("Проверям изменения")
        println("Проверям фамилию")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("Тестовый2")) {
            println("Фамилия изменилась верно")
        } else {
            Assert.fail("Фамилия не изменилась")
        }

        println("Проверям имя")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("Тест2")) {
            println("Имя изменилось верно")
        } else {
            Assert.fail("Имя не изменилось")
        }

        println("Проверям отчество")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("Тестович2")) {
            println("Отчество изменилось верно")
        } else {
            Assert.fail("Отчество не изменилось")
        }

        println("Проверям дату рождения")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("01.01.1902")) {
            println("Дата рождения изменилась верно")
        } else {
            Assert.fail("Дата рождения не изменилась")
        }

        println("Проверям место рождения")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("Баговск2")) {
            println("Город изменён верно")
        } else {
            Assert.fail("Город не изменён")
        }

//        println("Проверям место регистрации")
//        exm =
//            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]"))
//        if (exm.getAttribute("value").equals("101000, г Москва, ул Жуковского")) {
//            println("Место регистрации изменилось")
//        } else {
//            Assert.fail("Место регистрации не изменилось")
//        }

//        println("Проверям адрес проживания")
//        exm =
//            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[3]/div[1]/div[1]/div[1]/input[1]"))
//        if (exm.getAttribute("value").equals("150000, Ярославская обл, г Ярославль")) {
//            println("Адрес проживания указан верно")
//        } else {
//            Assert.fail("Адрес проживания не изменён")
//        }

        println("Проверям серию паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("1112")) {
            println("Серия паспорта указано верно")
        } else {
            Assert.fail("Серия паспорта не изменилась")
        }

        println("Првоерям номер паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("111112")) {
            println("Номер паспорта указан верно")
        } else {
            Assert.fail("Номер паспорта не изменился")
        }

        println("Проверям дату выдачи паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[3]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("10.10.2002")) {
            println("Дата выдачи указан верно")
        } else {
            Assert.fail("Дата выдачи не изменилась")
        }

        println("Проверям код подразделения")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[4]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("102-502")) {
            println("Код подразделения указан верно")
        } else {
            Assert.fail("Код подразделение не изменился")
        }

        println("Проверям файл со сканом паспорта")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[5]/div[1]/div[1]/div[1]/div[2]"))
        if (exm.getAttribute("outerText").equals("pasport2.pdf")) {
            println("Название скана верное")
        } else {
            Assert.fail("Название скана паспорта не верное")
        }

        println("Проверям кем выдан паспорт")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[6]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("УФМС ПО г. МОСКВЕ2")) {
            println("Кем выдан паспорт указано верно")
        } else {
            Assert.fail("Кем выдан паспорт указано не верно")
        }

        println("Проверяем ИНН")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[6]/div[2]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("7743880975")) {
            println("ИНН указан верно")
        } else {
            Assert.fail("ИНН указан не верно")
        }

        println("Проверям СНИЛС")
        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[7]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        if (exm.getAttribute("value").equals("08336732477")) {
            println("СНИЛС указан верно")
        } else {
            Assert.fail("СНИЛС указан не верно")
        }

//        println("Проверям имя файла СНИЛСа")
//        exm =
//            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[7]/div[2]/div[1]/div[1]/div[1]/div[2]"))
//        if (exm.getAttribute("value").equals("snils2.pdf")) {
//            println("Имя файл со снилсом указано верно")
//        } else {
//            Assert.fail("Имя файло со снилсом указано не верно")
//        }


        Thread.sleep(10000)
    }
}