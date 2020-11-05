import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainTest extends TestCase {
    Main test = new Main();

    public void pre_test(){
        System.setProperty("webdriver.chrome.driver","D:\\Program\\Chrom_Selenium_Driver\\chromedriver.exe");
        test.driver = new ChromeDriver();
        test.driver.get("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/");
    }

    public void testClickCell() {
        pre_test();
        try {
            Thread.sleep(1000);
            /* Player 1 x setzen */
            test.clickCell(1);
            WebElement img_1 = test.driver.findElement(By.id("cell-1"));
            img_1 = img_1.findElement(By.tagName("img"));
            String img_inside_1 = img_1.getAttribute("src");
            Assert.assertTrue(img_inside_1.contains("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/x.png"));

            /* Player 2 o setzen */
            test.clickCell(2);
            WebElement img_2 = test.driver.findElement(By.id("cell-2"));
            img_2 = img_2.findElement(By.tagName("img"));
            String img_inside_2 = img_2.getAttribute("src");
            Assert.assertTrue(img_inside_2.contains("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/o.png"));

            /* Player 1 x setzen */
            test.clickCell(3);
            WebElement img_3 = test.driver.findElement(By.id("cell-3"));
            img_3 = img_3.findElement(By.tagName("img"));
            String img_inside_3 = img_3.getAttribute("src");
            Assert.assertTrue(img_inside_3.contains("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/x.png"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testClickSelect() {
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickSelect("player2-icon", "tessa_b");
            test.clickCell(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement img_7 = test.driver.findElement(By.id("cell-7"));
        img_7 = img_7.findElement(By.tagName("img"));
        String img_inside_7 = img_7.getAttribute("src");
        Assert.assertTrue(img_inside_7.contains("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/tessa_b.png"));
    }
}