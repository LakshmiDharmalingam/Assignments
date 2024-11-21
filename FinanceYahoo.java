package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinanceYahoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("https://finance.yahoo.com/");
	//	c.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		c.findElement(By.xpath("//span[text()='Markets']")).click();
		c.findElement(By.xpath("//span[text()='Crypto']")).click();
		int row=c.findElements(By.xpath("//table[@class='markets-table freeze-col yf-paf8n5 fixedLayout']/tbody/tr")).size();
		System.out.println(row);
		for (int i = 1; i<=25; i++) {
			String text = c.findElement(By.xpath("//table[@class='markets-table freeze-col yf-paf8n5 fixedLayout']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(text);
	}

}
}
                                              