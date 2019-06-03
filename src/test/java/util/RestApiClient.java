package util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestApiClient {

    public Response buildGetClientResponse(final String url){
        return given().contentType(ContentType.JSON).get(url);
    }

    public Response buildPostClientResponse(final String body, final String url){
        return given().contentType(ContentType.JSON).body(body).post(url);
    }

    public Response buildPutClientResponse(final String body, final String url){
        return given().contentType(ContentType.JSON).body(body).put(url);
    }

    public Response buildPostClientResponse(final RequestSpecification requestSpecification, final String url){
        return requestSpecification.post(url);
    }


}
