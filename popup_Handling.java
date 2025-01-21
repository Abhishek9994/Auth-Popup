package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class popup_Handling {
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patil\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String url="http://" + "admin" + ":" +"admin" + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		driver.manage().window().maximize();
		String displayed_message=driver.findElement(By.xpath("//p")).getAttribute("innerHTML");
		
		if(displayed_message.contains("Congratulations"))
		{
			System.out.println("Authentication Successfull");
			
		}
		else
		{
			System.out.println("Authentication NOT Successfull");
		}
	
	
	if(displayed_message.contains("Congratulations"))
	{
		System.out.println("Authentication Successfull");
		
	}
	else
	{
		System.out.println("Authentication NOT Successfull");
	}
}
	

}
