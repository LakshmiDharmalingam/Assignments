package Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeDriver c=new ChromeDriver();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		c.manage().window().maximize();
		c.get("https://www.amazon.in/");
		c.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus9 Pro");
		Thread.sleep(3000);
		c.findElement(By.xpath("(//div[@class='s-suggestion-container'])[1]")).click();
		String price=c.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The Price is: "+price);
		Thread.sleep(3000);
		
		WebElement rating =c.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-2-5'])[1]"));
		Actions action=new Actions(c);
		action.moveToElement(rating).perform();
		action.click(rating).perform();
		Thread.sleep(3000);
		String rate=c.findElement(By.xpath("//div[@class='a-icon-row a-spacing-small a-padding-none']")).getText();
		System.out.println(rate);
		Thread.sleep(5000);
		c.findElement(By.xpath("//span[text()='(Refurbished) OnePlus 9 Pro 5G (Morning Mist, 8GB RAM, 128GB Storage)']")).click();
		String address=c.getWindowHandle();
		c.switchTo().window(address);
		System.out.println(c.getTitle());
		Thread.sleep(2000);
		Set<String> WindowHandles=c.getWindowHandles();
		List<String> Window=new ArrayList<String>(WindowHandles);
		c.switchTo().window(Window.get(1));
		System.out.println(c.getTitle());
		WebElement productimage=c.findElement(By.id("landingImage"));
		File src=productimage.getScreenshotAs(OutputType.FILE);
		
		File dec=new File("./snapshots/image3.png");
		FileUtils.copyFile(src, dec);
		c.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		String subtotal=c.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		System.out.println("Subtotal is:"+subtotal);
		c.quit();
		
	}

}
