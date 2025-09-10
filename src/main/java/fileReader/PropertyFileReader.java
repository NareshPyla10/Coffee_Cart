package fileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class PropertyFileReader {

    private static final Logger logger = LogManager.getLogger(PropertyFileReader.class);

    private Properties properties;

    static String propertyFilePath = System.getProperty("user.dir").concat(File.separator).concat("src").concat(File.separator)
            .concat("test").concat(File.separator).concat("resources").concat(File.separator).concat("Sample.properties");


    public PropertyFileReader(){
        loadProperties(propertyFilePath);
    }

    public void loadProperties(String filePath){
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException("Error in loading properties from required property file");
        }
    }

    public String getProperty(String key){
       logger.info("Fetching the value for key: {} "+ key);
        return properties.getProperty(key);
    }



}
