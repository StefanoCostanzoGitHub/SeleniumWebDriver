package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://fabrizio.zellini.org/tabella-conversione-miglia-orarie-chilometri-orari");
		
		// Chilometri orari per 75 miglia/orarie
		WebElement TxtBoxContent1 = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[1]/table/tbody/tr[76]/td[2]"));
		String text1 = TxtBoxContent1.getText();
		
		// Chilometri orari per 55 miglia/orarie
		WebElement TxtBoxContent2 = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/div[1]/table/tbody/tr[56]/td[2]"));
		String text2 = TxtBoxContent2.getText();	
		
		double time1 = (20 / Double.parseDouble(text1)) * 60;
		double time2 = (20 / Double.parseDouble(text2)) * 60;
		
		double risparmio = time2 - time1;
		
		System.out.println("Minuti risparmiati: " + (int)risparmio);
		
		if(risparmio < 5) {
			System.out.println("TRUE");
		}
		
		else {
			System.out.println("FALSE");
		}
		
		driver.close();
		
	}

}
