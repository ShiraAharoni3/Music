package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.ChartScraper.getChartData;
import static org.example.YearScraper.getYears;

public class Main {
    public static void main(String[] args)
    {
        List<String> years = getYears();
        int year = 1900;
        String chartType = "top-songs";

        List<ChartEntry> chartData = getChartData(year, chartType);

        // Print the chart data
        for (ChartEntry entry : chartData) {
            System.out.println(entry.getRank() + ": " + entry.getTitle() + " - " + entry.getArtist());
        }
    }

        // Print the years
        //for (String year : years) {
         //   System.out.println(year);
        //}
        /*System.setProperty("webdriver.openqa.driver", "C:\\Users\\משתמש\\Downloads\\chromedriver_win32\\chromeDriver.exe");
        //System.setProperty("webdriver.chrome.driver", "<COMPLETE_PATH_TO_YOUR_DRIVER>");

        // defining the options to run Chrome in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        int year = 2023;
        String chartType = "top-songs";

        List<ChartEntry> chartData = getChartData(year, chartType);

        // Print the chart data
        for (ChartEntry entry : chartData) {
            System.out.println(entry.getRank() + ": " + entry.getTitle() + " - " + entry.getArtist());
        }

        // setting the system property for the Chrome Driver


        // initializing a Selenium WebDriver ChromeDriver instance
        // to run Chrome in headless mode
        WebDriver driver = new ChromeDriver(options);


        // connecting to the target web page
        driver.get("https://playback.fm/charts/top-100-songs");

        // initializing the list of Java object to store
        // the scraped data
        //List<Integer> pokemonProducts = new ArrayList<>();
        List<String> years1 = new ArrayList<>();
        List<String> modifiedList = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector(".allYears a"));
        //List<WebElement> artists = driver.findElements(By.xpath("//span[contains(@itemprop, 'byArtist')]"));


        // Print the years
        for (WebElement element : elements) {
            String text = element.getText();
            years1.add(text);
        }
        for (String item : years1)
        {
            String ModifiedItem = item.replace("Pop Chart" ,"");
            modifiedList.add(ModifiedItem);
        }
        System.out.println(years1.size());
        for (String item : modifiedList) {
            System.out.println(item);
        }

        driver.get("https://playback.fm/charts/top-100-songs/1900");
        List<WebElement> artists =  driver.findElements(By.cssSelector(".playlist chart a"));
        List<String> topArtist = new ArrayList<>();


        // Print the years
        for (WebElement artist : artists) {
            String artistName = artist.getText();
            topArtist.add(artistName);
        }
        System.out.println(topArtist.size());


        // Print the extracted years
/*        for (String year : years) {
            System.out.println(year);
        }*/

        // Close the browser
        //driver.quit();
    }



