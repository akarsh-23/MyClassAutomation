package nit.myclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JoinClass {
	private WebDriver driver;
	public JoinClass(WebDriver driver) {
		this.driver = driver;
	}
	public boolean openTimetable() throws Exception{
		driver.findElement(By.linkText("View Classes/Meetings")).click();
		if(driver.getTitle().equals("Timetable")){
			return true;
		}else {
			throw new Exception("Login Failed!");
		}
	}
	public boolean joinRunningClass() throws Exception{
		driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"calendar\"]/div[1]/div[3]/div[1]/button[2]")).click();
		try {
			driver.findElement(By.xpath("//tr[@style='background: green;']/td[3]/a")).click();
		}catch(Exception e) {
			throw new Exception("No Running Class Found");
		}
		driver.findElement(By.linkText("Join")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("frame");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/span/button[2]")).click();
		if(driver.getTitle().equals("CodeTantra - Teach & Learn Anywhere Platform")) {
			return true;
		}
		else {
			throw new Exception("Something went wrong! unable to join class.");
		}
	}
}
