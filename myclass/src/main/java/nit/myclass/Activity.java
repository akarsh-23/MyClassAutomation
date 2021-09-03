package nit.myclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity {
	private boolean handraised;
	private static WebDriver driver;
	static {
		driver = Connection.getDriver();
	}
	public void raiseHand() {
		try {
			if(!handraised) {
				driver.findElement(By.xpath("/html/body/div/main/section/div/section[2]/div/div[1]/button")).click();
				handraised = true;
			}
		}catch(Exception e) {
			throw e;
		}
	}
	public void downHand() {
		try {
			if(handraised) {
				driver.findElement(By.xpath("/html/body/div/main/section/div/section[2]/div/div[1]/button")).click();
				handraised = false;
			}
		}catch(Exception e) {
			throw e;
		}
	}
}


