package nit.test;

import org.openqa.selenium.WebDriver;

import nit.myclass.Activity;
import nit.myclass.Connection;
import nit.myclass.JoinClass;
import nit.myclass.Login;

public class Main {
	private static WebDriver driver;
	static {
		driver = Connection.getDriver();
	}
	public static void main(String[] args) throws Exception {
		Login login=new Login(driver,"https://myclass.lpu.in","username","password");
		while(true) {
			try {
				boolean flag = login.doLogin();
				if(flag) {
					JoinClass joinclass = new JoinClass(driver);
					flag = joinclass.openTimetable();
					if(flag) {
						while(true) {
							try {
								flag = joinclass.joinRunningClass();
								if(flag) {
									Activity activity = new Activity();
									Thread.sleep(30000);
									while(true) {
										activity.raiseHand();
										System.out.println("Hand Raised");
										Thread.sleep(2000);
										activity.downHand();
										System.out.println("Hand Down");
										Thread.sleep(60000);
									}
								}
							}catch(Exception e) {
								e.printStackTrace();
								throw e;
							}
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
				Thread.sleep(60000);
				continue;
			}
		}
	}

}
