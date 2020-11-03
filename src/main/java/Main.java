import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    static WebDriver driver;

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\marti\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/");
        clickCell(1);
        clickSelect("player1-icon", "tessa_b");
        clickCell(9);
        clickCell(7);
        //driver.findElement(By.id("cell-0")).click();
        //driver.get("https://tessa.haw-hamburg.de");
        //driver.close();

    }

    public static void clickCell(int cell) {
        if ((cell >= 0) && (cell <= 19)) {
            driver.findElement(By.id("cell-" + cell)).click();
        }
    }

    public static void clickSelect(String select, String value) {
        WebElement selectPlayer = driver.findElement(By.id(select));
        selectPlayer.sendKeys(value);
    }

}
