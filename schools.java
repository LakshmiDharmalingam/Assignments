package Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class schools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver c=new ChromeDriver();
		c.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		c.manage().window().maximize();
		//Thread.sleep(5000);
		c.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		c.switchTo().frame("iframeResult");
	c.findElement(By.xpath("//button[text()='Try it']")).click();
	Alert alert=c.switchTo().alert();
	alert.accept();
		
	}

}
