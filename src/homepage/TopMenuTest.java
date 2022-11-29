package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utiltiy;

public class TopMenuTest extends Utiltiy {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void serUp() {
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu) {
        if (menu == "Computer") {
            clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a"));
            verifyText("Computers", By.xpath("//h1[contains(text(),'Computers')]"));

        } else if (menu == "Electronics") {
            clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
            verifyText("Electronics", By.xpath("//h1[contains(text(),'Electronics')]"));
        } else if (menu == "Apparel") {
            clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[3]/a"));
            verifyText("Apparel", By.xpath("//h1[contains(text(),'Apparel')]"));
        } else if (menu == "Digital downloads") {
            clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[4]/a"));
            verifyText("Digital downloads", By.xpath("//h1[contains(text(),'Digital downloads')]"));
        } else if (menu == "Books") {
            clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[5]/a"));
            verifyText("Books", By.xpath("//h1[contains(text(),'Books')]"));
        } else if (menu == "Jewelry") {
            clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[6]/a"));
            verifyText("Jewelry", By.xpath("//h1[contains(text(),'Jewelry')]"));
        } else if (menu == "Gift Cards") {
            clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[7]/a"));
            verifyText("Gift Cards", By.xpath("//h1[contains(text(),'Gift Cards')]"));
        }
    }
        //1.3use selectMenu method toselect the Menu and click on it and verify the page navigation
        @Test
        public void verifyPageNavigation(){
            selectMenu("Books");
        }

        @After
        public void testDown() {
            // closeBrowser();
        }
    }


