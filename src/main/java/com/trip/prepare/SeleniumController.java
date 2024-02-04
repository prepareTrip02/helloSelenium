package com.trip.prepare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.bonigarcia.wdm.WebDriverManager;

@RestController
public class SeleniumController {	
	
	
	@GetMapping("test")
	void test() {
		WebDriver driver=null;
		System.out.println("Inside test");
		// Setup ChromeDriver using WebDriverManager
		try {
        WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);	
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			driver.quit();
		}
	}

}
