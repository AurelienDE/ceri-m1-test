package fr.univavignon.pokedex.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

public class CalculIVIsEasyGame {

	private Selenium selenium;
	static final String URL = "https://pokeassistant.com/main/ivcalculator?locale=fr";
	private WebDriver driver; 
	private String baseUrl; 
	private boolean acceptNextAlert = true; 
	private StringBuffer verificationErrors = new StringBuffer(); 
	  
	public CalculIVIsEasyGame(){
		
	}
	
	public void setUp() throws Exception { 
	    // On instancie notre driver, et on configure notre temps d'attente 
	    driver = new FirefoxDriver(); 
	    baseUrl = "https://pokeassistant.com/main/ivcalculator?locale=fr"; 
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  }
	
	public double findIV(String name,int cp,int hp,int dust) throws MalformedURLException, IOException, InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@class=\"tt-dataset tt-dataset-0\"]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
        Thread.sleep(500);      
        driver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
        Thread.sleep(1200);
        String percentPerfectIV = driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
        Thread.sleep(500);
        driver.quit();
        double percentPerfectIVDouble=Double.parseDouble(percentPerfectIV.replace("%", ""));
        
        return percentPerfectIVDouble;
	
	}
	
}
