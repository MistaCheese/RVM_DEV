package Actions

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class UserProfile {
    fun signOut(driver: ChromeDriver) {
        println("Поиск кнопки \"Выйти из личного кабинета\"")
        val exm: WebElement = driver.findElement(By.xpath("//div[@class='icons-group']/i[3]"))
        exm.click()
        println("Нажимаю на кнопку \"Выйти из личного кабинета\"")
    }
}