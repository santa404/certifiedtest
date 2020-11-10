import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainTest extends TestCase {
    Main test = new Main();

    public void pre_test(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Pascal\\OneDrive for Business\\Uni\\1. Semester\\08. Wintersemester 2020_2021\\3. Certified Tester\\3. Praktikum _ Labor\\99. Workspace\\chromedriver.exe");
        test.driver = new ChromeDriver();
        test.driver.get("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/");
    }

    public void testCase1() {
        pre_test();
        try {
            boolean zeichen = false;
            Thread.sleep(1000);
            /* Player 1 x setzen */
            test.clickCell(19);
            WebElement img_19 = test.driver.findElement(By.id("cell-19"));
            img_19 = img_19.findElement(By.tagName("img"));
            String img_inside_19 = img_19.getAttribute("src");
            if ("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/x.png".equals(img_inside_19)) {
                zeichen = true;
            } else if ("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/o.png".equals(img_inside_19)) {
                zeichen = true;
            } else if ("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/o_green.png".equals(img_inside_19)) {
                zeichen = true;
            } else if ("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/tessa_b.png".equals(img_inside_19)) {
                zeichen = true;
            } else if ("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/tessa_r.png".equals(img_inside_19)) {
                zeichen = true;
            } else {
                zeichen = false;
            }
            Assert.assertTrue(zeichen);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.driver.close();
    }

    public void testCase2() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickCell(6);
            test.clickCell(0);
            test.clickCell(11);
            test.clickCell(19);
            test.clickCell(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon1 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertFalse(whoWon1.contains("player1 won the match!"));

        String whoWon2 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertFalse(whoWon2.contains("player2 won the match!"));
        test.driver.close();
    }

    public void testCase3_1() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickCell(9);
            test.clickCell(6);
            test.clickCell(14);
            test.clickCell(3);
            test.clickCell(19);
            test.clickCell(11);
            test.clickCell(18);
            test.clickCell(13);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon1 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertFalse(whoWon1.contains("player1 won the match!"));

        String firstWin = test.driver.findElement(By.id("score-1")).getText();
        Assert.assertTrue(firstWin.contains("1"));

        test.clickCell(0);
        test.clickCell(15);
        test.clickCell(1);
        test.clickCell(16);
        test.clickCell(2);

        String whoWon2 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertFalse(whoWon2.contains("player1 won the match!"));

        String secondWin = test.driver.findElement(By.id("score-1")).getText();
        Assert.assertTrue(secondWin.contains("2"));
        test.driver.close();
    }

    public void testCase3_2() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickCell(0);
            test.clickCell(5);
            test.clickCell(19);
            test.clickCell(6);
            test.clickCell(15);
            test.clickCell(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon1 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertFalse(whoWon1.contains("player2 won the match!"));

        String firstWin = test.driver.findElement(By.id("score-2")).getText();
        Assert.assertTrue(firstWin.contains("1"));

        test.clickCell(0);
        test.clickCell(5);
        test.clickCell(19);
        test.clickCell(6);
        test.clickCell(15);
        test.clickCell(7);

        String whoWon2 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertFalse(whoWon2.contains("player2 won the match!"));

        String secondWin = test.driver.findElement(By.id("score-2")).getText();
        Assert.assertTrue(secondWin.contains("2"));
        test.driver.close();
    }

    public void testCase4_i() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickCell(10);
            test.clickCell(9);
            test.clickCell(5);
            test.clickCell(4);
            test.clickCell(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon1 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertTrue(whoWon1.contains("player1 won the match!"));
        test.driver.close();
    }

    public void testCase4_Ausrufezeichen() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickCell(0);
            test.clickCell(9);
            test.clickCell(5);
            test.clickCell(4);
            test.clickCell(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon1 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertTrue(whoWon1.contains("player1 won the match!"));
        test.driver.close();
    }

    public void testCase5() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickSelect("player1-icon", "tessa_r");
            test.clickSelect("player2-icon", "x");
            test.clickCell(0);
            test.clickCell(19);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement img_0 = test.driver.findElement(By.id("cell-0"));
        img_0 = img_0.findElement(By.tagName("img"));
        String img_inside_0 = img_0.getAttribute("src");
        Assert.assertTrue(img_inside_0.contains("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/tessa_r.png"));

        WebElement img_19 = test.driver.findElement(By.id("cell-19"));
        img_19 = img_19.findElement(By.tagName("img"));
        String img_inside_19 = img_19.getAttribute("src");
        Assert.assertTrue(img_inside_19.contains("https://ct.informatik.haw-hamburg.de/tessa_tac_toe/icons/x.png"));
        test.driver.close();
    }

    public void testCase6() {
        pre_test();
        boolean case6 = false;
        try {
            Thread.sleep(1000);
            for (int i = 0; i < 50; i++){
                test.clickCell(19);
            }
            WebElement img_0 = test.driver.findElement(By.id("cell-0"));
            img_0 = img_0.findElement(By.tagName("img"));
        } catch (org.openqa.selenium.NoSuchElementException x) {
            case6 = true;
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        Assert.assertTrue(case6);
        test.driver.close();
    }

    public void testCase7() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickCell(0);
            test.clickCell(19);
            test.clickCell(2);
            test.clickCell(18);
            test.clickCell(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon1 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertTrue(whoWon1.contains("player1 won the match!"));
        test.driver.close();
    }

    public void testCase9() {
        pre_test();
        try {
            /* Player 2 tessa_b setzen */
            Thread.sleep(1000);
            test.clickCell(15);
            test.clickCell(0);
            test.clickCell(11);
            test.clickCell(1);
            test.clickCell(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String whoWon1 = test.driver.findElement(By.id("playerwon")).getText();
        Assert.assertTrue(whoWon1.contains("player1 won the match!"));
        test.driver.close();
    }
}