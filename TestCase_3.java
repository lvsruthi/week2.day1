package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TestCase_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriverManager.chromedriver().setup();
		ChromeDriver Driver =new ChromeDriver();
		
		//load the url
		Driver.get("http://leaftaps.com/opentaps/control/login");
		
		//maximize
		Driver.manage().window().fullscreen();
		
		//Enter credentials
		Driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		Driver.findElement(By.id("password")).sendKeys("crmsfa");
		Driver.findElement(By.className("decorativeSubmit")).click();
		
		//click CRM/SFA -> leads -> create lead
		Driver.findElement(By.linkText("CRM/SFA")).click();
		Driver.findElement(By.linkText("Leads")).click();
		Driver.findElement(By.linkText("Create Lead")).click();
		
	  	// values in create lead main page
		
		Driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Temenos");
		//print company name using getAttribute
		String company = Driver.findElement(By.id("createLeadForm_companyName")).getAttribute("value");
		System.out.println("company is "+company);

        //first name and last name
		Driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SRUTH");
		Driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Priya");
		//source
		WebElement SourceElement = Driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select source =new Select(SourceElement);
		source.selectByIndex(1);
		Driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("01/13/22");
		
		WebElement campaign = Driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select campaign_DropDown =new Select(campaign);
		campaign_DropDown.selectByValue("CATRQ_CARNDRIVER");
			
		Driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Engineer");
		Driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("200000");
		Driver.findElement(By.id("createLeadForm_description")).sendKeys("+Software Engineer");
				
		//Contact Information TAB
		Driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("5");
		Driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("2");
		Driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("+91");
		Driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Sethuram");
		Driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("lvsruthi@gmail.com");
		Driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Sethuram");
		Driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9940563498");
		Driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.google.com");
        
		//Primary Address TAB
		Driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Koushik");
		Driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Hello");
		Driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("1a, Rose Street");
		Driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Avadi chennai");
		Driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("chennai");
		
		WebElement state = Driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state_Dropdown =new Select(state);
		state_Dropdown.selectByIndex(1);
		
		WebElement country = Driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select country_Dropdown =new Select(country);
		country_Dropdown.selectByVisibleText("Andorra");
		
		Driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600071");
		Driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("1234");

		
		//click on submit
		Driver.findElement(By.name("submitButton")).click();
		
		//getting name using getText
		String Name = Driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Name is "+Name);
		
		String Title=Driver.getTitle();
		System.out.println("The title is"+Title);
		
		if(Title.contains("View Lead | opentaps CRM"))
			System.out.println("Title is correct");
		else
			System.out.println("Title is incorrect");
		//close windows
		Driver.close();
	}

}
