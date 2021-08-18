package Auth

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class Auth {
    fun standard(driver: ChromeDriver, url: String, login: String, pass: String) {
        driver.get(url)
        var exm: WebElement =
            driver.findElement(By.xpath("//div[@class='rwm-text-field login']/div[1]/div[1]/input[1]"))
        exm.click()
        exm.sendKeys(login)

        exm = driver.findElement(By.xpath("//input[@type='password']"))
        exm.click()
        exm.sendKeys(pass)

        exm = driver.findElement(By.xpath("//button[@type='submit']"))
        exm.click()

        exm = driver.findElement(By.xpath("//div[@class='sms-login__body-code']/div[1]/div[1]/div[1]/input[1]"))
        exm.click()
        exm.sendKeys(SmsCode().get("78999999999"))


    }

    fun adminAuth(driver: ChromeDriver, adminUrl: String) {  // Авторизацию в админку
        driver.get(adminUrl)

        var exm: WebElement =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("administrator@example.com")

        exm =
            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
        exm.sendKeys("administrator@example.com")

        exm = driver.findElement(By.xpath("//button[@type='submit']"))
        exm.click()
    }
}