package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10l);


		try {
			driver.get("http://localhost:8080/animal");

			for(int i = 0; i < 5; i++){
				WebElement inputFieldAnimalName = driver.findElement(By.name("animalName"));
				WebElement inputFieldAdjective = driver.findElement(By.name("adjective"));
				inputFieldAnimalName.sendKeys("Selenium Monster");
				inputFieldAdjective.sendKeys("Brutal");
				inputFieldAdjective.submit();

//				inputFieldAdjective.clear();
//				inputFieldAnimalName.clear();
				Thread.sleep(1000);
//				List<WebElement> firstResult = wait.until(presenceOfAllElementsLocatedBy(By.className("trainingMessage")));
				List<WebElement> firstResult = driver.findElements(By.className("trainingMessage"));

				for(WebElement we : firstResult){
					System.out.println(we.getText());
				}


			}
//
//			WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h1")));
//			System.out.println(firstResult.getAttribute("textContent"));
		} finally {
			Thread.sleep(5000);
			driver.quit();
		}

//		//start the driver, open chrome to our target url
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:8080/animal");
//
//		//find the fields we want by id and fill them in
//		WebElement inputField = driver.findElement(By.id("animalText"));
//		inputField.sendKeys("Manatee");
//
//		inputField = driver.findElement(By.id("adjective"));
//		inputField.sendKeys("Whirling");
//
//		//the fields don’t clear on submit for our simple app, so just submit it 5 times
//		for(int i = 0; i < 5; i++) {
//			inputField.submit();
//
//			List<WebElement> trainingResults = driver.findElements(By.className("trainingMessage"));
//			System.out.println("trainingResults.size() = " + trainingResults.size());
//		}
//
//		// then get the element by the class conclusionMessage and print it
//		WebElement conclusionResult = driver.findElement(By.className("conclusionMessage"));
//		System.out.println("conclusionResult.getText() = " + conclusionResult.getText());
//
//		Thread.sleep(5000);
//		driver.quit();

	}




}
