package tests;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class Books_Test extends TestBase {
    String currentTime = String.valueOf(System.currentTimeMillis());
    String id;
    io.restassured.path.json.JsonPath jsonPath;
    String token;

    @Test(priority = 1)
    public void CreateToken() throws  FileNotFoundException {
        String response =
                books_apis.PostToGetAuthentication(clientData.getData("clientName"),
                        clientData.getData("clientEmail")+currentTime+"@gmail.com")
                        .then().extract().asString();

        jsonPath = new io.restassured.path.json.JsonPath(response);
        System.out.println(response);
        token = jsonPath.getString("accessToken");
        System.out.println(token);

    }

    @Test(priority = 2)
    public void createNote() throws FileNotFoundException {
        String response =
                books_apis.CreateBook(Integer.parseInt(createBookData.getData("bookId")),
                        createBookData.getData("customerName"),token
                ).then().extract().response().asString();

        System.out.println(response);

        jsonPath = new io.restassured.path.json.JsonPath(response);
        id = jsonPath.getString("orderId");
        System.out.println(id);
        String status = jsonPath.getString("created");
        Assert.assertEquals(status,"true");

    }

    @Test(priority = 3)
    public void getNoteCreated() throws FileNotFoundException {
        String response = books_apis.getBookCreated(createBookData.getData("bookId"),token)
                .then().extract().response().asString();

        jsonPath = new JsonPath(response);
        System.out.println(response);
    }

    @Test(priority = 4)
    public void updateExistingNote() throws FileNotFoundException {
        String response =
                books_apis.UpdateCreatedBook(updateBookData.getData("customerName"),
                              id,token)
                        .then().extract().response().asString();

        jsonPath = new JsonPath(response);
        System.out.println(response);
    }

    @Test(priority = 6)
    public void DeleteNoteCreated(){
        String response =
                books_apis.deleteNoteCreated(id,token)
                        .then().extract().response().asString();

        jsonPath = new JsonPath(response);
        System.out.println(response);
    }
}
