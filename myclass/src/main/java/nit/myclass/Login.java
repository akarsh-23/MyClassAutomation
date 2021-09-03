package nit.myclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	private String url;
	private String username;
	private String password;
	private WebDriver driver;
	public Login(WebDriver driver, String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.driver = driver;
	}
	public boolean doLogin() {
		boolean result = false;
		int count = 0;
		while(true) {
			try {
				count++;
				driver.navigate().to(this.url);
				if(driver.getTitle().equals("My Class Login - Lovely Professional University")) {
					driver.findElement(By.name("i")).sendKeys(this.username);
					driver.findElement(By.name("p")).sendKeys(this.password);
					driver.findElement(By.tagName("button")).click();
					if(driver.getTitle().equals("CodeTantra Teach & Learn Anywhere")) {
						result = true;
						break;
					}
					Thread.sleep(1000*(count*count));
				}else {
					Exception e = new Exception("Something went wrong!");
					throw e;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
