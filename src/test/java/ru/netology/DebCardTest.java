package ru.netology;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebCardTest {

    private WebDriver driver;

    @BeforeAll

    static void setupAll() {

        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");

    }

    @BeforeEach
    public void setup() { driver = new ChromeDriver();

    }


    @AfterEach
    //Закрываем все окна браузера.
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void test() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Иван Иванов Иванович");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("+79997777777");

        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.tagName("button")).click();

        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());

    }
}