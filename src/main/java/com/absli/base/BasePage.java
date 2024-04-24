package com.absli.base;

import Utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.logging.LogManager;


import static com.absli.base.TestBase.prop;

public class BasePage {

    protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static String parameterName;

    static void setDriver() throws IOException {

        parameterName = ExcelUtils.getPlatformNameFromExcel(prop.getProperties("testExcelSheet"), "controller");


        if  (parameterName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());

        } else if (parameterName.equalsIgnoreCase("web")) {
            driver.set(new ChromeDriver());

        } else if (parameterName.equalsIgnoreCase("Safari")) {

            WebDriverManager.safaridriver().setup();
            driver.set(new SafariDriver());
        }

        else {

            System.out.println("Invalid Browser Name ");


        }


    }
    public static WebDriver getDriver() {

        return driver.get();
    }


}