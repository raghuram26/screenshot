package Tools;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author raghuram
 * 
 */
public class ScreenshotTool {

	public static void main(String[] args) {

		ScreenshotTool st = new ScreenshotTool();
		String url = args[0];
		System.out.println("URL :: " + url);
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		st.screenshot(driver);
		driver.quit();
	}

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void screenshot(WebDriver driver) {
		String timeStamp = getDateTime();
		String imageName = "screenshot_" + timeStamp + ".png";
		String imagePath = new File("").getAbsolutePath() + File.separator+ "report" + File.separator + imageName;

		System.out.println("Image path :: " + imagePath);
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(imagePath));
		} catch (IOException e) {
			System.out.println("IOException occured :: ");
			e.printStackTrace();
		}
	}
}
