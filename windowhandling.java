package Assignment;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		c.get("http://leaftaps.com/opentaps");
		c.findElement(By.id("username")).sendKeys("DemoCSR");
		c.findElement(By.id("password")).sendKeys("crmsfa");
		c.findElement(By.className("decorativeSubmit")).click();
		c.findElement(By.linkText("CRM/SFA")).click();
		c.findElement(By.xpath("//a[text()='Contacts']")).click();
	c.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	c.findElement(By.xpath("//img[@alt='Lookup']")).click();
	String address=c.getWindowHandle();
	c.switchTo().window(address);
	System.out.println(c.getTitle());
	Thread.sleep(2000);
	Set<String> WindowHandles=c.getWindowHandles();
	List<String> Window=new ArrayList<String>(WindowHandles);
	c.switchTo().window(Window.get(1));
	System.out.println(c.getTitle());
	c.manage().window().maximize();
	c.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
	c.switchTo().window(Window.get(0 ));
	System.out.println(c.getTitle());
	c.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> WindowHandles1=c.getWindowHandles();
	List<String> Window1=new ArrayList<String>(WindowHandles1);
	c.switchTo().window(Window1.get(1));
	System.out.println(c.getTitle());
	c.manage().window().maximize();
	Thread.sleep(3000);

	c.findElement(By.xpath("//a[text()='DemoLBCust']")).click();
	c.switchTo().window(Window1.get(0));
	c.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	Alert alert=c.switchTo().alert();
	alert.accept();
	Thread.sleep(3000);
	String title=c.getTitle();
	System.out.println(title);
	
	}

}
