package fileReader;

import com.google.gson.Gson;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class JsonFileReader {
    private final String customerFilePath = System.getProperty("user.dir").concat(File.separator).concat("src").concat(File.separator)
            .concat("test").concat(File.separator).concat("resources").concat(File.separator).concat("testData").concat(File.separator).concat("TestData.json");
    private List<Customer> customerList;

    public JsonFileReader(){
        customerList = getCustomerData();
    }

    private List<Customer> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(customerFilePath));
            Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
            return Arrays.asList(customers);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + customerFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final Customer getCustomerByName(String customerName){
        return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
    }
}
