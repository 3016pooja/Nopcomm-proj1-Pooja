package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utiltiy;

public class TestSuite extends Utiltiy {
    String baseurl = "https://demo.nopcommerce.com/build-your-own-computer";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // 1.1 click on computer menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2clikc on the Desktop
        clickOnElement(By.xpath("//h2[@class='title']//a"));

        //1.3 select sort by -Name Zto A ,dropdown method from z to a
        WebElement dropdown=driver.findElement(By.name("products-orderby"));
        Select select=new Select(dropdown);
        select.selectByValue("6");

        //1.4	Verify the Product will arrange in Descending orderge in Descending order
        System.out.println("The number of products on page are:" + driver.findElements(By.className("product-title")).size());

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 click on computer menu
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //2.2clikc on the Desktop
        clickOnElement(By.xpath("//h2[@class='title']//a"));
        //2.3 select sort by postion "Name A to Z"
        WebElement dropdown=driver.findElement(By.name("products-orderby"));
        Select select=new Select(dropdown);
        select.selectByValue("5");

        // 2.4	Click on "Add To Cart"
        try{
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        }catch (StaleElementReferenceException e){
            clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        }
        //2.5	Verify the Text "Build your own computer"
        verifyText("Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"));

        //  2.6	Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
       selectByVisibleTextFromDropDown(By.name("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");

     //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.name("product_attribute_2"),"8GB [+$60.00]");

       // 2.8	Select HDD radio "400 GB [+$100.00]"2.8	Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//label[@for='product_attribute_3_7']")).click();

        //2.9
        driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();
        //2.102.10	Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));

        // 2.11	Verify the price "$1,475.00"
verifyText("$1,475.00",By.xpath("//span[text()='$1,475.00']"));

      //add to cart
          clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

       //  2.13	Verify the Message "The product has been added to your shopping cart" on Top green Bar
   verifyText("The product has been added to your shopping cart",By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

      //  2.14	Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
      Thread.sleep(2000);
        WebElement shoppingCart=driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart=driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        Actions actions1=new Actions(driver);
        actions1.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();


        //2.15 verify the message'Shopping cart'.
        verifyText("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));

    //2.16	Change the Qty to "2" and Click on "Update shopping cart"
      Actions actions2=new Actions(driver);
      WebElement quntity=driver.findElement(By.xpath("//input[@value='1']"));
      quntity.clear();
      sendTextToElement(By.xpath("//input[@value='1']"),"2");
      clickOnElement(By.xpath("//button[@id='updatecart']"));
        //2.17	Verify the Total"$2,950.00"
        verifyText("$2,950.00",By.xpath("//tbody/tr[4]/td[2]"));

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20	Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //2.21 checkout as guest
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22	Fill the all mandatory field
        sendTextToElement(By.name("BillingNewAddress.FirstName"),"Pooja");
        sendTextToElement(By.name("BillingNewAddress.LastName"),"patel");
        sendTextToElement(By.id("BillingNewAddress_Email"),"queenmaradiya@gmail.com");
        sendTextToElement(By.name("BillingNewAddress.CountryId"),"India");
       sendTextToElement(By.name("BillingNewAddress.City"),"Vadodara");
       sendTextToElement(By.name("BillingNewAddress.Address1"),"Radstock avanue");
       sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"Ha38Pe");
       sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"024697233");

       //2.23 click on continue
       clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.24	Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'Next Day Air ($0.00)')]"));

        //2.25click on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //2.26 select the radio button credit cart
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.27 select master card From Select credit card dropdown
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        clickOnElement(By.xpath("//option[contains(text(),'Master card')]"));


        //2.28	Fill all the details
        sendTextToElement(By.name("CardholderName"),"Puja");
        sendTextToElement(By.id("CardNumber"),"0245 0245 0654 0587");
        sendTextToElement(By.id("ExpireMonth"),"08");
        sendTextToElement(By.id("ExpireYear"),"2024");
        sendTextToElement(By.id("CardCode"),"0235");

       // 2.29	Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Payment Method: Credit Card",By.xpath("//li[@class='payment-method']"));

        //2.32	Verify “Shipping Method” is “Next Day Air”
        verifyText("Shipping Method: Next Day Air",By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]"));

        //2.33	Verify Total is “$2,950.00”
        verifyText("$2,950.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));

        //2.34	Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.35	Verify the Text “Thank You”
        verifyText("Thank you",By.xpath("//h1[contains(text(),'Thank you')]"));
        //2.36	Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!",By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.37	Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.37 Verify the text “Welcome to our store”
        verifyText("Welcome to our store",By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }

@After
    public void tearDown(){
        //closeBrowser();
}
//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]
    }

