package firstweek;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElementByXPath("//a[text()='Women']")).perform();
		driver.findElementByLinkText("Jackets & Coats").click();
		String text = driver.findElementByClassName("title-count").getText();
		String count=text.replaceAll("\\D", "");
		int tcount = Integer.parseInt(count);
		String jaccount=driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		String jcount=jaccount.replaceAll("\\D", "");
		int jacketcount = Integer.parseInt(jcount);
		String coacount=driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String ccount=coacount.replaceAll("\\D", "");
		int coatcount = Integer.parseInt(ccount);
		System.out.println("Count is-->" +jcount+  "and"  +ccount);
        if(tcount==jacketcount+coatcount) {
			System.out.println("Count is matched ");
		}
		else {
			System.out.println("Count is not matched");
		}
        driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
        driver.findElementByXPath("//div[@class='brand-more']").click();
        driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("MANGO");
		driver.findElementByXPath("//label[@class=' common-customCheckbox']//div").click();
		driver.findElementByXPath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]").click();
		Thread.sleep(5000);
	    List<WebElement> BN = driver.findElementsByXPath("//div[@class='product-productMetaInfo']//h3[1]");
		for (WebElement brand : BN) {
			String brandName=brand.getText();
			if(brandName.equalsIgnoreCase("MANGO")) {
				System.out.println("Mango brand is selected");
				}
			}
		WebElement path = driver.findElementByXPath("//div[@class='sort-sortBy']");
		Actions builder=new Actions(driver);
		builder.moveToElement(path).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		Thread.sleep(5000);
		 List<WebElement> pricelist = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		 WebElement bestprice = pricelist.get(0);
		 System.out.println("Price is:" + bestprice.getText() );
		 builder.moveToElement(bestprice).perform();
		 
	}

}
