package EditUserCard

import Auth.Auth
import Auth.SmsCode
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class BankAccount {
    fun add(driver: ChromeDriver) {
        println("Нажимаем на Добавить реквизиты")
        var exm : WebElement = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/button[1]"))
        exm.click()
        Thread.sleep(2000)

        println("Вводим БИК банка")
        exm = driver.findElement(By.xpath("//body/div[@id='modals-container']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("042908612")

        println("Выбираем БИК в выпадающем списке")
        exm = driver.findElement(By.xpath("//p[contains(text(),'042908612')]"))
        exm.click()

        println("Вводим номер счета")
        exm = driver.findElement(By.xpath("//body/div[@id='modals-container']/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("40817810177035258806")

        println("Вводим наименование счета")
        exm = driver.findElement(By.xpath("//body/div[@id='modals-container']/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("Тестовый счет")

        println("Нажимаем сохранить")
        exm = driver.findElement(By.xpath("//body/div[@id='modals-container']/div[1]/div[2]/div[1]/button[1]"))
        exm.click()

        println("Вводим смс код")
        exm = driver.findElement(By.xpath("//body/div[@id='modals-container']/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys(SmsCode().get("79999999999"))
        Thread.sleep(3000)

        println("Проверям добавленный счет")
        println("Проверям наименование счета")
        try {
            exm = driver.findElement(By.xpath("//p[contains(text(),'Тестовый счет')]"))
            println("Наименование счета указано верно")
        } catch (e: NoSuchElementException) {
            Assert.fail("Наименование счета не найдено")
        }

    }
}