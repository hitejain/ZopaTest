package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    Properties properties;

    public PropertyLoader()  {
        loadProperty();
    }

    public void loadProperty()  {
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/properties/testEnv.properties");
        FileInputStream fileInputStream =null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        properties =new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String property){
        return properties.getProperty(property);
    }
}


