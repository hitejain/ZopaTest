package util;

import com.github.opendevl.JFlat;
import org.json.JSONObject;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonHelper {

    @Test
    public static String getRandomEmail(){
        String emailDoamin="@yopmail.com";
        String email = getCurrentTimeStamp()+emailDoamin;
        return email;
    }

    public static String getCurrentTimeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("DDMMHHmmssSSS");
        Date date =new Date();
        return dateFormat.format(date);
    }
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static Boolean convertJsonToCsv(JSONObject jsonObject){
        Boolean result=false;
        JFlat flatMe = new JFlat(jsonObject.toString());
        try {
            flatMe.json2Sheet().headerSeparator().write2csv(System.getProperty("user.dir")+"/target/cucumber-report/cucumber/RandomCurrencies.csv");
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
