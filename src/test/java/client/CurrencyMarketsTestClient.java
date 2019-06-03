package client;

import io.restassured.response.Response;
import util.RestApiClient;


public class CurrencyMarketsTestClient extends RestApiClient {

    public Response getCurrencyDetails(final String url){

        return buildGetClientResponse(url);
    }


}


