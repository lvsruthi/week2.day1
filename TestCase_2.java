package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestCase_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver Driver =new ChromeDriver();
		//load url
		Driver.get("http://leaftaps.com/opentaps/");
		
		//miximize screen
		Driver.manage().window().fullscreen();
		
		//enter user credentials
		Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		Driver.findElement(By.className("decorativeSubmit")).click();
		
		//click CRM/SFA -> contacts-> find contact -> email tab -> enter email -> click Find Contacts
		Driver.findElement(By.linkText("CRM/SFA")).click();
		Driver.findElement(By.linkText("Contacts")).click();
	    Driver.findElement(By.linkText("Find Contacts")).click();
	    Driver.findElement(By.linkText("Email")).click();
	    Driver.findElement(By.name("emailAddress")).sendKeys("as babu@testleaf.com");
	    Driver.findElement(By.linkText("Find Contacts")).click();
	    //close the window
	    Driver.close();
	    
	}
		
	    
		


}
