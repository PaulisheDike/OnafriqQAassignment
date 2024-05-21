package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LandingPage extends BaseTest {

    public static String label_loc = "//div[@class='features_items']//p[contains(text(),'')]";
    public static String price_loc = "//div[@class='features_items']//h2[contains(text(),'')]";
    public static String featured_items_loc = "//div[@class='overlay-content']";
    //div[@class='features_items']
    //
    //div[@class='overlay-content']//h2[contains(text(),'Rs.')]
    //div[@class='overlay-content']//p[contains(text(),'')]

    public static String women_loc = "//a[normalize-space()='Women']";
    public static String tops_loc = "//a[normalize-space()='Tops']";
//    public static String view_fancy_green_top_loc = "(//a[contains(text(),'View Product')])[5]";
//    public static String view_summer_white_top_loc = "(//a[contains(text(),'View Product')])[3]";
    public static String add_to_cart_btn = "//button[@type='button']";
    public static String view_cart_loc = "//u[normalize-space()='View Cart']";
    public static String continue_shopping = "//button[@class='btn btn-success close-modal btn-block']";
    public static String proceed_to_checkout_loc = "//a[@class='btn btn-default check_out']";
    public static String comment_loc = "//textarea[@name='message']";
    public static String comment = "Order placed";
    public static String place_order_btn = "//a[@class='btn btn-default check_out']";
    public static String name_on_card_loc = "//input[@name='name_on_card']";
    public static String name_on_card = "Test Card";
    public static String card_number_loc = "//input[@name='card_number']";
    public static String card_number = "4100 0000 0000";
    public static String cvc_loc = "//input[@placeholder='ex. 311']";
    public static String cvc = "123";
    public static String expiration_month_loc = "//input[@placeholder='MM']";
    public static String expiration_month = "01";
    public static String expiration_year_loc = "//input[@placeholder='YYYY']";
    public static String expiration_year = "1900";
    public static String pay_and_confirm_order_btn = "//button[@id='submit']";
    public static String success_msg_loc = "//p[normalize-space()='Congratulations! Your order has been confirmed!']";



    public static void addProductToCart(WebElement product_loc) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(women_loc)));
        driver.findElement(By.xpath(women_loc)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tops_loc)));
        driver.findElement(By.xpath(tops_loc)).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(product_loc))));
        WebElement ele1 = driver.findElement(By.xpath(String.valueOf(product_loc)));
        ele1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(add_to_cart_btn)));
        driver.findElement(By.xpath(add_to_cart_btn)).click();

    }
    public static void clickContinueShoppingButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(continue_shopping)));
        driver.findElement(By.xpath(continue_shopping)).click();
    }
    public static void viewCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(view_cart_loc)));
        driver.findElement(By.xpath(view_cart_loc)).click();
    }
    public static void clickCheckOutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(proceed_to_checkout_loc)));
        driver.findElement(By.xpath(proceed_to_checkout_loc)).click();
    }
    public static void addComment(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(comment_loc)));
        driver.findElement(By.xpath(comment_loc)).sendKeys(comment);
    }
    public static void clickPlaceOrderButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(place_order_btn)));
        driver.findElement(By.xpath(place_order_btn)).click();
    }
    public static void enterPaymentDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(name_on_card_loc)));
        driver.findElement(By.xpath(name_on_card_loc)).sendKeys(name_on_card);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(card_number_loc)));
        driver.findElement(By.xpath(card_number_loc)).sendKeys(card_number);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cvc_loc)));
        driver.findElement(By.xpath(cvc_loc)).sendKeys(cvc);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expiration_month_loc)));
        driver.findElement(By.xpath(expiration_month_loc)).sendKeys(expiration_month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(expiration_year_loc)));
        driver.findElement(By.xpath(expiration_year_loc)).sendKeys(expiration_year);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pay_and_confirm_order_btn)));
        driver.findElement(By.xpath(pay_and_confirm_order_btn)).click();
    }
    public static String isOrderSuccessful(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(success_msg_loc)));
        return driver.findElement(By.xpath(success_msg_loc)).getText();

    }



    public static void getFeaturedItems() throws InterruptedException {

        // Locate the featured items section
        List<WebElement> featureItems = driver.findElements(By.xpath(featured_items_loc));

        // List to store item labels and prices
        List<Item> items = new ArrayList<>();

//        Actions actions = new Actions(driver);



//        List<WebElement> label = driver.findElements(By.xpath(label_loc));
//        List<WebElement> price = driver.findElements(By.xpath(price_loc));
//
//        Actions actions = new Actions(driver);
//
//        for(WebElement item : label){
//            actions.moveToElement(item).perform();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(label_loc)));
//            Thread.sleep(1000);
//            String label_info = item.findElement(By.xpath(label_loc)).getText();
//
//            System.out.println(label_info);
//        }




        for (WebElement item : featureItems) {
            try {
//                actions.moveToElement(item).perform();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(label_loc)));
                String label = item.findElement(By.xpath(label_loc)).getText();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(price_loc)));
                String priceText = item.findElement(By.xpath(price_loc)).getText();

                if (priceText != null && !priceText.isEmpty()) {
                    double price = Double.parseDouble(priceText.replace("Rs.", "").trim());
                    items.add(new Item(label, price));
                } else {
                    System.out.println("Price text is empty for item: " + label);
                }
            } catch (Exception e) {
                System.out.println("Exception encountered for item: " + item);
                e.printStackTrace();
            }
        }

//         Sort items by price (low to high)
        Collections.sort(items, Comparator.comparingDouble(Item::getPrice));

        // Print the sorted items to the console
        for (Item item : items) {
            System.out.println(item.getLabel() + " Rs." + item.getPrice());
        }
    }

    // Static inner class to represent an item
    public static class Item {
        private final String label;
        private final double price;

        public Item(String label, double price) {
            this.label = label;
            this.price = price;
        }

        public String getLabel() {
            return label;
        }

        public double getPrice() {
            return price;
        }
    }
}
