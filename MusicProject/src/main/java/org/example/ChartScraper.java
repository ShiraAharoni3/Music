package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ChartScraper
{
    public static List<ChartEntry> getChartData(int year, String chartType)
    {
        System.setProperty("webdriver.openqa.driver", "C:\\Users\\משתמש\\Downloads\\chromedriver_win32\\chromeDriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://playback.fm/charts/";
        String url = baseUrl + chartType + "/" + year;

            // Set the path to your ChromeDriver executable

            // Navigate to the URL
            driver.get(url);

            // Find all table rows
            List<WebElement> rows = driver.findElements(By.tagName("tr"));

            // Initialize chart data list
            List<ChartEntry> chartData = new ArrayList<>();

            // Iterate over rows and extract data
            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                if (!columns.isEmpty()) {
                    String rank = columns.get(0).getText();
                    String title = columns.get(1).getText();
                    String artist = columns.get(2).getText();
                    chartData.add(new ChartEntry(rank, title, artist));
                }
            }

            // Close the WebDriver
            driver.quit();

            return chartData;
        }
}


