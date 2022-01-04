package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestCase_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver Driver =new ChromeDriver();
		//load url
		Driver.get("http://leaftaps.com/opentaps/");
		
		//maximize
		Driver.manage().window().fullscreen();
		
		//enter username and password
		Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		Driver.findElement(By.className("decorativeSubmit")).click();
		
		//click CRM/SFA -> contacts tabs-> create contact
		Driver.findElement(By.linkText("CRM/SFA")).click();
		Driver.findElement(By.linkText("Contacts")).click();
	    Driver.findElement(By.linkText("Create Contact")).click();
	    
	    //fill in mandatory fields
	    Driver.findElement(By.id("firstNameField")).sendKeys("Sruthi");
	    Driver.findElement(By.id("lastNameField")).sendKeys("Priya");
	    Driver.findElement(By.name("submitButton")).click();
	    
	    //get title
	    String title = Driver.getTitle();
	    //get Firstname	using getText   
	    String Firstname= Driver.findElement(By.id("viewContact_firstName_sp")).getText();
	    
	    //printing values
	    System.out.println("First name is "+ Firstname);
	    System.out.print("Title is "+ title);
	    
	    //close windows	    
	    Driver.close();
	    
	
	}

}
