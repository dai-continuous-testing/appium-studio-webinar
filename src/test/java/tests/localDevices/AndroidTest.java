package tests.localDevices;//package <set your test package>;

import com.experitest.appium.SeeTestAndroidDriver;
import com.experitest.appium.SeeTestAndroidElement;
import com.experitest.appium.SeeTestCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidTest {
    private String host = "localhost";
    private int port = 8889;
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ios-test";
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver = null;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        dc.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        dc.setCapability(SeeTestCapabilityType.TEST_NAME, testName);

//        dc.setCapability(MobileCapabilityType.UDID, "S7M0215829004355");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        driver = new SeeTestAndroidDriver<>(new URL("http://" + host + ":" + port), dc);


    }

    @Test
    public void testandroid_test() {
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("compnay");
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Close']")));
        driver.findElement(By.xpath("//*[@text='Close']")).click();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}