 package fr.univavignon.pokedex.impl;


import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculator {

	WebDriver driver;
	String url;

	public void setUp() throws Exception { 
		//System.setProperty("webdriver.chrome.driver", "D:\\Travail\\MavenTest\\DriverOpera\\operadriver_win64\\operadriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/operadriver.exe");
		
		this.driver = new ChromeDriver();
		this.url="https://pokeassistant.com/main/ivcalculator?locale=en";
	  }
	
	public double findIV(String name,int cp,int hp,int dust) throws MalformedURLException, IOException, InterruptedException{
		this.driver.get(this.url);
        Thread.sleep(500);
        this.driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
        Thread.sleep(500);
        this.driver.findElement(By.xpath("//*[@class=\"tt-dataset tt-dataset-0\"]")).click();
        Thread.sleep(500);
        this.driver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
        Thread.sleep(500);      
        this.driver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
        Thread.sleep(500);
        this.driver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
        Thread.sleep(500);
        this.driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
        Thread.sleep(1200);
        String percentPerfectIV = this.driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
        Thread.sleep(500);
        this.driver.quit();
        double percentPerfectIVDouble=Double.parseDouble(percentPerfectIV.replace("%", ""));
        
        return percentPerfectIVDouble;
	
	}
	
	



	
}
