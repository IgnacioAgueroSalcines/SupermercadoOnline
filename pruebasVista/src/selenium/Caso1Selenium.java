package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;


public class Caso1Selenium {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		File file = new File("C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver = new FirefoxDriver();
		baseUrl = "http://nachopc:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testCaso1Selenium() throws Exception {
		driver.get(baseUrl + "/supermercadoOnline-web/");
		
		driver.findElement(By.name("j_idt6:j_idt9")).clear();
		driver.findElement(By.name("j_idt6:j_idt9")).sendKeys("Nacho");
		driver.findElement(By.id("j_idt6:date")).clear();
		driver.findElement(By.id("j_idt6:date")).sendKeys("05-05-2017");
		driver.findElement(By.name("j_idt6:j_idt13")).click();
		driver.findElement(By.xpath("//form[@id='formulario']/table/tbody/tr/td[3]"
				+ "")).click();
		//driver.findElement(By.linkText("\"Añadir al carro\"")).click();
		driver.findElement(By.id("j_idt6:stock")).clear();
		driver.findElement(By.id("j_idt6:stock")).sendKeys("4");
		//driver.findElement(By.linkText("AÃ±adir")).click();
		driver.findElement(By.xpath("//form[@id='anadir']/table/tbody/tr[3]/td[2]"
				+ "")).click();
		
		driver.findElement(By.linkText("Confirmar Carro")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
