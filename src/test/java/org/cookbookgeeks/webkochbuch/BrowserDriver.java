package org.cookbookgeeks.webkochbuch;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class BrowserDriver {

	private static WebDriver mDriver;
	
	public synchronized static WebDriver getCurrentDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
		
		
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
	
	public static void loadPage(String url){;
//		LOGGER.info("Directing browser to:" + url);
		getCurrentDriver().get(url);
	}
	
	public static void clickPage(String r){
		WebElement recipe = mDriver.findElement(By.partialLinkText(r));
		recipe.click();
	}
}
