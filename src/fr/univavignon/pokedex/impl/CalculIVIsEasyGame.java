package fr.univavignon.pokedex.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CalculIVIsEasyGame {


	static final String URL = "https://pokeassistant.com/main/ivcalculator?locale=fr";
	private WebDriver driver; 
	private String baseUrl; 
	private boolean acceptNextAlert = true; 
	private StringBuffer verificationErrors = new StringBuffer(); 
	  
	public CalculIVIsEasyGame(){
		
	}
	
	public void setUp() throws Exception { 
	    // On instancie notre driver, et on configure notre temps d'attente 
	    this.driver = new FirefoxDriver(); 
	    this.baseUrl = "https://pokeassistant.com/main/ivcalculator?locale=fr"; 
	    this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  }
	
	public double findIV(String name,int cp,int hp,int dust) throws MalformedURLException, IOException, InterruptedException{

		this.driver.get(URL);
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
