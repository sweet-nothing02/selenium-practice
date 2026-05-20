package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Path destPath = Paths.get("build/screenshots/" + result.getName() + ".png");
                Files.createDirectories(destPath.getParent());
                Files.copy(srcFile.toPath(), destPath);
                System.out.println("Screenshot saved to: " + destPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
