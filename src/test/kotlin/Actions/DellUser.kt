package Actions

import Auth.Auth
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class DellUser {
    fun dell(driver: ChromeDriver, userMail: String, flag: Boolean) {

        if (!flag) { // Если удалить пользователя нужно перед тестом
            Auth().adminAuth(driver, "https://rwminvest-dev.tecman.ru/adminLC")
            Thread.sleep(2000)
        }

        driver.get("https://rwminvest-dev.tecman.ru/adminLC/clients") // Чекаем что пользователь удалился
        Thread.sleep(2000)


        var exm = driver.findElement(By.xpath("//input[@name='vgt-email']"))
        exm.sendKeys(userMail)
        Thread.sleep(1000)

        if (flag) {
            println("Удаляем пользователя")
            println("Блокируем пользоватешя")
            exm = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/span[1]/div[1]/*[3]"))
            exm.click()
            Thread.sleep(1000)

            println("Удаляем пользователя")
            exm = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/span[1]/div[1]/*[4]"))
            exm.click() // нажимаем удалить

            exm = driver.findElement(By.xpath("//body/div[@id='app']/div[3]/div[1]/div[1]/div[1]/button[1]"))
            exm.click() // Подтверждаем удаление
            Thread.sleep(2000)

            try {
                driver.manage()?.timeouts()?.implicitlyWait(3, TimeUnit.SECONDS)
                exm = driver.findElement(By.xpath("//span[contains(text(),'$userMail')]"))
                println("Обнаружен пользователь ${exm.text}")
                Assert.fail("Пользователь не удалился")

            } catch (e: NoSuchElementException) {
                println("Пользователь не обнаружен")
            }
        } else {
            try {
                driver.manage()?.timeouts()?.implicitlyWait(3, TimeUnit.SECONDS)
                exm = driver.findElement(By.xpath("//span[contains(text(),'$userMail')]"))
                println("Обнаружен пользователь ${exm.text}")

                println("Блокируем пользоватешя")
                exm = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/span[1]/div[1]/*[3]"))
                exm.click()
                Thread.sleep(1000)

                println("Удаляем пользователя")
                exm = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/span[1]/div[1]/*[4]"))
                exm.click() // нажимаем удалить

                exm = driver.findElement(By.xpath("//body/div[@id='app']/div[3]/div[1]/div[1]/div[1]/button[1]"))
                exm.click() // Подтверждаем удаление
                Thread.sleep(2000)

                driver.get("https://rwminvest-dev.tecman.ru/adminLC/clients") // Чекаем что пользователь удалился
                Thread.sleep(2000)


                exm = driver.findElement(By.xpath("//input[@name='vgt-email']"))
                exm.sendKeys(userMail)
                Thread.sleep(1000)

            } catch (e: NoSuchElementException) {
                println("Пользователь не обнаружен")
            }
        }





        driver.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
    }
}