import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    static WebDriver driver;
    static WebDriver dropdown;

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\Program\\Chrom_Selenium_Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/");
        testy_MC_test_test_test();

        //driver.get("https://tessa.haw-hamburg.de");
        //driver.close();

    }

    public static void clickCell(int cell) {
        if ((cell >= 0) && (cell <= 19)) {
            driver.findElement(By.id("cell-" + cell)).click();
        }
    }

    public static void clickSelect(String select, String value) {
        driver.findElement(By.id(select)).click();
        WebElement selectElement = driver.findElement(By.id(select));
        selectElement = selectElement.findElement(By.className("gwt-ListBox"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByValue(value);
    }

    public static void testy_MC_test_test_test(){
        try {
            Thread.sleep(1000);
            clickSelect("player1-icon", "tessa_b");
            clickCell(0);
            clickCell(7);
            clickCell(5);
            clickCell(14);
            clickCell(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon = driver.findElement(By.id("playerwon")).getText();
        Assert.assertTrue(!whoWon.contains("player1 won the match!"));

        String firstWin = driver.findElement(By.id("score-1")).getText();
        Assert.assertTrue(firstWin.contains("1"));

    }

}
