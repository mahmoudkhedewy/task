package tests;

import apis.Books_Apis;
import data.ReadData;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    Books_Apis books_apis;
    Properties properties;
    FileInputStream fileInputStream;

    ReadData clientData;
    ReadData createBookData;
    ReadData updateBookData;

    @BeforeClass
    public void setEnvironment() throws IOException {


        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        properties.load(fis);

        books_apis = new Books_Apis();
        RestAssured.baseURI = properties.getProperty("url");

        clientData = new ReadData("src/test/java/data/createClientBody.json");
        createBookData = new ReadData("src/test/java/data/bookBody.json");
        updateBookData = new ReadData("src/test/java/data/updateBody.json");
}}
