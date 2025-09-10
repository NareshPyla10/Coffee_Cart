package StepDef;

import fileReader.FileReaderManager;
import pageObjectManager.PageObjectManager;
import webDriverManager.WebDriverManager;

public class TestContest {
    private PageObjectManager pageObjectManager;
    private WebDriverManager webDriverManager;
    private FileReaderManager fileReaderManager;

    public TestContest(){
        fileReaderManager = FileReaderManager.getFileReaderManager();
        webDriverManager = WebDriverManager.getWebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.createDriver(fileReaderManager.getPropertyFileReader().getProperty("browser")));
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public FileReaderManager getFileReaderManager() {
        return fileReaderManager;
    }
}
