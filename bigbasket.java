package Assignment;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class bigbasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		EdgeDriver c=new EdgeDriver();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		c.manage().window().maximize();
		c.get("https://www.bigbasket.com/");
		//Thread.sleep(3000);
		c.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']")).click();
		//c.findElement(By.xpath("//div[@class='grid xl:grid-flow-col lg:grid-flow-row xl:gap-x-0.7 lg:gap-x-0 text-left leading-none'][1]/span")).click();
	WebElement food=	c.findElement(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs']/li[5]"));
	Actions action=new Actions(c);
	action.moveToElement(food).perform();
	WebElement oil=c.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
	action.click(oil).perform();
	Thread.sleep(3000);
	WebElement Rice =c.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
	action.click(Rice).perform();
	c.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
	Thread.sleep(3000);
	WebElement royal=c.findElement( By.id("i-BBRoyal"));
	c.executeScript("arguments[0].click()", royal);
	boolean select=royal.isSelected();
	System.out.println(select);
	Thread.sleep(3000);c.findElement(By.xpath("(//img[@class='DeckImage___StyledImage-sc-1mdvxwk-3 cSWRCd'])[4]")).click();
	String address=c.getWindowHandle();
	c.switchTo().window(address);
	System.out.println(c.getTitle());
	Set<String> WindowHandles=c.getWindowHandles();
	List<String> Window=new ArrayList<String>(WindowHandles);
	c.switchTo().window(Window.get(1));
	Thread.sleep(3000);
	c.findElement(By.xpath("//span[text()='5 kg']//parent::div")).click();
	c.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
	Thread.sleep(3000);
	File src=c.getScreenshotAs(OutputType.FILE);
	File dec=new File("./snapshots/image1.png");
	FileUtils.copyFile(src, dec);
c.quit();


	

	}

	
	}


