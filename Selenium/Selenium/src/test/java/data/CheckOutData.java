package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class CheckOutData {
    public String firstName, lastName, ziCode;

    public void UserData() throws IOException, org.json.simple.parser.ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/checkoutData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray)  parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject jsonObject = (JSONObject)  object;

            firstName = (String) jsonObject.get("firstName");
            lastName = (String) jsonObject.get("lastName");
            ziCode = (String) jsonObject.get("zipCode");
        }
    }
}
