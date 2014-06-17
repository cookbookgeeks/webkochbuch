package org.cookbookgeeks.webkochbuch;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class BrowserDriver {

	private static WebDriver mDriver;
	
	public synchronized static WebDriver getCurrentDriver() {
		if(System.getProperty("os.name").startsWith("Windows")) {
			// Microsoft systems:
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
		} else {
			// Unix systems (Linux/OS X/...):
			System.setProperty("webdriver.chrome.driver", "chromedriver");	
		}
		
		
		if (mDriver==null) {
			try {
					mDriver = new ChromeDriver(new ChromeOptions());
		        } finally{
		        	Runtime.getRuntime().addShutdownHook(
						new Thread(new BrowserCleanup()));
		        }
		}
		return mDriver;
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
//			logger.debug("Closing the browser");
			close();
		}
	}

	public static void close() {
		try {
			getCurrentDriver().quit();
			mDriver = null;
//			LOGGER.info("closing the browser");
		} catch (UnreachableBrowserException e) {
//			LOGGER.info("cannot close browser: unreachable browser");
		}
	}
	
	public static void searchfor(String w){
	    mDriver.findElement(By.name("s")).clear();
	    mDriver.findElement(By.name("s")).sendKeys(w);
	    mDriver.findElement(By.cssSelector("button.btn")).click();
	}
	public static void loadPage(String url){;
//		LOGGER.info("Directing browser to:" + url);
		getCurrentDriver().get(url);
	}
	
	public static String getPageLoaded(){
		return mDriver.getCurrentUrl();
	}
	
	public static boolean checkForError(){
		WebElement msg = mDriver.findElement(By.className("panel-heading"));
		if(msg.getText().equals("Fehler"))
				return true;
		else
			return false;
	}
	
	public static void clickPage(String r){
		WebElement recipe = mDriver.findElement(By.partialLinkText(r));
		recipe.click();
	}
	
	public static void clickLink(String link){
		WebElement button = mDriver.findElement(By.linkText(link));
		button.click();
	}
	
	public static void clickLinkByID(String id){
		WebElement button = mDriver.findElement(By.id(id));
		button.click();
	}
	
	public static void fillTextfield(String id, String text){
		WebElement textField = mDriver.findElement(By.id(id));
		textField.sendKeys(text);
	}
	
	public static void fillTextfieldByName(String id, String text){
		WebElement textField = mDriver.findElement(By.name(id));
		textField.sendKeys(text);
	}
	

	public static void submitFormular(){
		WebElement form = mDriver.findElement(By.id("recipeForm"));
		form.submit();
	}


	public static void login() {
	    mDriver.findElement(By.name("username")).clear();
	    mDriver.findElement(By.name("username")).sendKeys("testuser");
	    mDriver.findElement(By.name("password")).clear();
	    mDriver.findElement(By.name("password")).sendKeys("123");
	    mDriver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	public static void clickFourStars() {
	    mDriver.findElement(By.cssSelector("img[alt=\"4\"]")).click();
	}
	
//	public static boolean findText(String text){
//		List<WebElement> paragraphs;
//		paragraphs = mDriver.findElements(By.tagName("p"));
//		
//		for ( Iterator<WebElement> iterator = paragraphs.iterator(); iterator.hasNext(); ){
////			if(iterator.next().getText().endsWith(text)){
////				return true;
////			}
//			System.out.println(iterator.next().getText());
//		}
//		return false; 
//
//	}
	
}
