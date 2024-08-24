package WebDriverExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HiWebDriver {

	public static void main(String[] args) {
        System.out.println("OMG GITHUB");
        System.out.println("OMG GITHUB");
        System.out.println("OMG GITHUB");
        System.out.println("OMG GITHUB");
        
        try {
            WebDriver driver =  new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            String url = "https://formstone.it/components/dropdown/demo/";
                    //"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
            HiWebDriver demo = new HiWebDriver();
            demo.navigateToApp(driver, url);

            WebElement dropdown = driver.findElement(By.cssSelector("#demo_multiple-dropdown > div > div.fs-scrollbar-content"));

//            Select sli = new Select(dropdown);
//            List<WebElement> li = sli.getOptions();
            
            List<WebElement> li = dropdown.findElements(By.tagName("button"));
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.LEFT_CONTROL).perform();
            for(WebElement e: li) {
//            	
            	e.click();
            	Thread.sleep(3000);
            }
//            sli.selectByIndex(1);
//            Thread.sleep(3000);
//            sli.selectByValue("1");
//            Thread.sleep(3000);
//            sli.selectByVisibleText("Two");

//            boolean b = sli.isMultiple();
//            System.out.println(b);

            Thread.sleep(3000);
            driver.close();
            driver.quit();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
	}    

	public void navigateToApp(WebDriver driver, String url) throws InterruptedException {
		driver.navigate().to(url);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
	}

	public void logInToApp(WebDriver driver) throws InterruptedException {

		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		loginbtn.click();
		Thread.sleep(3000);
	}

	public void selectNavMenu(WebDriver driver, String menuItem) throws InterruptedException {
		List<WebElement> navMenu = driver.findElements(By.cssSelector("aside > nav > div.oxd-sidepanel-body > ul >li"));
		System.out.println(navMenu.size());
		for (WebElement e : navMenu) {
			String menutxt = e.getText();
			if (menutxt.equals(menuItem)) {
				e.click();
			}
			Thread.sleep(3000);
		}
	}

	// "//button[@type="submit"]"
	public void getCssAttribute(WebDriver driver, String locator, String cssAttribute) {
		WebElement loginbtn = driver.findElement(By.xpath(locator));
		String x1 = loginbtn.getCssValue(cssAttribute);
		System.out.println(x1);
	}

	
}
