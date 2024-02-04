package com.trip.prepare;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import io.github.bonigarcia.wdm.WebDriverManager;

@RestController
public class SeleniumController {	
	private static final Logger logger = LogManager.getLogger(SeleniumController.class);	
	
	@GetMapping("test")
	void test() {
		
		System.out.println("Inside test");
		// Setup ChromeDriver using WebDriverManager
		try {
        WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);	
		}catch (Exception e) {
			System.out.println("Inside Exception");
			e.printStackTrace();
			logger.info(e);
			// TODO: handle exception
		}finally {
			System.out.println("Inside finally");
			//driver.quit();
		}
	}

}
