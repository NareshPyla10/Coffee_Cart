package fileReader;

public class FileReaderManager {
    private static FileReaderManager fileReaderManager;
    private PropertyFileReader propertyFileReader;
    private JsonFileReader jsonFileReader;

    private FileReaderManager(){}

    public static FileReaderManager getFileReaderManager(){
        if(fileReaderManager==null){
            fileReaderManager = new FileReaderManager();
        }
        return fileReaderManager;
    }

    public PropertyFileReader getPropertyFileReader(){
        if(propertyFileReader==null){
            propertyFileReader = new PropertyFileReader();
        }
        return propertyFileReader;
    }

    public JsonFileReader getJsonFileReader(){
        if(jsonFileReader==null){
            jsonFileReader = new JsonFileReader();
        }
        return jsonFileReader;
    }
}
