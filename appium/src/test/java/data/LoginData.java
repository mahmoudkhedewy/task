package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

public class LoginData {
    public  String  email, password;

    public void testData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/loginData1.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;
            email = (String) person.get("email");
            password = (String) person.get("password");

        }
    }
}
