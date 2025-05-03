package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckoutData {
    public String fullName, addressOne, addressTow, city, state, zipcode, country;

    public void testData() throws IOException, ParseException {

            String srcFile = System.getProperty("user.dir")+"/src/test/java/data/checkoutData.json";
            File file = new File(srcFile);

            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

            for (Object object : jsonArray){
                JSONObject person = (JSONObject) object;
                fullName = (String) person.get("fullName");
                addressOne = (String) person.get("addressOne");
                addressTow = (String) person.get("addressTwo");
                city = (String) person.get("city");
                state = (String) person.get("state");
                zipcode = (String) person.get("zipCode");
                country = (String) person.get("country");



            }
    }
}
