package Practice;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import bsh.ParseException;

public class TestCalendars {
	
public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patil\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

		driver.findElement(By.id("second_date_picker")).click();
		selectDate(driver, "05/June/2021", "dd/MMM/yyyy");

		Thread.sleep(5000);
		driver.findElement(By.id("second_date_picker")).click();
		selectDate(driver, "05/Feb/2021", "dd/MMM/yyyy");

		Thread.sleep(5000);		
		driver.findElement(By.id("second_date_picker")).click();
		selectDate(driver, "15/Mar/2023", "dd/MMM/yyyy");

	}

	public static void selectDate(WebDriver driver,String targetDate, String dateFormat) throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateFormat);
		java.util.Date formattedTargetDate;
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(targetDate);
			calendar.setTime(formattedTargetDate);

			int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
			int targetMonth = calendar.get(Calendar.MONTH);
			int targetYear = calendar.get(Calendar.YEAR);

			String actualDate = driver.findElement(By.className("ui-datepicker-title")).getText(); 
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

			int actualMonth = calendar.get(Calendar.MONTH);
			int actualYear = calendar.get(Calendar.YEAR);

			while(targetMonth < actualMonth || targetYear < actualYear) {
				driver.findElement(By.className("ui-datepicker-prev")).click();
				actualDate = driver.findElement(By.className("ui-datepicker-title")).getText(); 
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			while(targetMonth > actualMonth || targetYear > actualYear) {
				driver.findElement(By.className("ui-datepicker-next")).click();
				actualDate = driver.findElement(By.className("ui-datepicker-title")).getText(); 
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()="+targetDay+"]")).click();

		} catch (java.text.ParseException e) {
			throw new Exception("Invalid date is provided, please check input date");
		}
	}


}
