package tests.localDevices;//package <set your test package>;

import com.experitest.appium.SeeTestCapabilityType;
import com.experitest.appium.SeeTestIOSDriver;
import com.experitest.appium.SeeTestIOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

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
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new SeeTestIOSDriver<>(new URL("http://" + host + ":" + port), dc);


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