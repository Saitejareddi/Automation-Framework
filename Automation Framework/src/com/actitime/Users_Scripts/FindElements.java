package com.actitime.Users_Scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.actitime.UtilLibrary.ExcelInteger;
import com.actitime.UtilLibrary.ExcelOperation;

public class FindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url= ExcelOperation.readData("WritingSheet1", 1, 0);
		String username=ExcelOperation.readData("WritingSheet1", 1, 1);
		String password=ExcelOperation.readData("WritingSheet1", 1, 2);
		
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
		 ChromeDriver rv1 = new ChromeDriver();
		 rv1.get(url);
		 rv1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 rv1.findElement(By.name("username")).sendKeys(username);
		 rv1.findElement(By.name("pwd")).sendKeys(password);
		 rv1.findElement(By.cssSelector("input[valign='absmiddle']")).click();
		 rv1.findElement(By.partialLinkText("Users")).click();
		 rv1.findElement(By.cssSelector("input[value='Add New User']")).click();
		
		 List<WebElement> a = rv1.findElements(By.cssSelector("input[type='checkbox']"));
		 for (int i = 0; i <a.size(); i++) {
			 a.get(i).click();
		}
		 List<WebElement> a1 = rv1.findElements(By.cssSelector("input[type='text']"));
		 for (int i = 0; i <a.size(); i++) {
			 if (i<4) {
				 a1.get(i).sendKeys(ExcelOperation.readData("WritingSheet", 5, i));	
			}
			 
			 else {
				a1.get(i).sendKeys(ExcelInteger.readData("WritingSheet", 5, i)+"");
			}
		}
		
		List<WebElement> a2 = rv1.findElements(By.cssSelector("input[type='password']"));
		for (int j = 0; j < a.size(); j++) {
		a2.get(j).sendKeys(ExcelOperation.readData("WritingSheet1", 9, j));
			
		}
		System.out.println("Success");
		rv1.findElement(By.xpath("input[contains(@value,'Create User']")).click();
	}

}
