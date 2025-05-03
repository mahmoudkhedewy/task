package apis;

import body.ClientBody;
import body.CreateBookBody;
import body.UpdateBookBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Books_Apis {

    public Response PostToGetAuthentication(String clientName, String clientEmail){
        ClientBody clientBody = new ClientBody();
        clientBody.setClientName(clientName);
        clientBody.setClientEmail(clientEmail);

        return RestAssured.given().log().all()
                .header("content-type","application/json")
                .header("Accept","application/json")
                .body(clientBody).when().post("/api-clients/");

    }

    public Response CreateBook(int id, String customerName,String bearerToken){
        CreateBookBody createOrderBody = new CreateBookBody();
        createOrderBody.setBookId(id);
        createOrderBody.setCustomerName(customerName);

        return RestAssured.given().log().all()
                .header("content-type","application/json")
                .header("Accept","application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(createOrderBody).when().post("/orders/");
    }

    public Response getBookCreated(String id,String bearerToken){

        return  RestAssured.given().log().all()
                .pathParam("id",id)
                .header("content-type","application/json")
                .header("Authorization", "Bearer " + bearerToken).
                when().get("/books/{id}");
    }

    public Response UpdateCreatedBook(String customerName,String id, String bearerToken){
       UpdateBookBody updateBookBody = new UpdateBookBody();
       updateBookBody.setCustomerName(customerName);

        return RestAssured.given().log().all()
                .pathParam("id",id)
                .header("content-type","application/json").
                 header("Authorization", "Bearer " + bearerToken)
                .body(updateBookBody)
                .when().patch("/orders/{id}");
    }

    public Response deleteNoteCreated(String id,String bearerToken){

        return  RestAssured.given().log().all()
                .pathParam("id",id)
                .header("content-type","application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .header("Accept","application/json")
                .when().delete("orders/{id}");
    }
}
