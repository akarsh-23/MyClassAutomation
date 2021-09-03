package nit.myclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Connection {
	private static WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "Tool/chromedriver.exe");
		driver = new ChromeDriver();
	}
	private Connection() {}
	public static WebDriver getDriver() {
		return Connection.driver;
	}
}
