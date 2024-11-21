package Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stubChromeDriver c=new ChromeDriver();
		ChromeDriver c=new ChromeDriver();
		c.get("https://www.snapdeal.com/");
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		c.manage().window().maximize();
		
		WebElement Men=c.findElement(By.xpath("//a[@class='menuLinks leftCategoriesProduct '][1]/span[2]"));
		Actions action=new Actions(c);
		action.moveToElement(Men).perform();
		Thread.sleep(3000);
		WebElement shoe=c.findElement(By.xpath("//span[text()='Footwear']//following::a/span"));
	action.click(shoe).perform();
	String count=c.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
	System.out.println("Items Found: "+count);
	c.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	c.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
	
	c.findElement(By.xpath("//li[@class='search-li'][1]")).click();
	
	WebElement price=c.findElement(By.name("fromVal"));
	price.clear();
	price.sendKeys("500");
	WebElement toprice=c.findElement(By.name("toVal"));
	toprice.clear();
	toprice.sendKeys("700");
	c.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
	Thread.sleep(3000);
	c.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[1]")).click();
	
	
	WebElement view=c.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
	action.moveToElement(view).perform();
	Thread.sleep(3000);
	WebElement quick=c.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]"));
	action.click(quick).perform();
	String amt=c.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
	System.out.println("Shoe Price is: "+amt);
	String dis=c.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
	System.out.println("Discount is: "+dis);
	File src=c.getScreenshotAs(OutputType.FILE);
	File dec=new File("./snapshots/image2.png");
	FileUtils.copyFile(src, dec);
	c.close();
	}

}

