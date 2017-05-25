package tests.remoteDevices;//package <set your test package>;

import com.experitest.appium.*;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;

public class iOSTest {
    private String host = "localhost";
    private int port = 8889;
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "ios-test";
    protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        dc.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        dc.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
        dc.setCapability(SeeTestCapabilityType.USE_REMOTE_GRID, true);

        /*
            Please create a user name and password using https://experitest.com/appium-community/register
         */

        dc.setCapability(SeeTestCapabilityType.USERNAME, "");
        dc.setCapability(SeeTestCapabilityType.PASSWORD, "");

        // In case your user is assign to a single project leave empty, otherwise please specify the project name
        dc.setCapability(SeeTestCapabilityType.PROJECT_NAME, "");

        /*
            Upload your application to the cloud https://cloud.experitest.com - DOCS - https://docs.experitest.com/display/public/SC/Import+Applications
        */

        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "cloud:com.experitest.ExperiBank");
        driver = new SeeTestIOSDriver<>(new URL("https://cloud.experitest.com:443"), dc);

    }

    @Test
    public void testios_test() {
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@text='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='cancelButton']")).click();
        driver.findElement(By.xpath("//*[@text='logoutButton']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}