package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PaymentData {
    public String fullName,cardNumber, expDate, secNumber;

    public void testData() throws IOException, ParseException {

            String srcFile = System.getProperty("user.dir")+"/src/test/java/data/paymentData.json";
            File file = new File(srcFile);

            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

            for (Object object : jsonArray){
                JSONObject person = (JSONObject) object;
                fullName = (String) person.get("fullName");
                cardNumber = (String) person.get("cardNumber");
                expDate = (String) person.get("expDate");
                secNumber = (String) person.get("secNumber");

            }
    }
}
